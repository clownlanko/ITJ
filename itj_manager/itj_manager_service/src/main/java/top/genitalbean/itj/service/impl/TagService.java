package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.dao.mapper.TagMapper;
import top.genitalbean.itj.pojo.TagEntity;
import top.genitalbean.itj.service.BaseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService implements BaseService<TagEntity > {
    @Autowired TagMapper tagMapper;

    /**
     * 添加多个标签元素
     * @param tags 标签
     * @return 是否添加成功
     */
    public List<TagEntity> insertMultipartTag(List<TagEntity> tags){
        //查询出所有已有的标签
        List<TagEntity> list = query();
        //遍历得出某个标签是否已经存在
        list.forEach((tag)->tags.forEach((t)->{
            //所有数据大小写
            if(tag.getTagName().toLowerCase().equals(t.getTagName().toLowerCase())){
                t.setTagId(tag.getTagId());
                t.setExists(true);
            }
        }));
        //得到不存在的标签
        List<TagEntity> notExistsTags=new ArrayList<>();
        tags.forEach((tag)-> {
            if(!tag.isExists()){
                notExistsTags.add(tag);
            }
        });
        if(!notExistsTags.isEmpty())
            notExistsTags.forEach((tag)->{
                insert(tag);
            });
        return tags;
    }

    /**
     * 根基id查找
     * @param tagId 标签Id
     * @return 一个标签
     * @throws NoDataMatchException 没有数据引发的异常
     */
    public TagEntity findByTagId(Integer tagId) throws NoDataMatchException{
        TagEntity tag = tagMapper.findByTagId(tagId);
        if(tag!=null)
            return tag;
        else
            throw new NoDataMatchException("No tag of id is "+tagId);
    }
    @Override
    public boolean insert(TagEntity e) {
        return tagMapper.insert(e)==1;
    }

    @Override
    public boolean update(TagEntity e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public List<TagEntity> query() {
        return tagMapper.query();
    }
}
