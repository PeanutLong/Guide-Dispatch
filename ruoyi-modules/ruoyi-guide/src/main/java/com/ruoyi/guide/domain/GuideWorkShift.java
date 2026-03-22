package com.ruoyi.guide.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 讲解员排班对象 guide_work_shift
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class GuideWorkShift extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 排班ID */
    private Long shiftId;

    /** 讲解员ID */
    @Excel(name = "讲解员ID")
    private Long guideId;

    /** 排班日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "排班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shiftDate;

    /** 班次（0早班 1午班 2晚班 3全天） */
    @Excel(name = "班次", readConverterExp = "0=早班,1=午班,2=晚班,3=全天")
    private String shiftType;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态（0正常 1请假 2调休） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=请假,2=调休")
    private String status;

    /** $column.columnComment */
    private String delFlag;

    public void setShiftId(Long shiftId) 
    {
        this.shiftId = shiftId;
    }

    public Long getShiftId() 
    {
        return shiftId;
    }

    public void setGuideId(Long guideId) 
    {
        this.guideId = guideId;
    }

    public Long getGuideId() 
    {
        return guideId;
    }

    public void setShiftDate(Date shiftDate) 
    {
        this.shiftDate = shiftDate;
    }

    public Date getShiftDate() 
    {
        return shiftDate;
    }

    public void setShiftType(String shiftType) 
    {
        this.shiftType = shiftType;
    }

    public String getShiftType() 
    {
        return shiftType;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
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
            .append("shiftId", getShiftId())
            .append("guideId", getGuideId())
            .append("shiftDate", getShiftDate())
            .append("shiftType", getShiftType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
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
