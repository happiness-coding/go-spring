package com.nvbinhsoft.blog.query.api.statistics;

import com.nvbinhsoft.blog.query.application.statistics.handler.StatisticsQueryHandler;
import com.nvbinhsoft.blog.query.dto.ArticleStatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsQueryController {

    private final StatisticsQueryHandler statisticsQueryHandler;

    @Autowired
    public StatisticsQueryController(StatisticsQueryHandler statisticsQueryHandler) {
        this.statisticsQueryHandler = statisticsQueryHandler;
    }

    @GetMapping("/articles")
    public List<ArticleStatView> getArticleStatistics(@RequestParam(required = false) String startDate,
                                                      @RequestParam(required = false) String endDate) {
        return statisticsQueryHandler.handleGetArticleStatistics(startDate, endDate);
    }

    @GetMapping("/articles/{articleId}")
    public List<ArticleStatView> getArticleStatisticsById(@PathVariable Long articleId,
                                                          @RequestParam(required = false) String startDate,
                                                          @RequestParam(required = false) String endDate) {
        return statisticsQueryHandler.handleGetArticleStatisticsById(articleId, startDate, endDate);
    }
}
