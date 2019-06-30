package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.TagMapper;
import top.yms.server.entity.Tag;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public Tag findOne(long id) {
        return tagMapper.findOne(id);
    }

    public Tag findByTagName(String tagName) {
        return tagMapper.findByTagName(tagName);
    }

    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    public int add(Tag tag) {
        return tagMapper.add(tag.getId(),tag.getTagName(),tag.getCreatedTime());
    }


    public int delete() {
        return 1;
    }

    public int update(Tag tag) {
        return tagMapper.update(tag.getTagName(),tag.getCreatedTime(),tag.getId());
    }

}
