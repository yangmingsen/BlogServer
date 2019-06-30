package top.yms.server.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.entity.Article;
import top.yms.server.entity.Result;
import top.yms.server.entity.Tag;
import top.yms.server.entity.TagLinkArticle;
import top.yms.server.service.ArticleService;
import top.yms.server.service.TagLinkArticleService;
import top.yms.server.service.TagService;
import top.yms.server.utils.DateHelper;
import top.yms.server.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagLinkArticleService tagLinkArticleService;

    @Autowired
    private TagService tagService;

    /***
     * 1.使用IdGenerator获取id; 2.作者id由前端传来(authorId); 3.文章分类id由前端传入(articleCategoryId)
     *
     * 4.tagId使用IdGenerator生成(生成后同时向t_l_a表插入),tag_id传入的数据格式可能是 python,java,c++;
     *
     * 5.title由前台传入; 6.content由前台传入; 7.createdTime和updateTime由后台生成; 8.browseNum默认位0(add时前端传入)
     *
     * 9.likeNum默认位0(add时前端传入); isPublic默认位1表示公开 0表示私有(前端传入); 10.发布状态publishStates 默认为1表示公开 0表示私有(前端传入);
     *
     * 11.isDel默认为0表示未删除 1为删除; 12.keywords表示检索关键字 为前台传入
     *
     */
    @PostMapping("/add")
    public Result add(@RequestBody Article article) {

        Result res=null;

        if(article != null) {
            long articleId = IdGenerator.getArticleId();
            article.setId(articleId);
            article.setTagId(handleTag(article.getTagId(),articleId));
            article.setCreatedTime(DateHelper.getYYYY_MM_DD_HH_MM_SS());
            article.setUpdateTime(DateHelper.getYYYY_MM_DD_HH_MM_SS());

            articleService.add(article);

            res = new Result(true,"add article success");

        } else {
            res = new Result(false,"article data is null");
        }


        return res;
    }

    /**
     * 传入的是数据如 {python,c++,java}
     * @param tag
     * @return 如{1561719934210540,1561719934210093,1561719934210671}
     */
    private String handleTag(String tag,long articleId) {

        String[] split = tag.split(",");
        StringBuffer tagIds = new StringBuffer("");
        for(int i=0; i<split.length; i++) {

            //必须先判断当前tag名称在数据库是否存在 如果存在就不添加取已经存在的tagId(数据库存在的),并且不忘tag表添加数据库
            Tag tag1 = tagService.findByTagName(split[i]);//使用tag名称前往数据库查询

            long tagId;
            if(tag1 == null) {//如果数据库tag表中不存在该标签
                tagId = IdGenerator.getTagId();//获取一个生成的tag_id
                tagService.add(new Tag(tagId,split[i], DateHelper.getYYYY_MM_DD_HH_MM_SS()));//存入数据库tag表中
            } else {
                tagId = tag1.getId();//获取该标签在数据库已经存在的id
            }

            //将tag与文章的关系 添加到数据库t_l_a表中
            tagLinkArticleService.add(new TagLinkArticle(tagId,articleId));


            if(i+1 != split.length)
                tagIds.append(tagId+",");
            else
                tagIds.append(tagId);
        }

        return tagIds.toString();

    }




}
