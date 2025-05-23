package com.prj.persistence.service.impl;
import org.springframework.stereotype.Service;
import com.prj.common.PersistenceServiceBaseImpl;
import com.prj.persistence.entity.User;
import com.prj.persistence.mapper.UserMapper;
import com.prj.persistence.service.UserPersistenceService;
@Service
public class UserPersistenceServiceImpl extends PersistenceServiceBaseImpl<UserMapper, User> implements UserPersistenceService{
}
