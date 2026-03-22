package com.ruoyi.guide.controller;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.utils.SecurityUtils;
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
import com.ruoyi.guide.domain.GuideWorkShift;
import com.ruoyi.guide.service.IGuideWorkShiftService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 讲解员排班Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/shift")
public class GuideWorkShiftController extends BaseController
{
    @Autowired
    private IGuideWorkShiftService guideWorkShiftService;

    /**
     * 查询讲解员排班列表
     */
    @RequiresPermissions("guide:shift:list")
    @GetMapping("/list")
    public TableDataInfo list(GuideWorkShift guideWorkShift)
    {
        startPage();
        List<GuideWorkShift> list = guideWorkShiftService.selectGuideWorkShiftList(guideWorkShift);
        return getDataTable(list);
    }

    /**
     * 导出讲解员排班列表
     */
    @RequiresPermissions("guide:shift:export")
    @Log(title = "讲解员排班", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuideWorkShift guideWorkShift)
    {
        List<GuideWorkShift> list = guideWorkShiftService.selectGuideWorkShiftList(guideWorkShift);
        ExcelUtil<GuideWorkShift> util = new ExcelUtil<GuideWorkShift>(GuideWorkShift.class);
        util.exportExcel(response, list, "讲解员排班数据");
    }

    /**
     * 获取讲解员排班详细信息
     */
    @RequiresPermissions("guide:shift:query")
    @GetMapping(value = "/{shiftId}")
    public AjaxResult getInfo(@PathVariable("shiftId") Long shiftId)
    {
        return success(guideWorkShiftService.selectGuideWorkShiftByShiftId(shiftId));
    }

    /**
     * 新增讲解员排班
     */
    @RequiresPermissions("guide:shift:add")
    @Log(title = "讲解员排班", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuideWorkShift guideWorkShift)
    {
        return toAjax(guideWorkShiftService.insertGuideWorkShift(guideWorkShift));
    }

    /**
     * 修改讲解员排班
     */
    @RequiresPermissions("guide:shift:edit")
    @Log(title = "讲解员排班", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuideWorkShift guideWorkShift)
    {
        return toAjax(guideWorkShiftService.updateGuideWorkShift(guideWorkShift));
    }

    /**
     * 删除讲解员排班
     */
    @RequiresPermissions("guide:shift:remove")
    @Log(title = "讲解员排班", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shiftIds}")
    public AjaxResult remove(@PathVariable Long[] shiftIds)
    {
        return toAjax(guideWorkShiftService.deleteGuideWorkShiftByShiftIds(shiftIds));
    }

    @GetMapping("/myList")
    public AjaxResult getMyShifts()
    {
        // 1. 从 ThreadLocal 获取当前登录用户的ID
        Long userId = SecurityUtils.getUserId();

        // 2. 构造查询条件
        GuideWorkShift query = new GuideWorkShift();
        query.setGuideId(userId); // 设置讲解员ID为当前用户ID

        // 3. 复用现有的 Service/Mapper 方法查询列表
        List<GuideWorkShift> list = guideWorkShiftService.selectGuideWorkShiftList(query);

        // 4. 提取你需要的指定字段 (shiftDate, shiftType, startTime, endTime, status)
        List<Map<String, Object>> resultList = list.stream().map(shift -> {
            Map<String, Object> map = new HashMap<>();
            map.put("shiftDate", shift.getShiftDate());
            map.put("shiftType", shift.getShiftType());
            map.put("startTime", shift.getStartTime());
            map.put("endTime", shift.getEndTime());
            map.put("status", shift.getStatus());
            return map;
        }).collect(Collectors.toList());

        return success(resultList);
    }
}
