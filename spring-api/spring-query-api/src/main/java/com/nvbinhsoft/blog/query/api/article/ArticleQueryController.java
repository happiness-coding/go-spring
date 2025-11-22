package com.nvbinhsoft.blog.query.api.article;

import com.nvbinhsoft.blog.query.application.article.handler.ArticleQueryHandler;
import com.nvbinhsoft.blog.query.application.article.query.GetArticleQuery;
import com.nvbinhsoft.blog.query.application.article.query.ListArticlesQuery;
import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleQueryController {

  private final ArticleQueryHandler articleQueryHandler;

  @Autowired
  public ArticleQueryController(ArticleQueryHandler articleQueryHandler) {
    this.articleQueryHandler = articleQueryHandler;
  }

  @GetMapping
  public List<ArticleView> getAllArticles(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) Long categoryId,
      @RequestParam(required = false) String tag) {
    ListArticlesQuery query = new ListArticlesQuery(page, size, categoryId, tag);
    return articleQueryHandler.handleListArticles(query);
  }

  @GetMapping("/{slug}")
  public ArticleDetailView getArticleBySlug(@PathVariable String slug) {
    GetArticleQuery query = new GetArticleQuery(slug);
    return articleQueryHandler.handleGetArticle(query);
  }
}
