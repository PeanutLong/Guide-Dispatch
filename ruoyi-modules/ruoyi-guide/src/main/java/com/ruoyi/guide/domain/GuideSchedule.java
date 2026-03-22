package com.ruoyi.guide.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 讲解员调度记录对象 guide_schedule
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class GuideSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 调度记录ID */
    private Long scheduleId;

    /** 讲解员ID */
    @Excel(name = "讲解员ID")
    private Long guideId;

    /** 游客团ID */
    @Excel(name = "游客团ID")
    private Long groupId;

    /** 分配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignTime;

    /** 实际开始讲解时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际开始讲解时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 实际结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 本次分配游客数 */
    @Excel(name = "本次分配游客数")
    private Long loadCount;

    /** 状态（0待接收 1进行中 2已完成 3待确认） */
    @Excel(name = "状态", readConverterExp = "0=待接收,1=进行中,2=已完成,3待确认")
    private String status;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setScheduleId(Long scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId() 
    {
        return scheduleId;
    }

    public void setGuideId(Long guideId) 
    {
        this.guideId = guideId;
    }

    public Long getGuideId() 
    {
        return guideId;
    }

    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }

    public void setAssignTime(Date assignTime) 
    {
        this.assignTime = assignTime;
    }

    public Date getAssignTime() 
    {
        return assignTime;
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

    public void setLoadCount(Long loadCount) 
    {
        this.loadCount = loadCount;
    }

    public Long getLoadCount() 
    {
        return loadCount;
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
            .append("scheduleId", getScheduleId())
            .append("guideId", getGuideId())
            .append("groupId", getGroupId())
            .append("assignTime", getAssignTime())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("loadCount", getLoadCount())
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
