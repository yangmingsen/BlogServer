package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.TagLinkArticleMapper;
import top.yms.server.entity.TagLinkArticle;

import java.util.List;

@Service
public class TagLinkArticleService {

    @Autowired
    private TagLinkArticleMapper tagLinkArticleMapper;

    public TagLinkArticle findOne(int id) {
        return tagLinkArticleMapper.findOne(id);
    }

    public List<TagLinkArticle> findAll() {
        return tagLinkArticleMapper.findAll();
    }

    public int add(TagLinkArticle tagLinkArticle) {
        return tagLinkArticleMapper.add(tagLinkArticle.getTagId(),tagLinkArticle.getArticleId());
    }

    /***
     *
     * @param articleId
     * @return
     */
    public int delete(long articleId) {
        return tagLinkArticleMapper.delete(articleId);
    }


}
