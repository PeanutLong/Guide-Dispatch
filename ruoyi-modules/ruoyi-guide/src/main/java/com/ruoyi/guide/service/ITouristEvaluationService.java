package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.TouristEvaluation;

/**
 * 游客评价Service接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface ITouristEvaluationService 
{
    /**
     * 查询游客评价
     * 
     * @param evalId 游客评价主键
     * @return 游客评价
     */
    public TouristEvaluation selectTouristEvaluationByEvalId(Long evalId);

    /**
     * 查询游客评价列表
     * 
     * @param touristEvaluation 游客评价
     * @return 游客评价集合
     */
    public List<TouristEvaluation> selectTouristEvaluationList(TouristEvaluation touristEvaluation);

    /**
     * 新增游客评价
     * 
     * @param touristEvaluation 游客评价
     * @return 结果
     */
    public int insertTouristEvaluation(TouristEvaluation touristEvaluation);

    /**
     * 修改游客评价
     * 
     * @param touristEvaluation 游客评价
     * @return 结果
     */
    public int updateTouristEvaluation(TouristEvaluation touristEvaluation);

    /**
     * 批量删除游客评价
     * 
     * @param evalIds 需要删除的游客评价主键集合
     * @return 结果
     */
    public int deleteTouristEvaluationByEvalIds(Long[] evalIds);

    /**
     * 删除游客评价信息
     * 
     * @param evalId 游客评价主键
     * @return 结果
     */
    public int deleteTouristEvaluationByEvalId(Long evalId);
}
