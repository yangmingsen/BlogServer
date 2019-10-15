package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.Blogger;

import java.util.List;

@Mapper
public interface BloggerMapper {

    @Select("SELECT * FROM blogger WHERE username=#{username}")
    public Blogger findByUsername(@Param("username") String username);

    @Select("SELECT * FROM blogger")
    public List<Blogger> findAll();

    @Insert("INSERT INTO blogger(username,password,nick_name,desc_me,profession,mail,skill,experience,other_blog,update_time)VALUES" +
            "(#{username},#{password},#{nick_name},#{desc_me},#{profession},#{mail},#{skill},#{experience},#{other_blog},#{update_time})")
    public int add(@Param("username") String username, @Param("password") String password,@Param("nick_name") String nick_name,
                   @Param("desc_me") String desc_me,@Param("profession") String profession,@Param("mail") String mail,
                   @Param("skill") String skill,@Param("experience") String experience,@Param("other_blog") String other_blog,
                   @Param("update_time") String update_time);

    @Update("UPDATE blogger SET nick_name=#{nick_name},desc_me=#{desc_me}," +
            "profession=#{profession},mail=#{mail},skill=#{skill},experience=#{experience}," +
            "other_blog=#{other_blog},update_time=#{update_time} WHERE username=#{username}")
    public int update(@Param("nick_name") String nick_name,@Param("desc_me") String desc_me,@Param("profession") String profession,
                      @Param("mail") String mail,@Param("skill") String skill,@Param("experience") String experience,
                      @Param("other_blog") String other_blog,@Param("update_time") String update_time, @Param("username") String username);


}
