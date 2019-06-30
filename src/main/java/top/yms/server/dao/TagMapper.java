package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.Tag;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("SELECT id,tag_name,created_time FROM tag WHERE id=#{id}")
    public Tag findOne(@Param("id") long id);

    @Select("SELECT id,tag_name,created_time FROM tag WHERE tag_name=#{tag_name}")
    public Tag findByTagName(@Param("tag_name") String tag_name);

    @Select("SELECT id,tag_name,created_time FROM tag")
    public List<Tag> findAll();

    @Insert("INSERT INTO tag (id,tag_name,created_time)VALUES(#{id},#{tag_name},#{created_time})")
    public int add(@Param("id") long id, @Param("tag_name") String tag_name, @Param("created_time") String created_time);


    public int delete();

    @Update("UPDATE tag set tag_name=#{tag_name},created_time=#{created_time} WHERE id=#{id}")
    public int update(@Param("tag_name") String tag_name, @Param("created_time") String created_time, @Param("id") long id);

}
