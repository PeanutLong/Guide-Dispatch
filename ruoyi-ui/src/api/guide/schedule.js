import request from '@/utils/request'

// 查询讲解员调度记录列表
export function listSchedule(query) {
  return request({
    url: '/guide/schedule/list',
    method: 'get',
    params: query
  })
}

// 查询讲解员调度记录详细
export function getSchedule(scheduleId) {
  return request({
    url: '/guide/schedule/' + scheduleId,
    method: 'get'
  })
}

// 新增讲解员调度记录
export function addSchedule(data) {
  return request({
    url: '/guide/schedule',
    method: 'post',
    data: data
  })
}

// 修改讲解员调度记录
export function updateSchedule(data) {
  return request({
    url: '/guide/schedule',
    method: 'put',
    data: data
  })
}

// 删除讲解员调度记录
export function delSchedule(scheduleId) {
  return request({
    url: '/guide/schedule/' + scheduleId,
    method: 'delete'
  })
}
