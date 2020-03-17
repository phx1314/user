package com.example.user.controller;

import com.example.user.core.ret.RetResult;
import com.example.user.core.ret.RetResponse;
import com.example.user.core.utils.ApplicationUtils;
import com.example.user.model.OaRelation;
import com.example.user.service.OaRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: OaRelationController类
* @author df
* @date 2020/03/12 16:52
*/
@RestController
@RequestMapping("/oaRelation")
public class OaRelationController {

    @Resource
    private OaRelationService oaRelationService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(@RequestBody OaRelation oaRelation) throws Exception{
		oaRelation.setId(ApplicationUtils.getUUID());
    	Integer state = oaRelationService.insert(oaRelation);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = oaRelationService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(@RequestBody OaRelation oaRelation) throws Exception {
        Integer state = oaRelationService.update(oaRelation);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<OaRelation> selectById(@RequestParam String id) throws Exception {
        OaRelation oaRelation = oaRelationService.selectById(id);
        return RetResponse.makeOKRsp(oaRelation);
    }

    /**
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn RetResult<PageInfo<OaRelation>>
	*/
    @PostMapping("/list")
    public RetResult<PageInfo<OaRelation>> list(@RequestParam(defaultValue = "0") Integer page,
					@RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<OaRelation> list = oaRelationService.selectAll();
        PageInfo<OaRelation> pageInfo = new PageInfo<OaRelation>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}