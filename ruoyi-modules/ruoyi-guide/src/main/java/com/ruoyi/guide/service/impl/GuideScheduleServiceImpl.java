package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.guide.domain.vo.GuideTaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.GuideScheduleMapper;
import com.ruoyi.guide.domain.GuideSchedule;
import com.ruoyi.guide.service.IGuideScheduleService;

/**
 * 讲解员调度记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class GuideScheduleServiceImpl implements IGuideScheduleService 
{
    @Autowired
    private GuideScheduleMapper guideScheduleMapper;

    /**
     * 查询讲解员调度记录
     * 
     * @param scheduleId 讲解员调度记录主键
     * @return 讲解员调度记录
     */
    @Override
    public GuideSchedule selectGuideScheduleByScheduleId(Long scheduleId)
    {
        return guideScheduleMapper.selectGuideScheduleByScheduleId(scheduleId);
    }

    /**
     * 查询讲解员调度记录列表
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 讲解员调度记录
     */
    @Override
    public List<GuideSchedule> selectGuideScheduleList(GuideSchedule guideSchedule)
    {
        return guideScheduleMapper.selectGuideScheduleList(guideSchedule);
    }

    /**
     * 新增讲解员调度记录
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 结果
     */
    @Override
    public int insertGuideSchedule(GuideSchedule guideSchedule)
    {
        guideSchedule.setCreateTime(DateUtils.getNowDate());
        return guideScheduleMapper.insertGuideSchedule(guideSchedule);
    }

    /**
     * 修改讲解员调度记录
     * 
     * @param guideSchedule 讲解员调度记录
     * @return 结果
     */
    @Override
    public int updateGuideSchedule(GuideSchedule guideSchedule)
    {
        guideSchedule.setUpdateTime(DateUtils.getNowDate());
        return guideScheduleMapper.updateGuideSchedule(guideSchedule);
    }

    /**
     * 批量删除讲解员调度记录
     * 
     * @param scheduleIds 需要删除的讲解员调度记录主键
     * @return 结果
     */
    @Override
    public int deleteGuideScheduleByScheduleIds(Long[] scheduleIds)
    {
        return guideScheduleMapper.deleteGuideScheduleByScheduleIds(scheduleIds);
    }

    /**
     * 删除讲解员调度记录信息
     * 
     * @param scheduleId 讲解员调度记录主键
     * @return 结果
     */
    @Override
    public int deleteGuideScheduleByScheduleId(Long scheduleId)
    {
        return guideScheduleMapper.deleteGuideScheduleByScheduleId(scheduleId);
    }
    @Override
    public List<GuideTaskVo> selectTaskListByGuideId(Long guideId) {
        return guideScheduleMapper.selectTaskListByGuideId(guideId);
    }

    @Override
    public int acceptTask(Long userId, String groupCode) {
        return guideScheduleMapper.acceptTask(userId, groupCode);
    }

    @Override
    public int completeTask(Long userId, String groupCode, String completeTime) {
        return guideScheduleMapper.completeTask(userId, groupCode,completeTime);
    }

    @Override
    public List<GuideTaskVo> selectHistoryTaskListByGuideId(Long guideId) {
        return guideScheduleMapper.selectHistoryTaskListByGuideId(guideId);
    }
}
