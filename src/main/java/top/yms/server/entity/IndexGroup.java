package top.yms.server.entity;

import java.util.List;

public class IndexGroup {
    private List<Article> articles;
    private List<Category> categorys;
    private List<Tag> tags;
    private String nickName;
    private String descMe;

    public IndexGroup(List<Article> articles, List<Category> categorys, List<Tag> tags, String nickName, String descMe) {
        this.articles = articles;
        this.categorys = categorys;
        this.tags = tags;
        this.nickName = nickName;
        this.descMe = descMe;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescMe() {
        return descMe;
    }

    public void setDescMe(String descMe) {
        this.descMe = descMe;
    }
}
