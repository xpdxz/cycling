package com.cycling.controller;

import com.cycling.service.ActiveService;
import com.cycling.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/11/10 20:51
 */
@RestController
@Log4j2
@RequestMapping("/active")
@Api(tags = "活动相关模块")
public class ActiveController {
    @Resource
    private ActiveService activeService;

    @ApiOperation("获取全部活动")
    @RequestMapping("/getallactive")
    public ResponseResult getall(){
        return ResponseResult.ok(activeService.getAllActive());
    }

    @ApiOperation("分页获取活动")
    @RequestMapping("/getallactivebypage")
    public ResponseResult getallactivebypage(Long id){
        return ResponseResult.ok(activeService.getAllActiveByPage(id));
    }

    @ApiOperation("分页根据标签获取活动")
    @RequestMapping("/getallactivebypagewithtags")
    public ResponseResult getactivebytags(List<String> tags){return ResponseResult.ok(activeService.getActiveByTags(tags));};

    @ApiOperation("分页根据地区获取活动")
    @RequestMapping("/getallactivebypagewitharea")
    public ResponseResult getactivebyarea(String area,long id){return ResponseResult.ok(activeService.getActiveByAreaAndPage(area,id));};

    @ApiOperation("获取活动详情")
    @RequestMapping("/getactive")
    public ResponseResult getactive(long id){return ResponseResult.ok(activeService.getActive(id));}
}
