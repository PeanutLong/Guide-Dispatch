<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="讲解员姓名" prop="guideName">
        <el-input
          v-model="queryParams.guideName"
          placeholder="请输入讲解员姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工号" prop="guideCode">
        <el-input
          v-model="queryParams.guideCode"
          placeholder="请输入工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专长" prop="expertise">
        <el-input
          v-model="queryParams.expertise"
          placeholder="请输入专长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前负载" prop="currentLoad">
        <el-input
          v-model="queryParams.currentLoad"
          placeholder="请输入当前负载"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大负载容量" prop="maxLoad">
        <el-input
          v-model="queryParams.maxLoad"
          placeholder="请输入最大负载容量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属部门ID" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入所属部门ID"
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
          v-hasPermi="['guide:guide:add']"
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
          v-hasPermi="['guide:guide:edit']"
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
          v-hasPermi="['guide:guide:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['guide:guide:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="guideList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="讲解员ID" align="center" prop="guideId" />
      <el-table-column label="讲解员姓名" align="center" prop="guideName" />
      <el-table-column label="工号" align="center" prop="guideCode" />
      <el-table-column label="性别" align="center" prop="sex" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="专长" align="center" prop="expertise" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="当前负载" align="center" prop="currentLoad" />
      <el-table-column label="最大负载容量" align="center" prop="maxLoad" />
      <el-table-column label="所属部门ID" align="center" prop="deptId" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['guide:guide:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['guide:guide:remove']"
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

    <!-- 添加或修改讲解员信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="讲解员姓名" prop="guideName">
          <el-input v-model="form.guideName" placeholder="请输入讲解员姓名" />
        </el-form-item>
        <el-form-item label="工号" prop="guideCode">
          <el-input v-model="form.guideCode" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="专长" prop="expertise">
          <el-input v-model="form.expertise" placeholder="请输入专长" />
        </el-form-item>
        <el-form-item label="当前负载" prop="currentLoad">
          <el-input v-model="form.currentLoad" placeholder="请输入当前负载" />
        </el-form-item>
        <el-form-item label="最大负载容量" prop="maxLoad">
          <el-input v-model="form.maxLoad" placeholder="请输入最大负载容量" />
        </el-form-item>
        <el-form-item label="所属部门ID" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入所属部门ID" />
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
import { listGuide, getGuide, delGuide, addGuide, updateGuide } from "@/api/guide/guide"

export default {
  name: "Guide",
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
      // 讲解员信息表格数据
      guideList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        guideName: null,
        guideCode: null,
        sex: null,
        age: null,
        phone: null,
        expertise: null,
        status: null,
        currentLoad: null,
        maxLoad: null,
        deptId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        guideName: [
          { required: true, message: "讲解员姓名不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询讲解员信息列表 */
    getList() {
      this.loading = true
      listGuide(this.queryParams).then(response => {
        this.guideList = response.rows
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
        guideId: null,
        guideName: null,
        guideCode: null,
        sex: null,
        age: null,
        phone: null,
        expertise: null,
        status: null,
        currentLoad: null,
        maxLoad: null,
        deptId: null,
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
      this.ids = selection.map(item => item.guideId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加讲解员信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const guideId = row.guideId || this.ids
      getGuide(guideId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改讲解员信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.guideId != null) {
            updateGuide(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addGuide(this.form).then(response => {
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
      const guideIds = row.guideId || this.ids
      this.$modal.confirm('是否确认删除讲解员信息编号为"' + guideIds + '"的数据项？').then(function() {
        return delGuide(guideIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('guide/guide/export', {
        ...this.queryParams
      }, `guide_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>

