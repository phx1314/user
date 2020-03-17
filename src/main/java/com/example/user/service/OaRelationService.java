package com.example.user.service;

import com.example.user.model.OaRelation;
import com.example.user.core.universal.Service;

import java.util.List;

/**
 * @author df
 * @Description: OaRelationService接口
 * @date 2020/03/12 16:52
 */
public interface OaRelationService extends Service<OaRelation> {
  void deleteByUid(String Uid);
  List<OaRelation> selectListBySid(String sid);
}