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
import top.yms.server.entity.article.ArticleListEntity;
import top.yms.server.service.ArticleService;
import top.yms.server.service.CategoryService;
import top.yms.server.service.TagLinkArticleService;
import top.yms.server.service.TagService;
import top.yms.server.utils.DateHelper;
import top.yms.server.utils.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagLinkArticleService tagLinkArticleService;

    @Autowired
    private CategoryService categoryService;

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
     * 11.isDel默认为0表示未删除 1为删除(前台传入); 12.keywords表示检索关键字 为前台传入; 13.markdownDoc由前台传入
     * 14.abstractContent 抽象描述 （前台传入）
     *
     */
    @PostMapping("/add")
    public Result add(@RequestBody Article article) {
        Result res=null;

        if(article != null) {
            long articleId = IdGenerator.getArticleId();//使用IdGenerator生成16位的id
            article.setId(articleId);
            article.setTagId(handleTag(article.getTagId(),articleId));//处理tag信息

            /*设置创建时间和更新时间*/
            article.setCreatedTime(DateHelper.getYYYY_MM_DD_HH_MM_SS());
            article.setUpdateTime(DateHelper.getYYYY_MM_DD_HH_MM_SS());

            //执行添加文章信息到数据库操作
            articleService.add(article);

            res = new Result(true,"add article success");

        } else {
            res = new Result(false,"article data is null");
        }

        return res;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Article article) {
        Result res=null;

        if (article !=null) {
            tagLinkArticleService.delete(article.getId());//先删除原来的关系
            article.setTagId(handleTag(article.getTagId(),article.getId()));//处理tag信息
            article.setUpdateTime(DateHelper.getYYYY_MM_DD_HH_MM_SS());



            articleService.update(article);

            res = new Result(true,"update article success");
        } else {
            res = new Result(false,"article data is null");
        }

        return res;
    }

    /**
     * 传入的是数据如 {python,c++,java}
     * <p></p>
     * <h2>描述:</h2>
     * <p>1.根据传入tag =>{python,c++,java}.如果数据库中存在这些标签则直接读取标签的tagId;
     * 如果数据库中不存在改标签,则使用IdGenerator生成15位的tagId;</p>
     * <p></p>
     * <p>2.并将tagId与articleId存入t_l_a表中</p>
     * <p></p>
     * <p>3.返回如{1561719934210540,1561719934210093,1561719934210671}的tagId字符串</p>
     *
     * @param tag
     * @param articleId
     * @return 如{1561719934210540,1561719934210093,1561719934210671}
     *
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


    /**
     * 获取所有的文章,修改信息后
     * @return
     */
    @RequestMapping("/findAll")
    public List<ArticleListEntity> findAll() {
        List<Article> allArticleList = articleService.findAllOfAdmin();//从数据库中获取所有文章数据

        List<ArticleListEntity> articleListEntities = new ArrayList<>();

        for (Article article: allArticleList) {
            //根据article的categoryId向categoryService的findOne方法查找该Id的名字
            String categoryName = categoryService.findOne(article.getArticleCategoryId()).getCategoryName();

            String tagName = tagIdToTagName(article.getTagId());

            //将数据添加到articleListEntities中
            articleListEntities.add(new ArticleListEntity(article.getId(),
                    article.getTitle(),categoryName,tagName,
                    article.getLikeNum(),article.getUpdateTime()));
        }

        return articleListEntities;
    }

    /**
     * 将tagId序列转换位tagName序列
     * <p>例如:</p>
     * <p>{123324,234234,234562} => {PHP,Java,C++}</p>
     * @param tagId {123324,234234,234562}
     * @return {PHP,Java,C++}
     */
    private String tagIdToTagName(String tagId) {
        if (tagId == null || ("".equals(tagId))) return "";//判断如tagId为空或者空字符串那么直接返回

        String[] split = tagId.split(",");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < split.length-1; i++) {
            //这一部分要换成Redis缓存(现在用的是数据库查询tag标签名)
            stringBuffer.append(tagService.findOne(Long.parseLong(split[i])).getTagName()+",");
        }
        stringBuffer.append(tagService.findOne(Long.parseLong(split[split.length-1])).getTagName());

        return stringBuffer.toString();
    }

    @RequestMapping("/findOne")
    public Article findOne(@RequestBody Map searchMap) {
        String idStr = searchMap.get("id").toString();
        long id = Long.parseLong(idStr);
        Article one = articleService.findOne(id);
        if (one != null) {
            one.setTagId(tagIdToTagName(one.getTagId()));
        }

        return one;
    }

}
