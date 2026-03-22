package com.ruoyi.guide.mapper;

import java.util.List;
import com.ruoyi.guide.domain.GuideSchedule;
import com.ruoyi.guide.domain.vo.GuideTaskVo;
import org.apache.ibatis.annotations.Param;

/**
 * 讲解员调度记录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface GuideScheduleMapper 
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
     * 删除讲解员调度记录
     * 
     * @param scheduleId 讲解员调度记录主键
     * @return 结果
     */
    public int deleteGuideScheduleByScheduleId(Long scheduleId);

    /**
     * 批量删除讲解员调度记录
     * 
     * @param scheduleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGuideScheduleByScheduleIds(Long[] scheduleIds);

    /**
     * 查询讲解员的任务列表
     * * @param guideId 讲解员ID
     * @return 任务列表
     */
    public List<GuideTaskVo> selectTaskListByGuideId(Long guideId);
    public List<GuideTaskVo> selectHistoryTaskListByGuideId(Long guideId);

    int acceptTask(@Param("guideId")Long userId, @Param("groupCode")String groupCode);

    int completeTask(@Param("guideId")Long userId, @Param("groupCode")String groupCode, @Param("endTime")String completeTime);

}
