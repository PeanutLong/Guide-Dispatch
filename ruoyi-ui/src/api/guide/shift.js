import request from '@/utils/request'

// 查询讲解员排班列表
export function listShift(query) {
  return request({
    url: '/guide/shift/list',
    method: 'get',
    params: query
  })
}

// 查询讲解员排班详细
export function getShift(shiftId) {
  return request({
    url: '/guide/shift/' + shiftId,
    method: 'get'
  })
}

// 新增讲解员排班
export function addShift(data) {
  return request({
    url: '/guide/shift',
    method: 'post',
    data: data
  })
}

// 修改讲解员排班
export function updateShift(data) {
  return request({
    url: '/guide/shift',
    method: 'put',
    data: data
  })
}

// 删除讲解员排班
export function delShift(shiftId) {
  return request({
    url: '/guide/shift/' + shiftId,
    method: 'delete'
  })
}
