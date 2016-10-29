package com.johuer.controller;

import com.johuer.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xujiuhua
 * @create 2016-10-28-22:05
 */
@Api(tags = {"user"}, description = "user控制层描述")
@RequestMapping("user")
@Controller
public class UserController {


    /**
     * 传入单个参数，并对参数和方法进行描述
     * @param name
     * @return
     */
    @ApiOperation(value = "入参字符串", notes = "传入一个字符串")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "string", paramType = "query")
    @RequestMapping(value = "testStr", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testStr(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        return map;
    }

    /**
     * 传入对象，针对对象中某些属性的描述和控制
     *
     * 如：user对象有3个属性，如果name和sex是必填，那么就必须单独描述，
     * age属性未描述，则会使用实体类中的ApiModelProperty获取描述信息，默认非必填
     * @param user
     * @return
     */
    @ApiOperation(value = "入参对象", notes = "需要传入obj对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别(0-男,1-女)", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "testObj", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> testObj(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        return map;
    }

    /**
     * 传入对象
     *
     * 返回是一个对象，所以在model中能看到属性描述。
     * 返回是一个map，则无法看到model中属性描述。如方法:testObj
     * @param user
     * @return
     */
    @ApiOperation(value = "入参对象", notes = "需要传入user对象")
    @RequestMapping(value = "testUser", method = RequestMethod.PUT)
    @ResponseBody
    public User testUser(User user) {
        return user;
    }

    //@ApiIgnore//使用该注解忽略这个API
    @ApiIgnore
    @RequestMapping(value = "testIgnore", method = RequestMethod.DELETE)
    @ResponseBody
    public String testIgnore() {
        return "ignore";
    }
}
