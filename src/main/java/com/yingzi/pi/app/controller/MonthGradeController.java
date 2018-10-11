package com.yingzi.pi.app.controller;

import com.yingzi.center.pi.api.MonthGradeService;
import com.yingzi.center.pi.vo.JobMessageVo;
import com.yingzi.center.pi.vo.MonthGradeVo;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import com.yingzi.pi.app.resp.ExceptionEnum;
import com.yingzi.pi.app.resp.RestResponse;
import com.yingzi.pi.app.resp.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: yingzi-app-pi
 * @description: 员工月度绩效
 * @author: BaoGuoQiang
 * @create: 2018-10-10 16:28
 **/
@RequestMapping("/api/grade")
@Api(tags = "员工月度绩效API(BigBao)")
@RestController
public class MonthGradeController {
    private static final Logger logger = YZLogManager.getLogger(MonthGradeController.class);

    @Resource
    MonthGradeService monthGradeService;
    @PostMapping("")
    @ApiOperation(value = "新增员工绩效")
    public RestResponse<MonthGradeVo> saveJob(@RequestBody MonthGradeVo monthGradeVo){
        try {
            monthGradeVo = monthGradeService.addGrade(monthGradeVo);
            return ResultBuilder.success(monthGradeVo);
        } catch (Exception e){
            logger.error("员工绩效新增失败",e);
            return ResultBuilder.error(ExceptionEnum.ERROR);
        }
    }

}