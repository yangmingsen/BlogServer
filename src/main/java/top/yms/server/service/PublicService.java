package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.CategoryMapper;
import top.yms.server.dao.TagMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PublicService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private TagMapper tagMapper;


    public Map<String,Object> getTagAndCategoryInfo() {
        Map<String, Object> hashMap = new ConcurrentHashMap<>();

        hashMap.put("categorys",categoryMapper.findAll());
        hashMap.put("tags",tagMapper.findAll());

        return hashMap;
    }

}
