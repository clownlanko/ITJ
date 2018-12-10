package top.genitalbean.itj.dao.mapper;

import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.UserEntity;

public interface UserMapper extends BaseMapper {
    UserEntity queryByAccount(String account);
}
