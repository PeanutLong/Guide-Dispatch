package com.ruoyi.guide.service;

import java.util.List;
import com.ruoyi.guide.domain.TouristGroup;

/**
 * 游客团信息Service接口
 *
 * @author ruoyi
 * @date 2026-03-19
 */
public interface ITouristGroupService
{
    /**
     * 查询游客团信息
     *
     * @param groupId 游客团信息主键
     * @return 游客团信息
     */
    public TouristGroup selectTouristGroupByGroupId(Long groupId);

    /**
     * 查询游客团信息列表
     *
     * @param touristGroup 游客团信息
     * @return 游客团信息集合
     */
    public List<TouristGroup> selectTouristGroupList(TouristGroup touristGroup);

    /**
     * 新增游客团信息
     *
     * @param touristGroup 游客团信息
     * @return 结果
     */
    public int insertTouristGroup(TouristGroup touristGroup);

    /**
     * 修改游客团信息
     *
     * @param touristGroup 游客团信息
     * @return 结果
     */
    public int updateTouristGroup(TouristGroup touristGroup);

    /**
     * 批量删除游客团信息
     *
     * @param groupIds 需要删除的游客团信息主键集合
     * @return 结果
     */
    public int deleteTouristGroupByGroupIds(Long[] groupIds);

    /**
     * 删除游客团信息信息
     *
     * @param groupId 游客团信息主键
     * @return 结果
     */
    public int deleteTouristGroupByGroupId(Long groupId);
}
