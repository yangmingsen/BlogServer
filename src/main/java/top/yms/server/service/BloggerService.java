package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.BloggerMapper;
import top.yms.server.entity.Blogger;

import java.util.List;

@Service
public class BloggerService {

    @Autowired
    private BloggerMapper bloggerMapper;

    public Blogger findByUsername(String username) {
        return bloggerMapper.findByUsername(username);
    }

    public List<Blogger> findAll() {
        return bloggerMapper.findAll();
    }

    public int add(Blogger blogger) {
        return bloggerMapper.add(blogger.getUsername(),blogger.getPassword(),blogger.getNickName(),blogger.getDescMe(),
                blogger.getProfession(),blogger.getMail(),blogger.getSkill(),blogger.getExperience(),blogger.getOtherBlog(),
                blogger.getUpdateTime());
    }

    public int update(Blogger blogger) {
        return bloggerMapper.update(blogger.getNickName(),blogger.getDescMe(),blogger.getProfession(),blogger.getMail(),
                blogger.getSkill(),blogger.getExperience(),blogger.getOtherBlog(),blogger.getUpdateTime(),blogger.getUsername());
    }

}
