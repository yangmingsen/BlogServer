package top.yms.server.entity;

/***
 * 这是tag与article的关系表实体
 */
public class TagLinkArticle {

    private int id;
    private long tagId;
    private long articleId;

    public TagLinkArticle(int id, long tagId, long articleId) {
        this.id = id;
        this.tagId = tagId;
        this.articleId = articleId;
    }

    public TagLinkArticle(long tagId, long articleId) {
        this.tagId = tagId;
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
