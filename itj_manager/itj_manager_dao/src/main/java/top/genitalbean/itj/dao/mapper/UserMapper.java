package top.genitalbean.itj.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.UserEntity;

public interface UserMapper extends BaseMapper {
    UserEntity queryByAccount(String account);
    UserEntity queryByUser(@Param("account") String account, @Param("password") String password);
}
