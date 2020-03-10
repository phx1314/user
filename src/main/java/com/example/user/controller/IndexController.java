package com.example.user.controller;

import com.example.user.core.ret.RetResponse;
import com.example.user.core.ret.RetResult;
import com.example.user.core.utils.ApplicationUtils;
import com.example.user.model.OaSoftware;
import com.example.user.model.OaUser;
import com.example.user.service.OaSoftwareService;
import com.example.user.service.OaUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author df
 * @Description: OaUserController类
 * @date 2020/03/06 15:42
 */
@Controller
@RequestMapping("")
public class IndexController {

  @Resource
  private OaUserService oaUserService;
  @Resource
  private OaSoftwareService oaSoftwareService;

  @GetMapping("/index")
  public String index(HttpServletRequest request) throws Exception {
    OaUser mOaUser=new OaUser();
    mOaUser.setName("dddd");
    request.setAttribute("mOaUser",mOaUser );

    //3.绑定一个list
    List<OaSoftware> list = oaSoftwareService.selectAll();
    request.setAttribute("emps", list);
    return "index";
  }

}