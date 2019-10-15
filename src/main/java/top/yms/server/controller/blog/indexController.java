package top.yms.server.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.entity.Article;
import top.yms.server.entity.IndexGroup;
import top.yms.server.service.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class indexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private PublicService publicService;


    @RequestMapping("/main")
    public Map<String, Object> main() {
        //查文章
        //查分类
        //查标签
//        return new IndexGroup(articleService.findAll(),categoryService.findAll(),
//                tagService.findAll(),"杨铭森","null");
        Map<String, Object> map = publicService.getTagAndCategoryInfo();
        map.put("articles",articleService.findAll());
        map.put("nickName","杨铭森");

        return map;
    }

}
