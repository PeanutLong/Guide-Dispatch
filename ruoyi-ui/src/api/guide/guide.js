import request from '@/utils/request'

// 查询讲解员信息列表
export function listGuide(query) {
  return request({
    url: '/guide/guide/list',
    method: 'get',
    params: query
  })
}

// 查询讲解员信息详细
export function getGuide(guideId) {
  return request({
    url: '/guide/guide/' + guideId,
    method: 'get'
  })
}

// 新增讲解员信息
export function addGuide(data) {
  return request({
    url: '/guide/guide',
    method: 'post',
    data: data
  })
}

// 修改讲解员信息
export function updateGuide(data) {
  return request({
    url: '/guide/guide',
    method: 'put',
    data: data
  })
}

// 删除讲解员信息
export function delGuide(guideId) {
  return request({
    url: '/guide/guide/' + guideId,
    method: 'delete'
  })
}
