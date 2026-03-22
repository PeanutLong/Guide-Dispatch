import request from '@/utils/request'

// 查询集合点列表
export function listPoint(query) {
  return request({
    url: '/guide/point/list',
    method: 'get',
    params: query
  })
}

// 查询集合点详细
export function getPoint(pointId) {
  return request({
    url: '/guide/point/' + pointId,
    method: 'get'
  })
}

// 新增集合点
export function addPoint(data) {
  return request({
    url: '/guide/point',
    method: 'post',
    data: data
  })
}

// 修改集合点
export function updatePoint(data) {
  return request({
    url: '/guide/point',
    method: 'put',
    data: data
  })
}

// 删除集合点
export function delPoint(pointId) {
  return request({
    url: '/guide/point/' + pointId,
    method: 'delete'
  })
}
