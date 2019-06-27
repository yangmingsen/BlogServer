package top.yms.server.entity;

import java.io.Serializable;

public class Article implements Serializable {
    private long id;
    private int authorId;
    private int articleCategoryId;
    private String tagId;
    private String title;
    private String content;
    private String createdTime;
    private String updateTime;
    private int browseNum;
    private int likeNum;
    private int isPublic;
    private int publishStates;
    private int isDel;
    private String keywords;

    public Article(long id, int authorId, int articleCategoryId,
                   String tagId, String title, String content,
                   String createTime, String updateTime, int browseNum,
                   int likeNum, int isPublic, int publishStates,
                   int isDel, String keywords) {
        this.id = id;
        this.authorId = authorId;
        this.articleCategoryId = articleCategoryId;
        this.tagId = tagId;
        this.title = title;
        this.content = content;
        this.createdTime = createTime;
        this.updateTime = updateTime;
        this.browseNum = browseNum;
        this.likeNum = likeNum;
        this.isPublic = isPublic;
        this.publishStates = publishStates;
        this.isDel = isDel;
        this.keywords = keywords;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(int articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createTime) {
        this.createdTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(int browseNum) {
        this.browseNum = browseNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getPublishStates() {
        return publishStates;
    }

    public void setPublishStates(int publishStates) {
        this.publishStates = publishStates;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
