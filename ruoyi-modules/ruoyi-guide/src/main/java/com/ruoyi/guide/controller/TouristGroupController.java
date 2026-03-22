package com.ruoyi.guide.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.guide.domain.TouristGroup;
import com.ruoyi.guide.service.ITouristGroupService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 游客团信息Controller
 *
 * @author ruoyi
 * @date 2026-03-19
 */
@RestController
@RequestMapping("/group")
public class TouristGroupController extends BaseController
{
    @Autowired
    private ITouristGroupService touristGroupService;

    /**
     * 查询游客团信息列表
     */
    @RequiresPermissions("guide:group:list")
    @GetMapping("/list")
    public TableDataInfo list(TouristGroup touristGroup)
    {
        startPage();
        List<TouristGroup> list = touristGroupService.selectTouristGroupList(touristGroup);
        return getDataTable(list);
    }

    /**
     * 导出游客团信息列表
     */
    @RequiresPermissions("guide:group:export")
    @Log(title = "游客团信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TouristGroup touristGroup)
    {
        List<TouristGroup> list = touristGroupService.selectTouristGroupList(touristGroup);
        ExcelUtil<TouristGroup> util = new ExcelUtil<TouristGroup>(TouristGroup.class);
        util.exportExcel(response, list, "游客团信息数据");
    }

    /**
     * 获取游客团信息详细信息
     */
    @RequiresPermissions("guide:group:query")
    @GetMapping(value = "/{groupId}")
    public AjaxResult getInfo(@PathVariable("groupId") Long groupId)
    {
        return success(touristGroupService.selectTouristGroupByGroupId(groupId));
    }

    /**
     * 新增游客团信息
     */
    @RequiresPermissions("guide:group:add")
    @Log(title = "游客团信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TouristGroup touristGroup)
    {
        return toAjax(touristGroupService.insertTouristGroup(touristGroup));
    }

    /**
     * 修改游客团信息
     */
    @RequiresPermissions("guide:group:edit")
    @Log(title = "游客团信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TouristGroup touristGroup)
    {
        return toAjax(touristGroupService.updateTouristGroup(touristGroup));
    }

    /**
     * 删除游客团信息
     */
    @RequiresPermissions("guide:group:remove")
    @Log(title = "游客团信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{groupIds}")
    public AjaxResult remove(@PathVariable Long[] groupIds)
    {
        return toAjax(touristGroupService.deleteTouristGroupByGroupIds(groupIds));
    }
}
