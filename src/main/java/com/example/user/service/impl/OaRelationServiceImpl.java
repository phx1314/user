package com.example.user.service.impl;

import com.example.user.dao.OaRelationMapper;
import com.example.user.model.OaRelation;
import com.example.user.service.OaRelationService;
import com.example.user.core.universal.AbstractService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author df
 * @Description: OaRelationService接口实现类
 * @date 2020/03/12 16:52
 */
@Service
public class OaRelationServiceImpl extends AbstractService<OaRelation> implements OaRelationService {

  @Resource
  private OaRelationMapper oaRelationMapper;

  @Override
  public void deleteByUid(String Uid) {
    oaRelationMapper.deleteByUid(Uid);
  }
  @Override
  public List<OaRelation> selectListBySid(String sid) {
   return oaRelationMapper.selectListBySid(sid);
  }
}