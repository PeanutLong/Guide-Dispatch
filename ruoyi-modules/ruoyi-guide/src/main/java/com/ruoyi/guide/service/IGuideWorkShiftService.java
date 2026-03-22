package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.GuideWorkShift;

/**
 * 讲解员排班Service接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface IGuideWorkShiftService 
{
    /**
     * 查询讲解员排班
     * 
     * @param shiftId 讲解员排班主键
     * @return 讲解员排班
     */
    public GuideWorkShift selectGuideWorkShiftByShiftId(Long shiftId);

    /**
     * 查询讲解员排班列表
     * 
     * @param guideWorkShift 讲解员排班
     * @return 讲解员排班集合
     */
    public List<GuideWorkShift> selectGuideWorkShiftList(GuideWorkShift guideWorkShift);

    /**
     * 新增讲解员排班
     * 
     * @param guideWorkShift 讲解员排班
     * @return 结果
     */
    public int insertGuideWorkShift(GuideWorkShift guideWorkShift);

    /**
     * 修改讲解员排班
     * 
     * @param guideWorkShift 讲解员排班
     * @return 结果
     */
    public int updateGuideWorkShift(GuideWorkShift guideWorkShift);

    /**
     * 批量删除讲解员排班
     * 
     * @param shiftIds 需要删除的讲解员排班主键集合
     * @return 结果
     */
    public int deleteGuideWorkShiftByShiftIds(Long[] shiftIds);

    /**
     * 删除讲解员排班信息
     * 
     * @param shiftId 讲解员排班主键
     * @return 结果
     */
    public int deleteGuideWorkShiftByShiftId(Long shiftId);
}
