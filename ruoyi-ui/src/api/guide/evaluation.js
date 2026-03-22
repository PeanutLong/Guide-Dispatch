import request from '@/utils/request'

// 查询游客评价列表
export function listEvaluation(query) {
  return request({
    url: '/guide/evaluation/list',
    method: 'get',
    params: query
  })
}

// 查询游客评价详细
export function getEvaluation(evalId) {
  return request({
    url: '/guide/evaluation/' + evalId,
    method: 'get'
  })
}

// 新增游客评价
export function addEvaluation(data) {
  return request({
    url: '/guide/evaluation',
    method: 'post',
    data: data
  })
}

// 修改游客评价
export function updateEvaluation(data) {
  return request({
    url: '/guide/evaluation',
    method: 'put',
    data: data
  })
}

// 删除游客评价
export function delEvaluation(evalId) {
  return request({
    url: '/guide/evaluation/' + evalId,
    method: 'delete'
  })
}
