package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.GuideWorkShiftMapper;
import com.ruoyi.guide.domain.GuideWorkShift;
import com.ruoyi.guide.service.IGuideWorkShiftService;

/**
 * 讲解员排班Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class GuideWorkShiftServiceImpl implements IGuideWorkShiftService 
{
    @Autowired
    private GuideWorkShiftMapper guideWorkShiftMapper;

    /**
     * 查询讲解员排班
     * 
     * @param shiftId 讲解员排班主键
     * @return 讲解员排班
     */
    @Override
    public GuideWorkShift selectGuideWorkShiftByShiftId(Long shiftId)
    {
        return guideWorkShiftMapper.selectGuideWorkShiftByShiftId(shiftId);
    }

    /**
     * 查询讲解员排班列表
     * 
     * @param guideWorkShift 讲解员排班
     * @return 讲解员排班
     */
    @Override
    public List<GuideWorkShift> selectGuideWorkShiftList(GuideWorkShift guideWorkShift)
    {
        return guideWorkShiftMapper.selectGuideWorkShiftList(guideWorkShift);
    }

    /**
     * 新增讲解员排班
     * 
     * @param guideWorkShift 讲解员排班
     * @return 结果
     */
    @Override
    public int insertGuideWorkShift(GuideWorkShift guideWorkShift)
    {
        guideWorkShift.setCreateTime(DateUtils.getNowDate());
        return guideWorkShiftMapper.insertGuideWorkShift(guideWorkShift);
    }

    /**
     * 修改讲解员排班
     * 
     * @param guideWorkShift 讲解员排班
     * @return 结果
     */
    @Override
    public int updateGuideWorkShift(GuideWorkShift guideWorkShift)
    {
        guideWorkShift.setUpdateTime(DateUtils.getNowDate());
        return guideWorkShiftMapper.updateGuideWorkShift(guideWorkShift);
    }

    /**
     * 批量删除讲解员排班
     * 
     * @param shiftIds 需要删除的讲解员排班主键
     * @return 结果
     */
    @Override
    public int deleteGuideWorkShiftByShiftIds(Long[] shiftIds)
    {
        return guideWorkShiftMapper.deleteGuideWorkShiftByShiftIds(shiftIds);
    }

    /**
     * 删除讲解员排班信息
     * 
     * @param shiftId 讲解员排班主键
     * @return 结果
     */
    @Override
    public int deleteGuideWorkShiftByShiftId(Long shiftId)
    {
        return guideWorkShiftMapper.deleteGuideWorkShiftByShiftId(shiftId);
    }
}
