package com.example.user.dao;

import com.example.user.core.universal.Mapper;
import com.example.user.model.OaUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OaUserMapper extends Mapper<OaUser> {

  //  @Select("select * from oa_user where job_number = #{jobNumber}")
  OaUser selectByJobNumber(String jobNumber);

  List<OaUser> selectByOaIds(String oaIds);
  List<OaUser> selectLisByIds(@Param("lists")List<String> lists);
}