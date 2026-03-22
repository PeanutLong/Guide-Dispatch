import request from '@/utils/request'

// 查询负载均衡规则配置列表
export function listRule(query) {
  return request({
    url: '/guide/rule/list',
    method: 'get',
    params: query
  })
}

// 查询负载均衡规则配置详细
export function getRule(ruleId) {
  return request({
    url: '/guide/rule/' + ruleId,
    method: 'get'
  })
}

// 新增负载均衡规则配置
export function addRule(data) {
  return request({
    url: '/guide/rule',
    method: 'post',
    data: data
  })
}

// 修改负载均衡规则配置
export function updateRule(data) {
  return request({
    url: '/guide/rule',
    method: 'put',
    data: data
  })
}

// 删除负载均衡规则配置
export function delRule(ruleId) {
  return request({
    url: '/guide/rule/' + ruleId,
    method: 'delete'
  })
}
