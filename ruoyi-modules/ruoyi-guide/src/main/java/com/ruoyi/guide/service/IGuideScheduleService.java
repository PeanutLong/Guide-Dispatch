package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.GuideSchedule;
import com.ruoyi.guide.domain.vo.GuideTaskVo;

/**
 * 讲解员调度记录Service接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface IGuideScheduleService 
{
    /**
     * 查询讲解员调度记录
     * 
     * @param scheduleId 讲解员调度记录主键
     * @return 讲解员调度记录
     */
    public GuideSchedule selectGuideScheduleByScheduleId(Long scheduleId);

    /**
     * 查询讲解员调度记录列表
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 讲解员调度记录集合
     */
    public List<GuideSchedule> selectGuideScheduleList(GuideSchedule guideSchedule);

    /**
     * 新增讲解员调度记录
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 结果
     */
    public int insertGuideSchedule(GuideSchedule guideSchedule);

    /**
     * 修改讲解员调度记录
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 结果
     */
    public int updateGuideSchedule(GuideSchedule guideSchedule);

    /**
     * 批量删除讲解员调度记录
     * 
     * @param scheduleIds 需要删除的讲解员调度记录主键集合
     * @return 结果
     */
    public int deleteGuideScheduleByScheduleIds(Long[] scheduleIds);

    /**
     * 删除讲解员调度记录信息
     * 
     * @param scheduleId 讲解员调度记录主键
     * @return 结果
     */
    public int deleteGuideScheduleByScheduleId(Long scheduleId);
    /**
     * 查询讲解员任务列表
     */
    public List<GuideTaskVo> selectTaskListByGuideId(Long guideId);

    int acceptTask(Long userId, String groupCode);

    int completeTask(Long userId, String groupCode,String completeTime);

    public List<GuideTaskVo> selectHistoryTaskListByGuideId(Long userId);

}
