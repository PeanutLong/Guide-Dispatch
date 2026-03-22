package com.ruoyi.guide.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.guide.domain.vo.GuideTaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.guide.domain.GuideSchedule;
import com.ruoyi.guide.service.IGuideScheduleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 讲解员调度记录Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/schedule")
public class GuideScheduleController extends BaseController
{
    @Autowired
    private IGuideScheduleService guideScheduleService;

    /**
     * 查询讲解员调度记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(GuideSchedule guideSchedule)
    {
        startPage();
        List<GuideSchedule> list = guideScheduleService.selectGuideScheduleList(guideSchedule);
        return getDataTable(list);
    }

    /**
     * 导出讲解员调度记录列表
     */
    @Log(title = "讲解员调度记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuideSchedule guideSchedule)
    {
        List<GuideSchedule> list = guideScheduleService.selectGuideScheduleList(guideSchedule);
        ExcelUtil<GuideSchedule> util = new ExcelUtil<GuideSchedule>(GuideSchedule.class);
        util.exportExcel(response, list, "讲解员调度记录数据");
    }

    /**
     * 获取讲解员调度记录详细信息
     */
    @GetMapping(value = "/{scheduleId}")
    public AjaxResult getInfo(@PathVariable("scheduleId") Long scheduleId)
    {
        return success(guideScheduleService.selectGuideScheduleByScheduleId(scheduleId));
    }

    /**
     * 新增讲解员调度记录
     */
    @RequiresPermissions("guide:schedule:add")
    @Log(title = "讲解员调度记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuideSchedule guideSchedule)
    {
        return toAjax(guideScheduleService.insertGuideSchedule(guideSchedule));
    }

    /**
     * 修改讲解员调度记录
     */
    @RequiresPermissions("guide:schedule:edit")
    @Log(title = "讲解员调度记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuideSchedule guideSchedule)
    {
        return toAjax(guideScheduleService.updateGuideSchedule(guideSchedule));
    }

    /**
     * 删除讲解员调度记录
     */
    @RequiresPermissions("guide:schedule:remove")
    @Log(title = "讲解员调度记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scheduleIds}")
    public AjaxResult remove(@PathVariable Long[] scheduleIds)
    {
        return toAjax(guideScheduleService.deleteGuideScheduleByScheduleIds(scheduleIds));
    }

    @GetMapping("/myTaskList")
    public AjaxResult getTaskList()
    {
        Long userId = SecurityUtils.getUserId();
        List<GuideTaskVo> list = guideScheduleService.selectTaskListByGuideId(userId);
        return success(list);
    }
    @GetMapping("/historyTaskList")
    public AjaxResult getHistoryTaskList()
    {
        Long userId = SecurityUtils.getUserId();
        List<GuideTaskVo> list = guideScheduleService.selectHistoryTaskListByGuideId(userId);
        return success(list);
    }



    @Log(title = "讲解员调度记录", businessType = BusinessType.UPDATE)
    @PostMapping("/acceptTask")
    public AjaxResult acceptTask(@RequestParam("groupCode") String groupCode)
    {
        Long userId = SecurityUtils.getUserId();
        return toAjax(guideScheduleService.acceptTask(userId, groupCode));
    }
    @PostMapping("/completeTask")
    public AjaxResult completeTask(@RequestParam("groupCode") String groupCode)
    {
        Long userId = SecurityUtils.getUserId();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = now.format(formatter);
        AjaxResult ajax = toAjax(guideScheduleService.completeTask(userId, groupCode,formatted));
        return ajax;
    }

}
