package com.nvbinhsoft.blog.query.projector;

import com.nvbinhsoft.blog.domain.event.article.ArticleCreatedEvent;
import com.nvbinhsoft.blog.domain.event.article.ArticlePublishedEvent;
import com.nvbinhsoft.blog.domain.event.article.ArticleUpdatedEvent;
import com.nvbinhsoft.blog.query.model.ArticleViewModel;
import com.nvbinhsoft.blog.query.repository.ArticleViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleProjector {

    private final ArticleViewRepository articleViewRepository;

    @Autowired
    public ArticleProjector(ArticleViewRepository articleViewRepository) {
        this.articleViewRepository = articleViewRepository;
    }

    public void onArticleCreated(ArticleCreatedEvent event) {
        ArticleViewModel articleViewModel = new ArticleViewModel(
                event.getArticleId().getId(),
                event.getTitle(),
                event.getSlug(),
                event.getExcerpt(),
                event.getFeaturedImageUrl(),
                event.getPublishedAt()
        );
        articleViewRepository.save(articleViewModel);
    }

    public void onArticleUpdated(ArticleUpdatedEvent event) {
        ArticleViewModel articleViewModel = articleViewRepository.findById(event.getArticleId().getId())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleViewModel.setTitle(event.getTitle());
        articleViewModel.setSlug(event.getSlug());
        articleViewModel.setExcerpt(event.getExcerpt());
        articleViewModel.setFeaturedImageUrl(event.getFeaturedImageUrl());
        articleViewModel.setPublishedAt(event.getPublishedAt());
        articleViewRepository.save(articleViewModel);
    }

    public void onArticlePublished(ArticlePublishedEvent event) {
        ArticleViewModel articleViewModel = articleViewRepository.findById(event.getArticleId().getId())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleViewModel.setPublishedAt(event.getPublishedAt());
        articleViewRepository.save(articleViewModel);
    }
}
