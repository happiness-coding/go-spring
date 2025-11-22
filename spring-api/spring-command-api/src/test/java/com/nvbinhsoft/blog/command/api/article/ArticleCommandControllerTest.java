package com.nvbinhsoft.blog.command.api.article;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvbinhsoft.blog.command.application.article.handler.ArticleCommandHandler;
import com.nvbinhsoft.blog.command.dto.request.CreateArticleRequest;
import com.nvbinhsoft.blog.command.dto.request.UpdateArticleRequest;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleCommandController.class)
public class ArticleCommandControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private ArticleCommandHandler articleCommandHandler;

  private ObjectMapper objectMapper;

  @BeforeEach
  public void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  public void testCreateArticle() throws Exception {
    CreateArticleRequest request =
        new CreateArticleRequest(
            "Test Title",
            "test-title",
            "Test content",
            "Test excerpt",
            "http://example.com/image.jpg",
            "draft",
            1L,
            Arrays.asList("tag1", "tag2"));

    mockMvc
        .perform(
            post("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.message").value("Article created successfully"));
  }

  @Test
  public void testUpdateArticle() throws Exception {
    UpdateArticleRequest request =
        new UpdateArticleRequest(
            1L,
            "Updated Title",
            "updated-title",
            "Updated content",
            "Updated excerpt",
            "http://example.com/updated-image.jpg",
            "published",
            2L,
            Arrays.asList("tag3", "tag4"));

    mockMvc
        .perform(
            put("/articles/updated-title")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.message").value("Article updated successfully"));
  }

  @Test
  public void testDeleteArticle() throws Exception {
    mockMvc
        .perform(delete("/articles/test-title"))
        .andExpect(status().isNoContent())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.message").value("Article deleted successfully"));
  }

  @Test
  public void testPublishArticle() throws Exception {
    mockMvc
        .perform(post("/articles/1/publish"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.message").value("Article published successfully"));
  }
}
