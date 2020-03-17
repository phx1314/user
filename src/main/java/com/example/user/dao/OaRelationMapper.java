package com.example.user.dao;

import com.example.user.core.universal.Mapper;
import com.example.user.model.OaRelation;

import java.util.List;

public interface OaRelationMapper extends Mapper<OaRelation> {

  void deleteByUid(String uid);

  List<OaRelation> selectListBySid(String sid);
  List<OaRelation> selectListByIds(String isd);
}