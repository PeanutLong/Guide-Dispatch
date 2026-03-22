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
import com.ruoyi.guide.domain.MeetingPoint;
import com.ruoyi.guide.service.IMeetingPointService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 集合点Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/point")
public class MeetingPointController extends BaseController
{
    @Autowired
    private IMeetingPointService meetingPointService;

    /**
     * 查询集合点列表
     */
    @RequiresPermissions("guide:point:list")
    @GetMapping("/list")
    public TableDataInfo list(MeetingPoint meetingPoint)
    {
        startPage();
        List<MeetingPoint> list = meetingPointService.selectMeetingPointList(meetingPoint);
        return getDataTable(list);
    }

    /**
     * 导出集合点列表
     */
    @RequiresPermissions("guide:point:export")
    @Log(title = "集合点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MeetingPoint meetingPoint)
    {
        List<MeetingPoint> list = meetingPointService.selectMeetingPointList(meetingPoint);
        ExcelUtil<MeetingPoint> util = new ExcelUtil<MeetingPoint>(MeetingPoint.class);
        util.exportExcel(response, list, "集合点数据");
    }

    /**
     * 获取集合点详细信息
     */
    @RequiresPermissions("guide:point:query")
    @GetMapping(value = "/{pointId}")
    public AjaxResult getInfo(@PathVariable("pointId") Long pointId)
    {
        return success(meetingPointService.selectMeetingPointByPointId(pointId));
    }

    /**
     * 新增集合点
     */
    @RequiresPermissions("guide:point:add")
    @Log(title = "集合点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MeetingPoint meetingPoint)
    {
        return toAjax(meetingPointService.insertMeetingPoint(meetingPoint));
    }

    /**
     * 修改集合点
     */
    @RequiresPermissions("guide:point:edit")
    @Log(title = "集合点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MeetingPoint meetingPoint)
    {
        return toAjax(meetingPointService.updateMeetingPoint(meetingPoint));
    }

    /**
     * 删除集合点
     */
    @RequiresPermissions("guide:point:remove")
    @Log(title = "集合点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pointIds}")
    public AjaxResult remove(@PathVariable Long[] pointIds)
    {
        return toAjax(meetingPointService.deleteMeetingPointByPointIds(pointIds));
    }
}
