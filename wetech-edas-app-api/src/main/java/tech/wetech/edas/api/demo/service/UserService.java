package tech.wetech.edas.api.demo.service;

import tech.wetech.edas.api.demo.model.User;

import java.util.List;

/**
 * 测试数据库增删改查
 * @author cjbi
 */
public interface UserService {

    /**
     * 查询用户列表
     * @return
     */
    List<User> findAll();

    /**
     * 查询用户
     * @param userId
     * @return
     */
    User findOne(Integer userId);

    /**
     * 创建用户
     * @param user
     * @return
     */
    public int createUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

}
