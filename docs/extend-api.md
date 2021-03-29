# 对接文档v1.1

## 1. 设备心跳保活接口(5分钟沉默期)

```http request
POST /device/keepalive?deviceNo=111 HTTP/1.1
Host: localhost:8089
```

### 设备未注册
```json
{
    "code": 1001,
    "msg": "device not exists",
    "view": "设备未注册",
    "payload": null
}
```

### 设备上线成功
```json
{
    "code": 1,
    "msg": "success",
    "view": "操作成功",
    "payload": null
}
```

## 2. 上传检测数据
```http request
POST /device/sampled HTTP/1.1
Host: localhost:8089
Content-Type: application/json
Content-Length: 191

{
    "sampledName":"哈密瓜",
    "sampledNo":"2021001",
    "deviceNo": "111",
    "detectItem":"农药残留",
    "detectValue":"98%",
    "detectResult":1,
    "detectTime":"2020-03-29 13:56:21"
}
```
参数 | 说明 |类型| 示例
--- | ---|---|---
sampledName| 采样名称|string(50)| 哈密瓜
sampledNo| 采样编号 |string(50)| 2021001
deviceNo|设备编号| string(32) |111
detectItem|检测项目|string(50)|农药残留
detectValue|检测值|string(20)|98%
detectResult|检测结果(1:合格,阴性;2:不合格,阳性)|int|1
detectTime|检测时间(yyyy-MM-dd HH:mm:ss)|string|2020-03-29 13:56:21

### 上传成功
```json
{
    "code": 1,
    "msg": "success",
    "view": "操作成功",
    "payload": null
}
```

### 设备未注册
```json
{
    "code": 1001,
    "msg": "device not exists",
    "view": "设备未注册",
    "payload": null
}
```
