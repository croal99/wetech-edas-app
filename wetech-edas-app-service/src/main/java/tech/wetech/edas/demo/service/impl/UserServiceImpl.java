package tech.wetech.edas.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.edas.demo.model.User;
import tech.wetech.edas.api.demo.service.UserService;
import tech.wetech.edas.demo.mapper.UserMapper;
import tech.wetech.edas.demo.model.UserExample;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试数据库增删改查
 * @author cjbi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<tech.wetech.edas.api.demo.model.User> findAll() {
        List<tech.wetech.edas.api.demo.model.User> list = new ArrayList<>();
        userMapper.selectByExample(new UserExample()).forEach(userRecord -> {
            tech.wetech.edas.api.demo.model.User user = new tech.wetech.edas.api.demo.model.User();
            BeanUtils.copyProperties(userRecord,user);
            list.add(user);
        });
        return list;
    }

    @Override
    public tech.wetech.edas.api.demo.model.User findOne(Integer userId) {
        User userRecord = userMapper.selectByPrimaryKey(userId);
        tech.wetech.edas.api.demo.model.User user = new tech.wetech.edas.api.demo.model.User();
        BeanUtils.copyProperties(userRecord,user);
        return user;
    }

    @Override
    public int createUser(tech.wetech.edas.api.demo.model.User user) {
        User userRecord = new User();
        BeanUtils.copyProperties(user,userRecord);
        return userMapper.insertSelective(userRecord);
    }

    @Override
    public int updateUser(tech.wetech.edas.api.demo.model.User user) {
        User userRecord = new User();
        BeanUtils.copyProperties(user,userRecord);
        return userMapper.updateByPrimaryKeySelective(userRecord);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

}
