package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.ArticleMapper;
import top.yms.server.entity.Article;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    public Article findOne(long id) {
        return articleMapper.findOne(id);
    }

    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    public int add(Article article) {
        return articleMapper.add(article.getId(),article.getAuthorId(),article.getArticleCategoryId(),article.getTagId(),
                article.getTitle(),article.getContent(),article.getCreatedTime(),article.getUpdateTime(),article.getBrowseNum(),
                article.getLikeNum(),article.getIsPublic(),article.getPublishStates(),article.getIsDel(),article.getKeywords());
    }

    public int update(Article article) {
        return articleMapper.update(article.getAuthorId(),article.getArticleCategoryId(),article.getTagId(),
                article.getTitle(),article.getContent(),article.getCreatedTime(),article.getUpdateTime(),article.getBrowseNum(),
                article.getLikeNum(),article.getIsPublic(),article.getPublishStates(),article.getIsDel(),article.getKeywords(),
                article.getId());
    }

    public int delete(long id) {
        return articleMapper.delete(id);
    }

}
