package top.yms.server.entity.article;

/***
 *
 * <h2>描述</h2>
 * <p>这个实体类用于管理后台的文章列表显示.</p>
 *
 * @author yangmingsen
 */
public class ArticleListEntity {
    private long id;
    private String title;
    private String categoryName;
    private String tagName;
    private int likeNum;
    private String updateTime;

    public ArticleListEntity(long id, String title, String categoryName, String tagName, int likeNum, String updateTime) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.tagName = tagName;
        this.likeNum = likeNum;
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
