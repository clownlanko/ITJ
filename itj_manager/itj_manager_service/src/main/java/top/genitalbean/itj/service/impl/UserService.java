package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.dao.mapper.UserMapper;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.service.BaseService;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UserService implements BaseService<UserEntity> {
    @Autowired UserMapper userMapper;
    @Override
    public boolean insert(UserEntity e) {
        userMapper.insert(e);
        return e.getUserId()>0;
    }

    @Override
    public boolean update(UserEntity e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public  List<UserEntity> query() {
        return null;
    }

    /**
     * 根据账户查找用户
     * @param account 账户
     * @return 返回一个用户
     * @throws NoDataMatchException 没有找到数据引发的异常
     */
    public UserEntity queryByAccount(String account) throws NoDataMatchException{
        UserEntity user = userMapper.queryByAccount(account);
        if(user==null){
            throw new NoDataMatchException("No user of named "+account);
        }
        return user;
    }
    public UserEntity queryByUser(String account,String password) throws NoDataMatchException{
        UserEntity user = userMapper.queryByUser(account,password);
        if(user==null){
            throw new NoDataMatchException("No user of named "+account);
        }
        return user;
    }
}
