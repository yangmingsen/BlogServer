package top.yms.server.entity;

import java.io.Serializable;

public class Blogger implements Serializable {
    private int id;
    private String username;
    private String password;
    private String nickName;
    private String descMe;
    private String profession;
    private String mail;
    private String skill;
    private String experience;
    private String otherBlog;
    private String updateTime;

    public Blogger(int id, String username, String password, String nickName, String descMe,
                   String profession, String mail, String skill, String experience,
                   String otherBlog, String updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.descMe = descMe;
        this.profession = profession;
        this.mail = mail;
        this.skill = skill;
        this.experience = experience;
        this.otherBlog = otherBlog;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getOtherBlog() {
        return otherBlog;
    }

    public void setOtherBlog(String otherBlog) {
        this.otherBlog = otherBlog;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
