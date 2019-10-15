package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.TagLinkArticle;

import java.util.List;

@Mapper
public interface TagLinkArticleMapper {

    @Select("SELECT id,tag_id,article_id FROM t_l_a WHERE id=#{id}")
    public TagLinkArticle findOne(@Param("id") int id);

    @Select("SELECT id,tag_id,article_id FROM t_l_a")
    public List<TagLinkArticle> findAll();

    @Insert("INSERT INTO t_l_a (tag_id,article_id)VALUES(#{tag_id},#{article_id})")
    public int add(@Param("tag_id") long tag_id, @Param("article_id") long article_id);

    /***
     * <h3>描述：</h3>
     * <p>为什么会有DELETE SQL这种代码,完全就是自己瞎鸡儿设计的,本以为很完美,很方便查询.</p>
     * <p>emmmm,确实方便根据tagid进行查询文章. 但TM不方便tag标签的更新呀!</p>
     * <p>为什么这么说?</p>
     * <p>就是在我将文章更新标签时,这个表设计它不好更新相应的tagid</p>
     * <p>So.所以最后考虑就是,每次更新标签时.先删掉原来的文章标签关系,重新建立关系..</p>
     * <p></p>
     * <p>经过这次,以后我设计表时一定要从关系的增删查改四个方面考虑！！！</p>
     *
     * @param articleId
     * @return
     */
    @Delete("DELETE FROM t_l_a WHERE article_id=#{articleId}")
    public int delete(@Param("articleId") long articleId);


}
