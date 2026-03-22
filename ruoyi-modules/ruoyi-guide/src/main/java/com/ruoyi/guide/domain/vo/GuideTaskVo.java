package com.ruoyi.guide.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;

/**
 * 讲解员任务列表视图对象
 */
public class GuideTaskVo {

    /** 调度记录ID */
    private Long scheduleId;

    @Excel(name = "团号")
    private String groupCode;

    @Excel(name = "游客人数")
    private Long touristCount;

    @Excel(name = "语言需求")
    private String languagePreference;

    @Excel(name = "集合点")
    private String meetingPointName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预计开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date expectedStartTime;

    @Excel(name = "路线名称")
    private String routeName;

    @Excel(name = "状态")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter 和 Setter
    public String getGroupCode() { return groupCode; }
    public void setGroupCode(String groupCode) { this.groupCode = groupCode; }

    public Long getTouristCount() { return touristCount; }
    public void setTouristCount(Long touristCount) { this.touristCount = touristCount; }

    public String getLanguagePreference() { return languagePreference; }
    public void setLanguagePreference(String languagePreference) { this.languagePreference = languagePreference; }

    public String getMeetingPointName() { return meetingPointName; }
    public void setMeetingPointName(String meetingPointName) { this.meetingPointName = meetingPointName; }

    public Date getExpectedStartTime() { return expectedStartTime; }
    public void setExpectedStartTime(Date expectedStartTime) { this.expectedStartTime = expectedStartTime; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }
}