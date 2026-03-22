<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="团号" prop="groupCode">
        <el-input
          v-model="queryParams.groupCode"
          placeholder="请输入团号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="游客人数" prop="touristCount">
        <el-input
          v-model="queryParams.touristCount"
          placeholder="请输入游客人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达时间" prop="arrivalTime">
        <el-date-picker clearable
                        v-model="queryParams.arrivalTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="预计离开时间" prop="departureTime">
        <el-date-picker clearable
                        v-model="queryParams.departureTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择预计离开时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="语言需求" prop="languagePreference">
        <el-input
          v-model="queryParams.languagePreference"
          placeholder="请输入语言需求"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="路线ID" prop="routeId">
        <el-input
          v-model="queryParams.routeId"
          placeholder="请输入路线ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集合点ID" prop="pointId">
        <el-input
          v-model="queryParams.pointId"
          placeholder="请输入集合点ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已分配讲解员ID" prop="assignedGuideId">
        <el-input
          v-model="queryParams.assignedGuideId"
          placeholder="请输入已分配讲解员ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['guide:group:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['guide:group:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['guide:group:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['guide:group:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="游客团ID" align="center" prop="groupId" />
      <el-table-column label="团号" align="center" prop="groupCode" />
      <el-table-column label="游客人数" align="center" prop="touristCount" />
      <el-table-column label="到达时间" align="center" prop="arrivalTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arrivalTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预计离开时间" align="center" prop="departureTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departureTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="语言需求" align="center" prop="languagePreference" />
      <el-table-column label="路线ID" align="center" prop="routeId" />
      <el-table-column label="集合点ID" align="center" prop="pointId" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="已分配讲解员ID" align="center" prop="assignedGuideId" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['guide:group:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['guide:group:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改游客团信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="团号" prop="groupCode">
          <el-input v-model="form.groupCode" placeholder="请输入团号" />
        </el-form-item>
        <el-form-item label="游客人数" prop="touristCount">
          <el-input v-model="form.touristCount" placeholder="请输入游客人数" />
        </el-form-item>
        <el-form-item label="到达时间" prop="arrivalTime">
          <el-date-picker clearable
                          v-model="form.arrivalTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择到达时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预计离开时间" prop="departureTime">
          <el-date-picker clearable
                          v-model="form.departureTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择预计离开时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="语言需求" prop="languagePreference">
          <el-input v-model="form.languagePreference" placeholder="请输入语言需求" />
        </el-form-item>
        <el-form-item label="路线ID" prop="routeId">
          <el-input v-model="form.routeId" placeholder="请输入路线ID" />
        </el-form-item>
        <el-form-item label="集合点ID" prop="pointId">
          <el-input v-model="form.pointId" placeholder="请输入集合点ID" />
        </el-form-item>
        <el-form-item label="已分配讲解员ID" prop="assignedGuideId">
          <el-input v-model="form.assignedGuideId" placeholder="请输入已分配讲解员ID" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listGroup, getGroup, delGroup, addGroup, updateGroup } from "@/api/guide/group"

export default {
  name: "Group",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 游客团信息表格数据
      groupList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupCode: null,
        touristCount: null,
        arrivalTime: null,
        departureTime: null,
        languagePreference: null,
        routeId: null,
        pointId: null,
        status: null,
        assignedGuideId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        groupCode: [
          { required: true, message: "团号不能为空", trigger: "blur" }
        ],
        touristCount: [
          { required: true, message: "游客人数不能为空", trigger: "blur" }
        ],
        arrivalTime: [
          { required: true, message: "到达时间不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询游客团信息列表 */
    getList() {
      this.loading = true
      listGroup(this.queryParams).then(response => {
        this.groupList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        groupId: null,
        groupCode: null,
        touristCount: null,
        arrivalTime: null,
        departureTime: null,
        languagePreference: null,
        routeId: null,
        pointId: null,
        status: null,
        assignedGuideId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        delFlag: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.groupId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加游客团信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const groupId = row.groupId || this.ids
      getGroup(groupId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改游客团信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.groupId != null) {
            updateGroup(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addGroup(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const groupIds = row.groupId || this.ids
      this.$modal.confirm('是否确认删除游客团信息编号为"' + groupIds + '"的数据项？').then(function() {
        return delGroup(groupIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('guide/group/export', {
        ...this.queryParams
      }, `group_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
