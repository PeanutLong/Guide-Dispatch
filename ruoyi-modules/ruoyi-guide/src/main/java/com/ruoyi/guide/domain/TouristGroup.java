package com.ruoyi.guide.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 游客团信息对象 tourist_group
 *
 * @author ruoyi
 * @date 2026-03-19
 */
public class TouristGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 游客团ID */
    private Long groupId;

    /** 团号 */
    @Excel(name = "团号")
    private String groupCode;

    /** 游客人数 */
    @Excel(name = "游客人数")
    private Long touristCount;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 预计离开时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计离开时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 语言需求（zh/en 等） */
    @Excel(name = "语言需求", readConverterExp = "z=h/en,等=")
    private String languagePreference;

    /** 路线ID（关联 tour_route） */
    @Excel(name = "路线ID", readConverterExp = "关=联,t=our_route")
    private Long routeId;

    /** 集合点ID（关联 meeting_point） */
    @Excel(name = "集合点ID", readConverterExp = "关=联,m=eeting_point")
    private Long pointId;

    /** 状态（0待调度 1已调度 2已完成 3取消） */
    @Excel(name = "状态", readConverterExp = "0=待调度,1=已调度,2=已完成,3=取消")
    private String status;

    /** 已分配讲解员ID */
    @Excel(name = "已分配讲解员ID")
    private Long assignedGuideId;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setGroupId(Long groupId)
    {
        this.groupId = groupId;
    }

    public Long getGroupId()
    {
        return groupId;
    }

    public void setGroupCode(String groupCode)
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode()
    {
        return groupCode;
    }

    public void setTouristCount(Long touristCount)
    {
        this.touristCount = touristCount;
    }

    public Long getTouristCount()
    {
        return touristCount;
    }

    public void setArrivalTime(Date arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime()
    {
        return arrivalTime;
    }

    public void setDepartureTime(Date departureTime)
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime()
    {
        return departureTime;
    }

    public void setLanguagePreference(String languagePreference)
    {
        this.languagePreference = languagePreference;
    }

    public String getLanguagePreference()
    {
        return languagePreference;
    }

    public void setRouteId(Long routeId)
    {
        this.routeId = routeId;
    }

    public Long getRouteId()
    {
        return routeId;
    }

    public void setPointId(Long pointId)
    {
        this.pointId = pointId;
    }

    public Long getPointId()
    {
        return pointId;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setAssignedGuideId(Long assignedGuideId)
    {
        this.assignedGuideId = assignedGuideId;
    }

    public Long getAssignedGuideId()
    {
        return assignedGuideId;
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
                .append("groupId", getGroupId())
                .append("groupCode", getGroupCode())
                .append("touristCount", getTouristCount())
                .append("arrivalTime", getArrivalTime())
                .append("departureTime", getDepartureTime())
                .append("languagePreference", getLanguagePreference())
                .append("routeId", getRouteId())
                .append("pointId", getPointId())
                .append("status", getStatus())
                .append("assignedGuideId", getAssignedGuideId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
