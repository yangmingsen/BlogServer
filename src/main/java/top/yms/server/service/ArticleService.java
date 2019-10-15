package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.ArticleMapper;
import top.yms.server.entity.Article;
import top.yms.server.entity.SimpleArticle;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    public Article findOne(long id) {
        Article article = articleMapper.findOne(id);
        articleMapper.updateBrowseNum(article.getBrowseNum()+1,article.getId());

        return article;
    }

    public void updateLikeNum(long id) {
        articleMapper.updateLikeNum(id);
    }


    /**
     *
     * @author yangminsen
     * @createTime 2019-07-03
     * @updateTime 2019-10-03
     * @param article_category_id
     * @return
     */
    public List<Article> findAllByCategoryId(int article_category_id) {
        return (List)articleMapper.findAllByCategoryId(article_category_id);
    }

    public List<Article> findAllByIds(String ids) {
        return articleMapper.findAllByIds(ids);
    }

    /***
     *
     * @author yangminsen
     * @createTime 2019-10-03
     * @updateTime 2019-10-03
     * @param tagId
     * @return
     *
     * @version 1.0
     * public List<Article> findAllByTagId(long tagId) {
     *         return (List)articleMapper.findAllByTagId(tagId);
     * }
     *
     */
    public List<Article> findAllByTagId(long tagId) {
        return (List)articleMapper.findAllByTagId(tagId);
    }


    public List<Article> findAll() {
        return (List)articleMapper.findAllOfSimple();
    }

    public List<Article> findAllOfAdmin() {
        return (List)articleMapper.findAllOfAdmin();
    }


    public int add(Article article) {
        return articleMapper.add(article.getId(),article.getAuthorId(),article.getArticleCategoryId(),article.getTagId(),
                article.getTitle(),article.getMarkdownDoc(),article.getContent(),article.getCreatedTime(),article.getUpdateTime(),article.getBrowseNum(),
                article.getLikeNum(),article.getIsPublic(),article.getPublishStates(),article.getIsDel(),article.getKeywords(),article.getAbstractContent(),
                article.getAllowComment());
    }

    public int update(Article article) {
        return articleMapper.update(article.getAuthorId(),article.getArticleCategoryId(),article.getTagId(),
                article.getTitle(),article.getMarkdownDoc(),article.getContent(),article.getCreatedTime(),article.getUpdateTime(),article.getBrowseNum(),
                article.getLikeNum(),article.getIsPublic(),article.getPublishStates(),article.getIsDel(),article.getKeywords(),article.getAbstractContent(),
                article.getAllowComment(),article.getId());
    }

    public int delete(long id) {
        return articleMapper.delete(id);
    }

}
