package com.ruoyi.guide.mapper;

import java.util.List;
import com.ruoyi.guide.domain.TourRoute;

/**
 * 景区路线Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public interface TourRouteMapper 
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
     * 删除景区路线
     * 
     * @param routeId 景区路线主键
     * @return 结果
     */
    public int deleteTourRouteByRouteId(Long routeId);

    /**
     * 批量删除景区路线
     * 
     * @param routeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTourRouteByRouteIds(Long[] routeIds);
}
