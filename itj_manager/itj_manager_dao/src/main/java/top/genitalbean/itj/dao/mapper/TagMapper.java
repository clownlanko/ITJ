package top.genitalbean.itj.dao.mapper;

import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.TagEntity;

import java.util.List;

public interface TagMapper extends BaseMapper {
    TagEntity findByTagId(Integer tagId);
    Integer insertMultipartTag(List<TagEntity> tags);
}
