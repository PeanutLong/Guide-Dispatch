package com.ruoyi.guide.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 讲解员信息对象 tour_guide
 * 
 * @author ruoyi
 * @date 2026-03-17
 */
public class TourGuide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 讲解员ID */
    private Long guideId;

    /** 讲解员姓名 */
    @Excel(name = "讲解员姓名")
    private String guideName;

    /** 工号（唯一） */
    @Excel(name = "工号", readConverterExp = "唯=一")
    private String guideCode;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 专长（语言/路线，用英文逗号分隔，如 zh,en,route1） */
    @Excel(name = "专长", readConverterExp = "语=言/路线，用英文逗号分隔，如,z=h,en,route1")
    private String expertise;

    /** 状态（0空闲 1忙碌 2休息） */
    @Excel(name = "状态", readConverterExp = "0=空闲,1=忙碌,2=休息")
    private String status;

    /** 当前负载（负责游客总数） */
    @Excel(name = "当前负载", readConverterExp = "负=责游客总数")
    private Long currentLoad;

    /** 最大负载容量（可配置） */
    @Excel(name = "最大负载容量", readConverterExp = "可=配置")
    private Long maxLoad;

    /** 所属部门ID（关联 sys_dept，可选） */
    @Excel(name = "所属部门ID", readConverterExp = "关=联,s=ys_dept，可选")
    private Long deptId;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setGuideId(Long guideId) 
    {
        this.guideId = guideId;
    }

    public Long getGuideId() 
    {
        return guideId;
    }

    public void setGuideName(String guideName) 
    {
        this.guideName = guideName;
    }

    public String getGuideName() 
    {
        return guideName;
    }

    public void setGuideCode(String guideCode) 
    {
        this.guideCode = guideCode;
    }

    public String getGuideCode() 
    {
        return guideCode;
    }

    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }

    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setExpertise(String expertise) 
    {
        this.expertise = expertise;
    }

    public String getExpertise() 
    {
        return expertise;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setCurrentLoad(Long currentLoad) 
    {
        this.currentLoad = currentLoad;
    }

    public Long getCurrentLoad() 
    {
        return currentLoad;
    }

    public void setMaxLoad(Long maxLoad) 
    {
        this.maxLoad = maxLoad;
    }

    public Long getMaxLoad() 
    {
        return maxLoad;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
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
            .append("guideId", getGuideId())
            .append("guideName", getGuideName())
            .append("guideCode", getGuideCode())
            .append("sex", getSex())
            .append("age", getAge())
            .append("phone", getPhone())
            .append("expertise", getExpertise())
            .append("status", getStatus())
            .append("currentLoad", getCurrentLoad())
            .append("maxLoad", getMaxLoad())
            .append("deptId", getDeptId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
