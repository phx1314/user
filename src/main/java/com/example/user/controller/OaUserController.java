package com.example.user.controller;

import com.example.user.core.ret.RetResponse;
import com.example.user.core.ret.RetResult;
import com.example.user.core.utils.ApplicationUtils;
import com.example.user.model.OaRelation;
import com.example.user.model.OaUser;
import com.example.user.service.OaRelationService;
import com.example.user.service.OaUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author df
 * @Description: OaUserController类
 * @date 2020/03/06 15:42
 */
@RestController
@RequestMapping("/oaUser")
public class OaUserController {

  @Resource
  private OaUserService oaUserService;
  @Resource
  private OaRelationService oaRelationService;

  @PostMapping("/insert")
  public RetResult<Integer> insert(@RequestBody OaUser oaUser) throws Exception {
    OaUser oaUser_query = oaUserService.selectBy("jobNumber", oaUser.getJobNumber());
//    OaUser oaUser_query2 = oaUserService.selectByJobNumber( oaUser.getJobNumber());
//    oaUserService.selectListByIds()
    String[] oaIds = oaUser.getOaIds().split(",");
    if (oaUser_query != null) {
      oaUser.setId(oaUser_query.getId());
      Integer state = oaUserService.update(oaUser);
      oaRelationService.deleteByUid(oaUser.getId());
      for (String id : oaIds) {
        Integer i = oaRelationService.insert(new OaRelation(ApplicationUtils.getUUID(), oaUser.getId(), id));
      }
      return RetResponse.makeOKRsp(state);
    } else {
      oaUser.setId(ApplicationUtils.getUUID());
      Integer state = oaUserService.insert(oaUser);
      for (String id : oaIds) {
        Integer i = oaRelationService.insert(new OaRelation(ApplicationUtils.getUUID(), oaUser.getId(), id));
      }
      return RetResponse.makeOKRsp(state);
    }
  }

  @PostMapping("/deleteById")
  public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
    Integer state = oaUserService.deleteById(id);
    return RetResponse.makeOKRsp(state);
  }

  @PostMapping("/update")
  public RetResult<Integer> update(@RequestBody OaUser oaUser) throws Exception {
    Integer state = oaUserService.update(oaUser);
    return RetResponse.makeOKRsp(state);
  }

  @PostMapping("/selectById")
  public RetResult<OaUser> selectById(@RequestParam String id) throws Exception {
    OaUser oaUser = oaUserService.selectById(id);
    return RetResponse.makeOKRsp(oaUser);
  }

  /**
   * @param page 页码
   * @param size 每页条数
   * @Description: 分页查询
   * @Reutrn RetResult<PageInfo < OaUser>>
   */
  @PostMapping("/list")
  public RetResult<PageInfo<OaUser>> list(@RequestParam(defaultValue = "0") Integer page,
                                          @RequestParam(defaultValue = "0") Integer size) throws Exception {
    PageHelper.startPage(page, size);
    List<OaUser> list = oaUserService.selectAll();
    PageInfo<OaUser> pageInfo = new PageInfo<OaUser>(list);
    return RetResponse.makeOKRsp(pageInfo);
  }

  /**
   * @param page 页码
   * @param size 每页条数
   * @Description: 分页查询
   * @Reutrn RetResult<PageInfo < OaUser>>
   */
  @PostMapping("/selectByOaIds")
  public RetResult<PageInfo<OaUser>> selectByOaIds(@RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "5") Integer size, @RequestParam String oaIds) throws Exception {
    PageHelper.startPage(page, size);
    List<OaUser> list = oaUserService.selectByOaIds(oaIds);
    PageInfo<OaUser> pageInfo = new PageInfo<OaUser>(list);
    return RetResponse.makeOKRsp(pageInfo);
  }

  /**
   * @param page 页码
   * @param size 每页条数
   * @Description: 分页查询
   * @Reutrn RetResult<PageInfo < OaUser>>
   */
  @PostMapping("/selectByOaId")
  public RetResult<PageInfo<OaUser>> selectByOaId(@RequestParam(defaultValue = "1") Integer page,
                                                  @RequestParam(defaultValue = "5") Integer size, @RequestParam String oaId) throws Exception {
    PageHelper.startPage(page, size);
    List<OaRelation> list = oaRelationService.selectListBySid(oaId);
    String uis = "";

    List<String> ids = new ArrayList<>();
    for (OaRelation item : list) {
      uis += item.getUid() + ",";
      ids.add(item.getUid());
    }
    List<OaUser> data = new ArrayList<>();
    if (!StringUtils.isEmpty(uis)) {
      uis = uis.substring(0, uis.length() - 1);
//      data = oaUserService.selectListByIds(uis);
      data = oaUserService.selectLisByIds(ids);
    }
    PageInfo<OaUser> pageInfo = new PageInfo<OaUser>(data);
    return RetResponse.makeOKRsp(pageInfo);
  }
}