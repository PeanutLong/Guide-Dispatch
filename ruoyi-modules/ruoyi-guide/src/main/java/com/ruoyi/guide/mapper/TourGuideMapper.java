package com.ruoyi.guide.mapper;

import java.util.List;
import com.ruoyi.guide.domain.TourGuide;

/**
 * 讲解员信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface TourGuideMapper 
{
    /**
     * 查询讲解员信息
     * 
     * @param guideId 讲解员信息主键
     * @return 讲解员信息
     */
    public TourGuide selectTourGuideByGuideId(Long guideId);

    /**
     * 查询讲解员信息列表
     * 
     * @param tourGuide 讲解员信息
     * @return 讲解员信息集合
     */
    public List<TourGuide> selectTourGuideList(TourGuide tourGuide);

    /**
     * 新增讲解员信息
     * 
     * @param tourGuide 讲解员信息
     * @return 结果
     */
    public int insertTourGuide(TourGuide tourGuide);

    /**
     * 修改讲解员信息
     * 
     * @param tourGuide 讲解员信息
     * @return 结果
     */
    public int updateTourGuide(TourGuide tourGuide);

    /**
     * 删除讲解员信息
     * 
     * @param guideId 讲解员信息主键
     * @return 结果
     */
    public int deleteTourGuideByGuideId(Long guideId);

    /**
     * 批量删除讲解员信息
     * 
     * @param guideIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTourGuideByGuideIds(Long[] guideIds);
}
