package com.ruoyi.guide.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 景区路线对象 tour_route
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class TourRoute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 路线ID */
    private Long routeId;

    /** 路线名称（如：故宫全览线、西湖经典线） */
    @Excel(name = "路线名称", readConverterExp = "如=：故宫全览线、西湖经典线")
    private String routeName;

    /** 路线编号 */
    @Excel(name = "路线编号")
    private String routeCode;

    /** 预计讲解时长（分钟） */
    @Excel(name = "预计讲解时长", readConverterExp = "分=钟")
    private Long durationMinutes;

    /** 单次最大游客数 */
    @Excel(name = "单次最大游客数")
    private Long touristCapacity;

    /** 支持语言（逗号分隔） */
    @Excel(name = "支持语言", readConverterExp = "逗=号分隔")
    private String languageSupport;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long sort;

    /** $column.columnComment */
    private String delFlag;

    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }

    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }

    public void setRouteCode(String routeCode) 
    {
        this.routeCode = routeCode;
    }

    public String getRouteCode() 
    {
        return routeCode;
    }

    public void setDurationMinutes(Long durationMinutes) 
    {
        this.durationMinutes = durationMinutes;
    }

    public Long getDurationMinutes() 
    {
        return durationMinutes;
    }

    public void setTouristCapacity(Long touristCapacity) 
    {
        this.touristCapacity = touristCapacity;
    }

    public Long getTouristCapacity() 
    {
        return touristCapacity;
    }

    public void setLanguageSupport(String languageSupport) 
    {
        this.languageSupport = languageSupport;
    }

    public String getLanguageSupport() 
    {
        return languageSupport;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("routeId", getRouteId())
            .append("routeName", getRouteName())
            .append("routeCode", getRouteCode())
            .append("durationMinutes", getDurationMinutes())
            .append("touristCapacity", getTouristCapacity())
            .append("languageSupport", getLanguageSupport())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
