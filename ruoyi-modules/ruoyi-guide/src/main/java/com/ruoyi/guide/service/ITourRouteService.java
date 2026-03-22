package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.TourRoute;

/**
 * 景区路线Service接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface ITourRouteService 
{
    /**
     * 查询景区路线
     * 
     * @param routeId 景区路线主键
     * @return 景区路线
     */
    public TourRoute selectTourRouteByRouteId(Long routeId);

    /**
     * 查询景区路线列表
     * 
     * @param tourRoute 景区路线
     * @return 景区路线集合
     */
    public List<TourRoute> selectTourRouteList(TourRoute tourRoute);

    /**
     * 新增景区路线
     * 
     * @param tourRoute 景区路线
     * @return 结果
     */
    public int insertTourRoute(TourRoute tourRoute);

    /**
     * 修改景区路线
     * 
     * @param tourRoute 景区路线
     * @return 结果
     */
    public int updateTourRoute(TourRoute tourRoute);

    /**
     * 批量删除景区路线
     * 
     * @param routeIds 需要删除的景区路线主键集合
     * @return 结果
     */
    public int deleteTourRouteByRouteIds(Long[] routeIds);

    /**
     * 删除景区路线信息
     * 
     * @param routeId 景区路线主键
     * @return 结果
     */
    public int deleteTourRouteByRouteId(Long routeId);
}
