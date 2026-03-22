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
import com.ruoyi.guide.domain.TouristEvaluation;
import com.ruoyi.guide.service.ITouristEvaluationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 游客评价Controller
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
@RestController
@RequestMapping("/evaluation")
public class TouristEvaluationController extends BaseController
{
    @Autowired
    private ITouristEvaluationService touristEvaluationService;

    /**
     * 查询游客评价列表
     */
    @RequiresPermissions("guide:evaluation:list")
    @GetMapping("/list")
    public TableDataInfo list(TouristEvaluation touristEvaluation)
    {
        startPage();
        List<TouristEvaluation> list = touristEvaluationService.selectTouristEvaluationList(touristEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出游客评价列表
     */
    @RequiresPermissions("guide:evaluation:export")
    @Log(title = "游客评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TouristEvaluation touristEvaluation)
    {
        List<TouristEvaluation> list = touristEvaluationService.selectTouristEvaluationList(touristEvaluation);
        ExcelUtil<TouristEvaluation> util = new ExcelUtil<TouristEvaluation>(TouristEvaluation.class);
        util.exportExcel(response, list, "游客评价数据");
    }

    /**
     * 获取游客评价详细信息
     */
    @RequiresPermissions("guide:evaluation:query")
    @GetMapping(value = "/{evalId}")
    public AjaxResult getInfo(@PathVariable("evalId") Long evalId)
    {
        return success(touristEvaluationService.selectTouristEvaluationByEvalId(evalId));
    }

    /**
     * 新增游客评价
     */
    @RequiresPermissions("guide:evaluation:add")
    @Log(title = "游客评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TouristEvaluation touristEvaluation)
    {
        return toAjax(touristEvaluationService.insertTouristEvaluation(touristEvaluation));
    }

    /**
     * 修改游客评价
     */
    @RequiresPermissions("guide:evaluation:edit")
    @Log(title = "游客评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TouristEvaluation touristEvaluation)
    {
        return toAjax(touristEvaluationService.updateTouristEvaluation(touristEvaluation));
    }

    /**
     * 删除游客评价
     */
    @RequiresPermissions("guide:evaluation:remove")
    @Log(title = "游客评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evalIds}")
    public AjaxResult remove(@PathVariable Long[] evalIds)
    {
        return toAjax(touristEvaluationService.deleteTouristEvaluationByEvalIds(evalIds));
    }
}
