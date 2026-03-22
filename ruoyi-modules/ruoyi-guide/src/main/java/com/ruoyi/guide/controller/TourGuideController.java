package com.ruoyi.guide.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.guide.service.ITourRouteService;
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
import com.ruoyi.guide.domain.TourGuide;
import com.ruoyi.guide.service.ITourGuideService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 讲解员信息Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/guide")
public class TourGuideController extends BaseController
{
    @Autowired
    private ITourGuideService tourGuideService;

    /**
     * 查询讲解员信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TourGuide tourGuide)
    {
        startPage();
        List<TourGuide> list = tourGuideService.selectTourGuideList(tourGuide);
        return getDataTable(list);
    }

    /**
     * 导出讲解员信息列表
     */
    @Log(title = "讲解员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TourGuide tourGuide)
    {
        List<TourGuide> list = tourGuideService.selectTourGuideList(tourGuide);
        ExcelUtil<TourGuide> util = new ExcelUtil<TourGuide>(TourGuide.class);
        util.exportExcel(response, list, "讲解员信息数据");
    }

    /**
     * 获取讲解员信息详细信息
     */
    @GetMapping(value = "/{guideId}")
    public AjaxResult getInfo(@PathVariable("guideId") Long guideId)
    {
        return success(tourGuideService.selectTourGuideByGuideId(guideId));
    }

    /**
     * 新增讲解员信息
     */
    @Log(title = "讲解员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TourGuide tourGuide)
    {
        return toAjax(tourGuideService.insertTourGuide(tourGuide));
    }

    /**
     * 修改讲解员信息
     */
    @Log(title = "讲解员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TourGuide tourGuide)
    {
        return toAjax(tourGuideService.updateTourGuide(tourGuide));
    }

    /**
     * 删除讲解员信息
     */
    @Log(title = "讲解员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{guideIds}")
    public AjaxResult remove(@PathVariable Long[] guideIds)
    {
        return toAjax(tourGuideService.deleteTourGuideByGuideIds(guideIds));
    }

    /**
     * 新增接口：获取当前讲解员信息（从 ThreadLocal 获取当前登录用户 userId）
     * 返回：讲解员姓名、工号、专长、状态
     * 调用示例：GET /guide/current
     */
    @GetMapping("/current")
    public AjaxResult current()
    {
        // ruoyi-cloud 标准方式（内部使用 ThreadLocal + SecurityContextHolder）
        Long userId = SecurityUtils.getUserId();

        TourGuide tourGuide = tourGuideService.selectTourGuideByGuideId(userId);
        if (tourGuide == null)
        {
            return AjaxResult.error("当前用户没有关联讲解员信息");
        }

        // 只返回要求的四个字段
        AjaxResult ajax = AjaxResult.success();
        ajax.put("guideName", tourGuide.getGuideName());
        ajax.put("guideCode", tourGuide.getGuideCode());
        ajax.put("expertise", tourGuide.getExpertise());
        ajax.put("status", tourGuide.getStatus());
        return ajax;
    }
}
