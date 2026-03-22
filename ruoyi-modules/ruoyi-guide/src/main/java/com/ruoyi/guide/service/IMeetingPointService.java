package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.MeetingPoint;

/**
 * 集合点Service接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface IMeetingPointService 
{
    /**
     * 查询集合点
     * 
     * @param pointId 集合点主键
     * @return 集合点
     */
    public MeetingPoint selectMeetingPointByPointId(Long pointId);

    /**
     * 查询集合点列表
     * 
     * @param meetingPoint 集合点
     * @return 集合点集合
     */
    public List<MeetingPoint> selectMeetingPointList(MeetingPoint meetingPoint);

    /**
     * 新增集合点
     * 
     * @param meetingPoint 集合点
     * @return 结果
     */
    public int insertMeetingPoint(MeetingPoint meetingPoint);

    /**
     * 修改集合点
     * 
     * @param meetingPoint 集合点
     * @return 结果
     */
    public int updateMeetingPoint(MeetingPoint meetingPoint);

    /**
     * 批量删除集合点
     * 
     * @param pointIds 需要删除的集合点主键集合
     * @return 结果
     */
    public int deleteMeetingPointByPointIds(Long[] pointIds);

    /**
     * 删除集合点信息
     * 
     * @param pointId 集合点主键
     * @return 结果
     */
    public int deleteMeetingPointByPointId(Long pointId);
}
