package com.hyg.controller;

import com.hyg.pojo.Article;
import com.hyg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 文集控制器
 */
@Controller
public class ArticleController
{
    @Qualifier("articleService")
    @Autowired

    private ArticleService articleService;
    @Value("${cbs.projectPath}")
    public String projectPath;

    @ResponseBody
    @RequestMapping("/articleList")
    public List<Article> findAllArticle()
    {
        List<Article> list=articleService.findAllArticle();
        for (Article ar:list){
            ar.setArticleImg(projectPath.concat(ar.getArticleImg()));
        }
        return list;
    }

    @GetMapping("/allArticlePageData")
	@ResponseBody
    public Map<String, Object> allArticlePageData
	(
		@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
	)
	{
		return articleService.listAllArticlePageData(pageNum, pageSize);
	}
}