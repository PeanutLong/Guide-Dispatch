package com.ruoyi.guide.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 集合点对象 meeting_point
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class MeetingPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 集合点ID */
    private Long pointId;

    /** 集合点名称（如：南门广场、A1入口） */
    @Excel(name = "集合点名称", readConverterExp = "如=：南门广场、A1入口")
    private String pointName;

    /** 编号 */
    @Excel(name = "编号")
    private String pointCode;

    /** 具体位置描述 */
    @Excel(name = "具体位置描述")
    private String location;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal gpsLat;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal gpsLng;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** $column.columnComment */
    private String delFlag;

    public void setPointId(Long pointId) 
    {
        this.pointId = pointId;
    }

    public Long getPointId() 
    {
        return pointId;
    }

    public void setPointName(String pointName) 
    {
        this.pointName = pointName;
    }

    public String getPointName() 
    {
        return pointName;
    }

    public void setPointCode(String pointCode) 
    {
        this.pointCode = pointCode;
    }

    public String getPointCode() 
    {
        return pointCode;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setGpsLat(BigDecimal gpsLat) 
    {
        this.gpsLat = gpsLat;
    }

    public BigDecimal getGpsLat() 
    {
        return gpsLat;
    }

    public void setGpsLng(BigDecimal gpsLng) 
    {
        this.gpsLng = gpsLng;
    }

    public BigDecimal getGpsLng() 
    {
        return gpsLng;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("pointId", getPointId())
            .append("pointName", getPointName())
            .append("pointCode", getPointCode())
            .append("location", getLocation())
            .append("gpsLat", getGpsLat())
            .append("gpsLng", getGpsLng())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
