package com.example.user.service.impl;

import com.example.user.dao.OaSoftwareMapper;
import com.example.user.model.OaSoftware;
import com.example.user.service.OaSoftwareService;
import com.example.user.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: OaSoftwareService接口实现类
* @author df
* @date 2020/03/06 13:31
*/
@Service
public class OaSoftwareServiceImpl extends AbstractService<OaSoftware> implements OaSoftwareService {

    @Resource
    private OaSoftwareMapper oaSoftwareMapper;

}