package com.example.user.service;

import com.example.user.model.OaUser;
import com.example.user.core.universal.Service;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author df
 * @Description: OaUserService接口
 * @date 2020/03/06 15:42
 */
public interface OaUserService extends Service<OaUser> {
  OaUser selectByJobNumber(String jobNumber);

  List<OaUser> selectByOaIds(String oaIds);
}