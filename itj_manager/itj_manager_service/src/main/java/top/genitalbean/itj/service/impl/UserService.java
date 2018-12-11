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
public class UserService implements BaseService {
    @Autowired UserMapper userMapper;
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = {
            RuntimeException.class, FileNotFoundException.class
    })
    @Override
    public <E> boolean insert(E e) {
        return userMapper.insert(e)==1;
    }

    @Override
    public <E> boolean update(E e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public <E> List<E> query() {
        return null;
    }

    /**
     * 根据账户查找用户
     * @param account 账户
     * @return 返回一个用户
     * @throws NoDataMatchException 没有找到数据引发的异常
     */
    @Transactional(readOnly = true,rollbackFor = NoDataMatchException.class)
    public UserEntity queryByAccount(String account) throws NoDataMatchException{
        UserEntity user = userMapper.queryByAccount(account);
        if(user==null){
            throw new NoDataMatchException("No user of named "+account);
        }
        return user;
    }
    @Transactional(readOnly = true,rollbackFor = NoDataMatchException.class)
    public UserEntity queryByUser(String account,String password) throws NoDataMatchException{
        UserEntity user = userMapper.queryByUser(account,password);
        if(user==null){
            throw new NoDataMatchException("No user of named "+account);
        }
        return user;
    }
}
