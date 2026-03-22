import request from '@/utils/request'

// 查询景区路线列表
export function listRoute(query) {
  return request({
    url: '/guide/route/list',
    method: 'get',
    params: query
  })
}

// 查询景区路线详细
export function getRoute(routeId) {
  return request({
    url: '/guide/route/' + routeId,
    method: 'get'
  })
}

// 新增景区路线
export function addRoute(data) {
  return request({
    url: '/guide/route',
    method: 'post',
    data: data
  })
}

// 修改景区路线
export function updateRoute(data) {
  return request({
    url: '/guide/route',
    method: 'put',
    data: data
  })
}

// 删除景区路线
export function delRoute(routeId) {
  return request({
    url: '/guide/route/' + routeId,
    method: 'delete'
  })
}
