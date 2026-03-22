package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.MeetingPointMapper;
import com.ruoyi.guide.domain.MeetingPoint;
import com.ruoyi.guide.service.IMeetingPointService;

/**
 * 集合点Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class MeetingPointServiceImpl implements IMeetingPointService 
{
    @Autowired
    private MeetingPointMapper meetingPointMapper;

    /**
     * 查询集合点
     * 
     * @param pointId 集合点主键
     * @return 集合点
     */
    @Override
    public MeetingPoint selectMeetingPointByPointId(Long pointId)
    {
        return meetingPointMapper.selectMeetingPointByPointId(pointId);
    }

    /**
     * 查询集合点列表
     * 
     * @param meetingPoint 集合点
     * @return 集合点
     */
    @Override
    public List<MeetingPoint> selectMeetingPointList(MeetingPoint meetingPoint)
    {
        return meetingPointMapper.selectMeetingPointList(meetingPoint);
    }

    /**
     * 新增集合点
     * 
     * @param meetingPoint 集合点
     * @return 结果
     */
    @Override
    public int insertMeetingPoint(MeetingPoint meetingPoint)
    {
        meetingPoint.setCreateTime(DateUtils.getNowDate());
        return meetingPointMapper.insertMeetingPoint(meetingPoint);
    }

    /**
     * 修改集合点
     * 
     * @param meetingPoint 集合点
     * @return 结果
     */
    @Override
    public int updateMeetingPoint(MeetingPoint meetingPoint)
    {
        meetingPoint.setUpdateTime(DateUtils.getNowDate());
        return meetingPointMapper.updateMeetingPoint(meetingPoint);
    }

    /**
     * 批量删除集合点
     * 
     * @param pointIds 需要删除的集合点主键
     * @return 结果
     */
    @Override
    public int deleteMeetingPointByPointIds(Long[] pointIds)
    {
        return meetingPointMapper.deleteMeetingPointByPointIds(pointIds);
    }

    /**
     * 删除集合点信息
     * 
     * @param pointId 集合点主键
     * @return 结果
     */
    @Override
    public int deleteMeetingPointByPointId(Long pointId)
    {
        return meetingPointMapper.deleteMeetingPointByPointId(pointId);
    }
}
