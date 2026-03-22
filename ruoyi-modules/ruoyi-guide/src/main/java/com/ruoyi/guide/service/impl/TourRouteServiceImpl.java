package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.TourRouteMapper;
import com.ruoyi.guide.domain.TourRoute;
import com.ruoyi.guide.service.ITourRouteService;

/**
 * 景区路线Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@Service
public class TourRouteServiceImpl implements ITourRouteService 
{
    @Autowired
    private TourRouteMapper tourRouteMapper;

    /**
     * 查询景区路线
     * 
     * @param routeId 景区路线主键
     * @return 景区路线
     */
    @Override
    public TourRoute selectTourRouteByRouteId(Long routeId)
    {
        return tourRouteMapper.selectTourRouteByRouteId(routeId);
    }

    /**
     * 查询景区路线列表
     * 
     * @param tourRoute 景区路线
     * @return 景区路线
     */
    @Override
    public List<TourRoute> selectTourRouteList(TourRoute tourRoute)
    {
        return tourRouteMapper.selectTourRouteList(tourRoute);
    }

    /**
     * 新增景区路线
     * 
     * @param tourRoute 景区路线
     * @return 结果
     */
    @Override
    public int insertTourRoute(TourRoute tourRoute)
    {
        tourRoute.setCreateTime(DateUtils.getNowDate());
        return tourRouteMapper.insertTourRoute(tourRoute);
    }

    /**
     * 修改景区路线
     * 
     * @param tourRoute 景区路线
     * @return 结果
     */
    @Override
    public int updateTourRoute(TourRoute tourRoute)
    {
        tourRoute.setUpdateTime(DateUtils.getNowDate());
        return tourRouteMapper.updateTourRoute(tourRoute);
    }

    /**
     * 批量删除景区路线
     * 
     * @param routeIds 需要删除的景区路线主键
     * @return 结果
     */
    @Override
    public int deleteTourRouteByRouteIds(Long[] routeIds)
    {
        return tourRouteMapper.deleteTourRouteByRouteIds(routeIds);
    }

    /**
     * 删除景区路线信息
     * 
     * @param routeId 景区路线主键
     * @return 结果
     */
    @Override
    public int deleteTourRouteByRouteId(Long routeId)
    {
        return tourRouteMapper.deleteTourRouteByRouteId(routeId);
    }
}
