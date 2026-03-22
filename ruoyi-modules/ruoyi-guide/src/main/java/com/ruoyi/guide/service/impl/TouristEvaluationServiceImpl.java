package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.TouristEvaluationMapper;
import com.ruoyi.guide.domain.TouristEvaluation;
import com.ruoyi.guide.service.ITouristEvaluationService;

/**
 * 游客评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class TouristEvaluationServiceImpl implements ITouristEvaluationService 
{
    @Autowired
    private TouristEvaluationMapper touristEvaluationMapper;

    /**
     * 查询游客评价
     * 
     * @param evalId 游客评价主键
     * @return 游客评价
     */
    @Override
    public TouristEvaluation selectTouristEvaluationByEvalId(Long evalId)
    {
        return touristEvaluationMapper.selectTouristEvaluationByEvalId(evalId);
    }

    /**
     * 查询游客评价列表
     * 
     * @param touristEvaluation 游客评价
     * @return 游客评价
     */
    @Override
    public List<TouristEvaluation> selectTouristEvaluationList(TouristEvaluation touristEvaluation)
    {
        return touristEvaluationMapper.selectTouristEvaluationList(touristEvaluation);
    }

    /**
     * 新增游客评价
     * 
     * @param touristEvaluation 游客评价
     * @return 结果
     */
    @Override
    public int insertTouristEvaluation(TouristEvaluation touristEvaluation)
    {
        touristEvaluation.setCreateTime(DateUtils.getNowDate());
        return touristEvaluationMapper.insertTouristEvaluation(touristEvaluation);
    }

    /**
     * 修改游客评价
     * 
     * @param touristEvaluation 游客评价
     * @return 结果
     */
    @Override
    public int updateTouristEvaluation(TouristEvaluation touristEvaluation)
    {
        touristEvaluation.setUpdateTime(DateUtils.getNowDate());
        return touristEvaluationMapper.updateTouristEvaluation(touristEvaluation);
    }

    /**
     * 批量删除游客评价
     * 
     * @param evalIds 需要删除的游客评价主键
     * @return 结果
     */
    @Override
    public int deleteTouristEvaluationByEvalIds(Long[] evalIds)
    {
        return touristEvaluationMapper.deleteTouristEvaluationByEvalIds(evalIds);
    }

    /**
     * 删除游客评价信息
     * 
     * @param evalId 游客评价主键
     * @return 结果
     */
    @Override
    public int deleteTouristEvaluationByEvalId(Long evalId)
    {
        return touristEvaluationMapper.deleteTouristEvaluationByEvalId(evalId);
    }
}
