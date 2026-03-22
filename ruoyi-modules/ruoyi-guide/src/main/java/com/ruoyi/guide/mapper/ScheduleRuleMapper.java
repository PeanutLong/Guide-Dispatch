package com.ruoyi.guide.mapper;

import java.util.List;
import com.ruoyi.guide.domain.ScheduleRule;

/**
 * 负载均衡规则配置Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface ScheduleRuleMapper 
{
    /**
     * 查询负载均衡规则配置
     * 
     * @param ruleId 负载均衡规则配置主键
     * @return 负载均衡规则配置
     */
    public ScheduleRule selectScheduleRuleByRuleId(Long ruleId);

    /**
     * 查询负载均衡规则配置列表
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 负载均衡规则配置集合
     */
    public List<ScheduleRule> selectScheduleRuleList(ScheduleRule scheduleRule);

    /**
     * 新增负载均衡规则配置
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 结果
     */
    public int insertScheduleRule(ScheduleRule scheduleRule);

    /**
     * 修改负载均衡规则配置
     * 
     * @param scheduleRule 负载均衡规则配置
     * @return 结果
     */
    public int updateScheduleRule(ScheduleRule scheduleRule);

    /**
     * 删除负载均衡规则配置
     * 
     * @param ruleId 负载均衡规则配置主键
     * @return 结果
     */
    public int deleteScheduleRuleByRuleId(Long ruleId);

    /**
     * 批量删除负载均衡规则配置
     * 
     * @param ruleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScheduleRuleByRuleIds(Long[] ruleIds);
}
