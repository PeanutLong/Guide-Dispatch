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
import com.ruoyi.guide.domain.ScheduleRule;
import com.ruoyi.guide.service.IScheduleRuleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 负载均衡规则配置Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/rule")
public class ScheduleRuleController extends BaseController
{
    @Autowired
    private IScheduleRuleService scheduleRuleService;

    /**
     * 查询负载均衡规则配置列表
     */
    @RequiresPermissions("guide:rule:list")
    @GetMapping("/list")
    public TableDataInfo list(ScheduleRule scheduleRule)
    {
        startPage();
        List<ScheduleRule> list = scheduleRuleService.selectScheduleRuleList(scheduleRule);
        return getDataTable(list);
    }

    /**
     * 导出负载均衡规则配置列表
     */
    @RequiresPermissions("guide:rule:export")
    @Log(title = "负载均衡规则配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScheduleRule scheduleRule)
    {
        List<ScheduleRule> list = scheduleRuleService.selectScheduleRuleList(scheduleRule);
        ExcelUtil<ScheduleRule> util = new ExcelUtil<ScheduleRule>(ScheduleRule.class);
        util.exportExcel(response, list, "负载均衡规则配置数据");
    }

    /**
     * 获取负载均衡规则配置详细信息
     */
    @RequiresPermissions("guide:rule:query")
    @GetMapping(value = "/{ruleId}")
    public AjaxResult getInfo(@PathVariable("ruleId") Long ruleId)
    {
        return success(scheduleRuleService.selectScheduleRuleByRuleId(ruleId));
    }

    /**
     * 新增负载均衡规则配置
     */
    @RequiresPermissions("guide:rule:add")
    @Log(title = "负载均衡规则配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScheduleRule scheduleRule)
    {
        return toAjax(scheduleRuleService.insertScheduleRule(scheduleRule));
    }

    /**
     * 修改负载均衡规则配置
     */
    @RequiresPermissions("guide:rule:edit")
    @Log(title = "负载均衡规则配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScheduleRule scheduleRule)
    {
        return toAjax(scheduleRuleService.updateScheduleRule(scheduleRule));
    }

    /**
     * 删除负载均衡规则配置
     */
    @RequiresPermissions("guide:rule:remove")
    @Log(title = "负载均衡规则配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ruleIds}")
    public AjaxResult remove(@PathVariable Long[] ruleIds)
    {
        return toAjax(scheduleRuleService.deleteScheduleRuleByRuleIds(ruleIds));
    }
}
