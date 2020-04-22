package Message.Controller;

import Message.Service.RoomInfoService;
import Message.domain.RoomInfo;

import com.mongodb.client.result.DeleteResult;
import com.spc.base.error.ReserveErrorCodeEnum;
import com.spc.base.resp.SpcResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("roominfo")
public class RoomInfoController {
    @Autowired
    private RoomInfoService roomInfoService;

    @ApiOperation(value = "根据id查询预约信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value="预约信息的id", required=true)
    )
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="服务器繁忙")
    })
    @RequestMapping("selbyid")
    public SpcResponse selByPid(String id){
        RoomInfo roomInfo = roomInfoService.selById(id);

        return SpcResponse.success(200,"message query server is successfully",roomInfo);

    }


    @ApiOperation(value = "查询全部预约信息")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="服务器繁忙")
    })
    @RequestMapping("selall")
    public SpcResponse selall(){
        List<RoomInfo> roomInfos = roomInfoService.selAll();
        return SpcResponse.success(200,"message query server is successfully",roomInfos);
    }


    @ApiOperation(value = "添加预约信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name="roomInfo",value="预约信息对象", required=true,dataType = "RoomInfo")
    )
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="服务器繁忙")
    })
    @RequestMapping("add")
    public SpcResponse saveInfo(RoomInfo roomInfo){
        System.out.println(roomInfo);
        System.out.println("add");
        RoomInfo save = roomInfoService.insert(roomInfo);
        if (save!=null){
            return SpcResponse.success(200,"message insert server is successfully"," ");
        }else{
            return SpcResponse.failure(ReserveErrorCodeEnum.MG1003004.code(),"message insert server is exist");
        }
    }

    @ApiOperation(value = "修改预约信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name="roomInfo",value="预约信息对象", required=true,dataType = "RoomInfo")
    )
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="服务器繁忙")
    })
    @RequestMapping("upd")
    public SpcResponse updInfo( RoomInfo roomInfo){
        RoomInfo roomInfo1 = roomInfoService.updInfo(roomInfo);
        if (roomInfo1!=null){
            return SpcResponse.success(200,"message update server is successfully"," ");
        }else{
            return SpcResponse.failure(ReserveErrorCodeEnum.MG1003001.code(),"message update server is exist");
        }
    }

    @ApiOperation(value = "删除预约信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name="roomInfo",value="预约信息对象", required=true,dataType = "RoomInfo")
    )
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="服务器繁忙")
    })
    @RequestMapping("del")
    public SpcResponse delInfo(RoomInfo roomInfo){
        DeleteResult del = roomInfoService.del(roomInfo);
        if (del!=null){
            return SpcResponse.success(200,"message delete server is successfully","");
        }else{
            return SpcResponse.failure(ReserveErrorCodeEnum.MG1003002.code(),"message delete server is exist");
        }
    }
}
