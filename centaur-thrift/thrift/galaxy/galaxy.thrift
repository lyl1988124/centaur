include "../common/Common.thrift"
namespace java com.lyl.thrift.galaxy

service GalaxyThrift{
    /**
    *  创建用户
    **/
    Common.ReturnMsg createGalaxy(1: Common.Header header,2:Common.SignInfo signInfo,3:string requestInfo);

    Common.ReturnMsg queryGalaxy(1: Common.Header header,2:Common.SignInfo signInfo,3:string requestInfo);

    Common.ReturnMsg updateGalaxy(1: Common.Header header,2:Common.SignInfo signInfo,3:string requestInfo);
}

struct CreateGalaxyReq{
    1: required string uid
    2: required string name
    3: optional i32 age
    4: optional string extInfo
    5: optional string caller
}

struct QueryGalaxyReq{
    1: required string uid
    2: required string name
    3: optional string caller
}

struct UpdateGalaxyReq{
    1: required string uid
    2: required string name
    3: optional i32 age
    4: optional string extInfo
    5: optional string caller
}



