package com.ruoyi.guide.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.guide.domain.TourRoute;
import com.ruoyi.guide.service.ITourRouteService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 景区路线Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/route")
public class TourRouteController extends BaseController
{
    @Autowired
    private ITourRouteService tourRouteService;

    /**
     * 查询景区路线列表
     */
    @RequiresPermissions("guide:route:list")
    @GetMapping("/list")
    public TableDataInfo list(TourRoute tourRoute)
    {
        startPage();
        List<TourRoute> list = tourRouteService.selectTourRouteList(tourRoute);
        return getDataTable(list);
    }

    /**
     * 导出景区路线列表
     */
    @RequiresPermissions("guide:route:export")
    @Log(title = "景区路线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TourRoute tourRoute)
    {
        List<TourRoute> list = tourRouteService.selectTourRouteList(tourRoute);
        ExcelUtil<TourRoute> util = new ExcelUtil<TourRoute>(TourRoute.class);
        util.exportExcel(response, list, "景区路线数据");
    }

    /**
     * 获取景区路线详细信息
     */
    @RequiresPermissions("guide:route:query")
    @GetMapping(value = "/{routeId}")
    public AjaxResult getInfo(@PathVariable("routeId") Long routeId)
    {
        return success(tourRouteService.selectTourRouteByRouteId(routeId));
    }

    /**
     * 新增景区路线
     */
    @RequiresPermissions("guide:route:add")
    @Log(title = "景区路线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TourRoute tourRoute)
    {
        return toAjax(tourRouteService.insertTourRoute(tourRoute));
    }

    /**
     * 修改景区路线
     */
    @RequiresPermissions("guide:route:edit")
    @Log(title = "景区路线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TourRoute tourRoute)
    {
        return toAjax(tourRouteService.updateTourRoute(tourRoute));
    }

    /**
     * 删除景区路线
     */
    @RequiresPermissions("guide:route:remove")
    @Log(title = "景区路线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{routeIds}")
    public AjaxResult remove(@PathVariable Long[] routeIds)
    {
        return toAjax(tourRouteService.deleteTourRouteByRouteIds(routeIds));
    }
}
