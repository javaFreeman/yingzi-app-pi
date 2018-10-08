package com.yingzi.pi.app.controller;

import com.yingzi.center.pi.api.PersonInformationService;
import com.yingzi.center.pi.vo.PersonInformationVo;
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
 * @description: 员工个人信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 15:50
 **/
@RequestMapping("/api/person")
@Api(tags = "员工个人信息API(BigBao)")
@RestController
public class PersonInformationController {
    private static final Logger logger = YZLogManager.getLogger(PersonInformationController.class);

    @Resource
    PersonInformationService personInformationService;

    @PostMapping("")
    @ApiOperation(value = "新增员工信息")
    public RestResponse<PersonInformationVo> savePerson(@RequestBody PersonInformationVo personInformationVo){
        try {
            personInformationVo = personInformationService.savePerson(personInformationVo);
            return ResultBuilder.success(personInformationVo);
        } catch (Exception e){
            logger.error("员工信息新增失败",e);
            return ResultBuilder.error(ExceptionEnum.ERROR);
        }
    }
}