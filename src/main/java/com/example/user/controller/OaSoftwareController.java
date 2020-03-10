package com.example.user.controller;

import com.example.user.core.ret.RetResult;
import com.example.user.core.ret.RetResponse;
import com.example.user.core.utils.ApplicationUtils;
import com.example.user.model.OaSoftware;
import com.example.user.service.OaSoftwareService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author df
 * @Description: OaSoftwareController类
 * @date 2020/03/06 13:31
 */
@RestController
@RequestMapping("/oaSoftware")
public class OaSoftwareController {

  @Resource
  private OaSoftwareService oaSoftwareService;

  @PostMapping("/insert")
  public RetResult<Integer> insert(@RequestBody OaSoftware oaSoftware) throws Exception {
    oaSoftware.setId(ApplicationUtils.getUUID());
    Integer state = oaSoftwareService.insert(oaSoftware);
    return RetResponse.makeOKRsp(state);
  }

  @PostMapping("/selectAll")
  public List<OaSoftware> selectAll() throws Exception {
    return oaSoftwareService.selectAll();
  }

  @PostMapping("/deleteById")
  public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
    Integer state = oaSoftwareService.deleteById(id);
    return RetResponse.makeOKRsp(state);
  }

  @PostMapping("/update")
  public RetResult<Integer> update(@RequestBody OaSoftware oaSoftware) throws Exception {
    Integer state = oaSoftwareService.update(oaSoftware);
    return RetResponse.makeOKRsp(state);
  }

  @PostMapping("/selectById")
  public RetResult<OaSoftware> selectById(@RequestParam String id) throws Exception {
    OaSoftware oaSoftware = oaSoftwareService.selectById(id);
    return RetResponse.makeOKRsp(oaSoftware);
  }

  /**
   * @param page 页码
   * @param size 每页条数
   * @Description: 分页查询
   * @Reutrn RetResult<PageInfo < OaSoftware>>
   */
  @PostMapping("/list")
  public RetResult<PageInfo<OaSoftware>> list(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "0") Integer size) throws Exception {
    PageHelper.startPage(page, size);
    List<OaSoftware> list = oaSoftwareService.selectAll();
    PageInfo<OaSoftware> pageInfo = new PageInfo<OaSoftware>(list);
    return RetResponse.makeOKRsp(pageInfo);
  }
}