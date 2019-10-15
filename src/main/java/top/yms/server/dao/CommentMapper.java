package top.yms.server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.yms.server.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    /***
     *
     * @author yangminsen
     * @createTime 2019-10-06
     * @updateTime 2019-10-06
     *
     * @version 1.0
     *
     * @param articleId
     * @param username
     * @param content
     * @param createdTime
     * @return
     */
    @Insert("INSERT INTO comment (article_id,username,content,created_time)VALUES(#{articleId},#{username}," +
            "#{content},#{createdTime})")
    public int add(@Param("articleId") long articleId, @Param("username") String username,
                   @Param("content") String content, @Param("createdTime") String createdTime);

    /***
     *
     * @author yangminsen
     * @createTime 2019-10-06
     * @updateTime 2019-10-06
     *
     * @version 1.0
     * @param articleId
     * @return
     */
    @Select("SELECT id,article_id,username,content,created_time FROM comment WHERE article_id=#{articleId} " +
            "ORDER BY created_time DESC")
    public List<Comment> findAllByArticleId(@Param("articleId") long articleId);


}
