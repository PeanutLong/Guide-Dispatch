import request from '@/utils/request'

// 查询游客团信息列表
export function listGroup(query) {
  return request({
    url: '/guide/group/list',
    method: 'get',
    params: query
  })
}

// 查询游客团信息详细
export function getGroup(groupId) {
  return request({
    url: '/guide/group/' + groupId,
    method: 'get'
  })
}

// 新增游客团信息
export function addGroup(data) {
  return request({
    url: '/guide/group',
    method: 'post',
    data: data
  })
}

// 修改游客团信息
export function updateGroup(data) {
  return request({
    url: '/guide/group',
    method: 'put',
    data: data
  })
}

// 删除游客团信息
export function delGroup(groupId) {
  return request({
    url: '/guide/group/' + groupId,
    method: 'delete'
  })
}
