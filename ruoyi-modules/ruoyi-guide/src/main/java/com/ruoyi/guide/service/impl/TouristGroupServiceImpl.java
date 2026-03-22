package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.TouristGroupMapper;
import com.ruoyi.guide.domain.TouristGroup;
import com.ruoyi.guide.service.ITouristGroupService;

/**
 * 游客团信息Service业务层处理
 *
 * @author ruoyi
 * @date 2026-03-19
 */
@Service
public class TouristGroupServiceImpl implements ITouristGroupService
{
    @Autowired
    private TouristGroupMapper touristGroupMapper;

    /**
     * 查询游客团信息
     *
     * @param groupId 游客团信息主键
     * @return 游客团信息
     */
    @Override
    public TouristGroup selectTouristGroupByGroupId(Long groupId)
    {
        return touristGroupMapper.selectTouristGroupByGroupId(groupId);
    }

    /**
     * 查询游客团信息列表
     *
     * @param touristGroup 游客团信息
     * @return 游客团信息
     */
    @Override
    public List<TouristGroup> selectTouristGroupList(TouristGroup touristGroup)
    {
        return touristGroupMapper.selectTouristGroupList(touristGroup);
    }

    /**
     * 新增游客团信息
     *
     * @param touristGroup 游客团信息
     * @return 结果
     */
    @Override
    public int insertTouristGroup(TouristGroup touristGroup)
    {
        touristGroup.setCreateTime(DateUtils.getNowDate());
        return touristGroupMapper.insertTouristGroup(touristGroup);
    }

    /**
     * 修改游客团信息
     *
     * @param touristGroup 游客团信息
     * @return 结果
     */
    @Override
    public int updateTouristGroup(TouristGroup touristGroup)
    {
        touristGroup.setUpdateTime(DateUtils.getNowDate());
        return touristGroupMapper.updateTouristGroup(touristGroup);
    }

    /**
     * 批量删除游客团信息
     *
     * @param groupIds 需要删除的游客团信息主键
     * @return 结果
     */
    @Override
    public int deleteTouristGroupByGroupIds(Long[] groupIds)
    {
        return touristGroupMapper.deleteTouristGroupByGroupIds(groupIds);
    }

    /**
     * 删除游客团信息信息
     *
     * @param groupId 游客团信息主键
     * @return 结果
     */
    @Override
    public int deleteTouristGroupByGroupId(Long groupId)
    {
        return touristGroupMapper.deleteTouristGroupByGroupId(groupId);
    }
}
