package com.yingzi.pi.app.controller;

import com.yingzi.center.pi.api.JobMessageService;
import com.yingzi.center.pi.vo.JobMessageVo;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import com.yingzi.pi.app.resp.ExceptionEnum;
import com.yingzi.pi.app.resp.RestResponse;
import com.yingzi.pi.app.resp.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 员工工作信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 16:56
 **/
@RequestMapping("/api/job")
@Api(tags = "员工工作信息API(BigBao)")
@Controller
public class JobMessageController {
    private static final Logger logger = YZLogManager.getLogger(PersonInformationController.class);

    @Resource
    JobMessageService jobMessageService;

    @PostMapping("")
    @ApiOperation(value = "新增员工工作信息")
    public RestResponse<JobMessageVo> saveJob(@RequestBody JobMessageVo jobMessageVo){
        try {
            jobMessageVo = jobMessageService.saveJob(jobMessageVo);
            return ResultBuilder.success(jobMessageVo);
        } catch (Exception e){
            logger.error("员工工作信息新增失败",e);
            return ResultBuilder.error(ExceptionEnum.ERROR);
        }
    }

    @PutMapping("")
    @ApiOperation(value = "修改员工工作信息")
    public RestResponse<Void> updateJob(@RequestBody JobMessageVo jobMessageVo){
        try {
            jobMessageService.updateJob(jobMessageVo);
            return ResultBuilder.success();
        } catch (Exception e2){
            logger.error("员工工作信息修改失败",e2);
            return ResultBuilder.error(ExceptionEnum.ERROR);
        }
    }

    @ApiOperation(value = "获取员工工作信息列表")
    @GetMapping("/list/{jobNumber}")
    public String getJob(@ApiParam(value = "工号",required = true) HashMap<String, Object> map, @PathVariable Integer jobNumber){
        try {
            List<JobMessageVo> jobMessageVos = jobMessageService.getJob(jobNumber);
            if (jobMessageVos != null){
                for (int i =0;i<jobMessageVos.size();i++){
                JobMessageVo messageVo =jobMessageVos.get(i);
                String pst = messageVo.getPost();
                map.put("hello", messageVo);
                return "/index";
                }
            }
            return "redirect:/error.html";
            //return ResultBuilder.success(jobMessageVos);
        } catch (Exception e){
            logger.error("获取员工工作信息失败",e);
            return "redirect:/error.html";
        }
    }
}