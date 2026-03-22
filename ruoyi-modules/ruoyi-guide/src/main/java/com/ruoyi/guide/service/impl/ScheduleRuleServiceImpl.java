package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.ScheduleRuleMapper;
import com.ruoyi.guide.domain.ScheduleRule;
import com.ruoyi.guide.service.IScheduleRuleService;

/**
 * 负载均衡规则配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class ScheduleRuleServiceImpl implements IScheduleRuleService 
{
    @Autowired
    private ScheduleRuleMapper scheduleRuleMapper;

    /**
     * 查询负载均衡规则配置
     * 
     * @param ruleId 负载均衡规则配置主键
     * @return 负载均衡规则配置
     */
    @Override
    public ScheduleRule selectScheduleRuleByRuleId(Long ruleId)
    {
        return scheduleRuleMapper.selectScheduleRuleByRuleId(ruleId);
    }

    /**
     * 查询负载均衡规则配置列表
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 负载均衡规则配置
     */
    @Override
    public List<ScheduleRule> selectScheduleRuleList(ScheduleRule scheduleRule)
    {
        return scheduleRuleMapper.selectScheduleRuleList(scheduleRule);
    }

    /**
     * 新增负载均衡规则配置
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 结果
     */
    @Override
    public int insertScheduleRule(ScheduleRule scheduleRule)
    {
        scheduleRule.setCreateTime(DateUtils.getNowDate());
        return scheduleRuleMapper.insertScheduleRule(scheduleRule);
    }

    /**
     * 修改负载均衡规则配置
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 结果
     */
    @Override
    public int updateScheduleRule(ScheduleRule scheduleRule)
    {
        scheduleRule.setUpdateTime(DateUtils.getNowDate());
        return scheduleRuleMapper.updateScheduleRule(scheduleRule);
    }

    /**
     * 批量删除负载均衡规则配置
     * 
     * @param ruleIds 需要删除的负载均衡规则配置主键
     * @return 结果
     */
    @Override
    public int deleteScheduleRuleByRuleIds(Long[] ruleIds)
    {
        return scheduleRuleMapper.deleteScheduleRuleByRuleIds(ruleIds);
    }

    /**
     * 删除负载均衡规则配置信息
     * 
     * @param ruleId 负载均衡规则配置主键
     * @return 结果
     */
    @Override
    public int deleteScheduleRuleByRuleId(Long ruleId)
    {
        return scheduleRuleMapper.deleteScheduleRuleByRuleId(ruleId);
    }
}
