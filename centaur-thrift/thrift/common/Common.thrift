namespace java com.lyl.thrift.common

#返回消息体
struct ReturnMsg{
  1: required i64 returnCode  #返回码
  2: required string returnInfo  #返回信息
  3: required string returnResponse  #返回参数
  4: optional string returnStack #返回错误码
}

struct BizContext{
1: required string name
2: required string uid
3: optional string productId
4: optional string reqTime
5: optional map<string,string> bizExt #扩展信息
}

#请求信息
struct Header{
  1: required string caller #调用方
  2: optional string traceId #请求ID 跟踪整个业务
  3: optional string spanId #下游TRACE id
  4: optional map<string,string> otherMap
  5: optional BizContext bizContext #上下文
}

#签名信息
struct SignInfo{
  1: required string signMethod #签名方法
  2: required string signInfo #签名信息
  3: optional string noise
}