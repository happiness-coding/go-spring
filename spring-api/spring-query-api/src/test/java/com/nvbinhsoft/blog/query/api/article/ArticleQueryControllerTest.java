package com.nvbinhsoft.blog.query.api.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvbinhsoft.blog.query.application.article.handler.ArticleQueryHandler;
import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleQueryController.class)
public class ArticleQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleQueryHandler articleQueryHandler;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllArticles() throws Exception {
        List<ArticleView> articles = Arrays.asList(
                new ArticleView(1L, "Test Title 1", "test-title-1", "Test excerpt 1", "http://example.com/image1.jpg", LocalDateTime.now()),
                new ArticleView(2L, "Test Title 2", "test-title-2", "Test excerpt 2", "http://example.com/image2.jpg", LocalDateTime.now())
        );

        Mockito.when(articleQueryHandler.handleListArticles(Mockito.any())).thenReturn(articles);

        mockMvc.perform(get("/articles")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Test Title 1"))
                .andExpect(jsonPath("$[0].slug").value("test-title-1"))
                .andExpect(jsonPath("$[0].excerpt").value("Test excerpt 1"))
                .andExpect(jsonPath("$[0].featuredImageUrl").value("http://example.com/image1.jpg"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].title").value("Test Title 2"))
                .andExpect(jsonPath("$[1].slug").value("test-title-2"))
                .andExpect(jsonPath("$[1].excerpt").value("Test excerpt 2"))
                .andExpect(jsonPath("$[1].featuredImageUrl").value("http://example.com/image2.jpg"));
    }

    @Test
    public void testGetArticleBySlug() throws Exception {
        ArticleDetailView article = new ArticleDetailView(
                1L,
                "Test Title",
                "test-title",
                "Test content",
                "Test excerpt",
                "http://example.com/image.jpg",
                LocalDateTime.now(),
                "Test category",
                Arrays.asList("tag1", "tag2")
        );

        Mockito.when(articleQueryHandler.handleGetArticle(Mockito.any())).thenReturn(article);

        mockMvc.perform(get("/articles/test-title")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.slug").value("test-title"))
                .andExpect(jsonPath("$.content").value("Test content"))
                .andExpect(jsonPath("$.excerpt").value("Test excerpt"))
                .andExpect(jsonPath("$.featuredImageUrl").value("http://example.com/image.jpg"))
                .andExpect(jsonPath("$.category").value("Test category"))
                .andExpect(jsonPath("$.tags[0]").value("tag1"))
                .andExpect(jsonPath("$.tags[1]").value("tag2"));
    }
}
