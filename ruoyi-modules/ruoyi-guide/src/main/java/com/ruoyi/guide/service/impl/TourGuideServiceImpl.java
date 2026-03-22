package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.TourGuideMapper;
import com.ruoyi.guide.domain.TourGuide;
import com.ruoyi.guide.service.ITourGuideService;

/**
 * 讲解员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class TourGuideServiceImpl implements ITourGuideService 
{
    @Autowired
    private TourGuideMapper tourGuideMapper;

    /**
     * 查询讲解员信息
     * 
     * @param guideId 讲解员信息主键
     * @return 讲解员信息
     */
    @Override
    public TourGuide selectTourGuideByGuideId(Long guideId)
    {
        return tourGuideMapper.selectTourGuideByGuideId(guideId);
    }

    /**
     * 查询讲解员信息列表
     * 
     * @param tourGuide 讲解员信息
     * @return 讲解员信息
     */
    @Override
    public List<TourGuide> selectTourGuideList(TourGuide tourGuide)
    {
        return tourGuideMapper.selectTourGuideList(tourGuide);
    }

    /**
     * 新增讲解员信息
     * 
     * @param tourGuide 讲解员信息
     * @return 结果
     */
    @Override
    public int insertTourGuide(TourGuide tourGuide)
    {
        tourGuide.setCreateTime(DateUtils.getNowDate());
        return tourGuideMapper.insertTourGuide(tourGuide);
    }

    /**
     * 修改讲解员信息
     * 
     * @param tourGuide 讲解员信息
     * @return 结果
     */
    @Override
    public int updateTourGuide(TourGuide tourGuide)
    {
        tourGuide.setUpdateTime(DateUtils.getNowDate());
        return tourGuideMapper.updateTourGuide(tourGuide);
    }

    /**
     * 批量删除讲解员信息
     * 
     * @param guideIds 需要删除的讲解员信息主键
     * @return 结果
     */
    @Override
    public int deleteTourGuideByGuideIds(Long[] guideIds)
    {
        return tourGuideMapper.deleteTourGuideByGuideIds(guideIds);
    }

    /**
     * 删除讲解员信息信息
     * 
     * @param guideId 讲解员信息主键
     * @return 结果
     */
    @Override
    public int deleteTourGuideByGuideId(Long guideId)
    {
        return tourGuideMapper.deleteTourGuideByGuideId(guideId);
    }
}
