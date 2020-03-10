package com.example.user.service.impl;

import com.example.user.dao.OaUserMapper;
import com.example.user.model.OaUser;
import com.example.user.service.OaUserService;
import com.example.user.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author df
 * @Description: OaUserService接口实现类
 * @date 2020/03/06 15:42
 */
@Service
public class OaUserServiceImpl extends AbstractService<OaUser> implements OaUserService {

  @Resource
  private OaUserMapper oaUserMapper;

  @Override
  public OaUser selectByJobNumber(String jobNumber) {
    return oaUserMapper.selectByJobNumber(jobNumber);
  }

  @Override
  public List<OaUser> selectByOaIds(String oaIds) {
    return oaUserMapper.selectByOaIds(oaIds);
  }
}