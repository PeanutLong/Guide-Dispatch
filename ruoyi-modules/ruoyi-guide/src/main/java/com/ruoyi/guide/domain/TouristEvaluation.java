package com.ruoyi.guide.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 游客评价对象 tourist_evaluation
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class TouristEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价ID */
    private Long evalId;

    /** 游客团ID */
    @Excel(name = "游客团ID")
    private Long groupId;

    /** 讲解员ID */
    @Excel(name = "讲解员ID")
    private Long guideId;

    /** 评分（1-5星） */
    @Excel(name = "评分", readConverterExp = "1=-5星")
    private Long score;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String content;

    /** 标签（逗号分隔，如：专业、热情、幽默） */
    @Excel(name = "标签", readConverterExp = "逗=号分隔，如：专业、热情、幽默")
    private String tags;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date evalTime;

    /** $column.columnComment */
    private String delFlag;

    public void setEvalId(Long evalId) 
    {
        this.evalId = evalId;
    }

    public Long getEvalId() 
    {
        return evalId;
    }

    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }

    public void setGuideId(Long guideId) 
    {
        this.guideId = guideId;
    }

    public Long getGuideId() 
    {
        return guideId;
    }

    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setTags(String tags) 
    {
        this.tags = tags;
    }

    public String getTags() 
    {
        return tags;
    }

    public void setEvalTime(Date evalTime) 
    {
        this.evalTime = evalTime;
    }

    public Date getEvalTime() 
    {
        return evalTime;
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
            .append("evalId", getEvalId())
            .append("groupId", getGroupId())
            .append("guideId", getGuideId())
            .append("score", getScore())
            .append("content", getContent())
            .append("tags", getTags())
            .append("evalTime", getEvalTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
