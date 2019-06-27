package top.yms.server.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.entity.Article;
import top.yms.server.entity.Result;
import top.yms.server.service.ArticleService;

@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/add")
    public Result add(@RequestBody Article article) {

        System.out.println("okk -----------");

        if(article != null) {

        } else {
            System.out.println("article is null");
        }



        Result res = new Result(true,"add success");
        return res;
    }

}
