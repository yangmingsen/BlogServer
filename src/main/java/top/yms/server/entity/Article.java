package top.yms.server.entity;

import java.io.Serializable;

/***
 * <p>+---------------------+--------------+------+-----+---------+-------+</p>
 * <p>| Field               | Type         | Null | Key | Default | Extra |</p>
 * <p>+---------------------+--------------+------+-----+---------+-------+</p>
 * <p>| id                  | bigint(20)   | NO   | PRI | NULL    |       |文章id</p>
 * <p>| author_id           | int(11)      | YES  |     | NULL    |       |作者id</p>
 * <p>| article_category_id | int(11)      | YES  |     | NULL    |       |文章分类id</p>
 * <p>| tag_id              | varchar(255) | YES  |     | NULL    |       |标签id</p>
 * <p>| title               | varchar(255) | YES  |     | NULL    |       |文章标题</p>
 * <p>| content             | longtext     | YES  |     | NULL    |       |文章内容保存的是html内容有css修饰</p>
 * <p>| created_time        | datetime     | YES  |     | NULL    |       |文章的创建时间</p>
 * <p>| update_time         | datetime     | YES  |     | NULL    |       |文章的更新时间</p>
 * <p>| browse_num          | int(11)      | YES  |     | NULL    |       |文章的浏览数</p>
 * <p>| like_num            | int(11)      | YES  |     | NULL    |       |蚊子点赞数</p>
 * <p>| is_public           | int(4)       | YES  |     | 1       |       |文章是否公开(1公开，0私有)</p>
 * <p>| publish_states      | int(4)       | YES  |     | NULL    |       |文章发表状态(1.已发布，0.草稿)</p>
 * <p>| is_del              | int(4)       | YES  |     | 0       |       |文章是否删除(1.删除，0.默认未删除)</p>
 * <p>| keywords            | varchar(255) | YES  |     | NULL    |       |文章关键字</p>
 * <p>| abstract_content    | varchar(500) | YES  |     | NULL    |       |文章摘要</p>
 * <p>| markdown_doc        | longtext     | YES  |     | NULL    |       |文章的markdown内容(管理用来修改文章的)</p>
 * <p>| allow_comment       | int(4)       | YES  |     | NULL    |       |是否运行评论(1.运行，0.不允许)</p>
 * <p>+---------------------+--------------+------+-----+---------+-------+</p>
 * @author yangmingsen
 */
public class Article implements Serializable {
    private long id;
    private int authorId;
    private int articleCategoryId;
    private String tagId;
    private String title;
    private String markdownDoc;
    private String content;
    private String createdTime;
    private String updateTime;
    private int browseNum;
    private int likeNum;
    private int isPublic;
    private int publishStates;
    private int isDel;
    private String keywords;
    private String abstractContent;
    private int allowComment;

    public Article(long id, int authorId, int articleCategoryId,
                   String tagId, String title, String markdownDoc,String content,
                   String createTime, String updateTime, int browseNum,
                   int likeNum, int isPublic, int publishStates,
                   int isDel, String keywords,String abstractContent,int allowComment) {

        this.id = id;
        this.authorId = authorId;
        this.articleCategoryId = articleCategoryId;
        this.tagId = tagId;
        this.title = title;
        this.markdownDoc = markdownDoc;
        this.content = content;
        this.createdTime = createTime;
        this.updateTime = updateTime;
        this.browseNum = browseNum;
        this.likeNum = likeNum;
        this.isPublic = isPublic;
        this.publishStates = publishStates;
        this.isDel = isDel;
        this.keywords = keywords;
        this.abstractContent = abstractContent;
        this.allowComment = allowComment;
    }


    public int getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(int allowComment) {
        this.allowComment = allowComment;
    }

    public String getMarkdownDoc() {
        return markdownDoc;
    }

    public void setMarkdownDoc(String markdownDoc) {
        this.markdownDoc = markdownDoc;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
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
