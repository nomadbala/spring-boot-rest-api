package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.NewsDTO;
import com.example.demo.Model.News;
import com.example.demo.Repository.NewsRepository;
import com.example.demo.Service.INewsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
@AllArgsConstructor
public class NewsService implements INewsService {
    private NewsRepository repository;

    @Override
    public List<NewsDTO> getNews() {
        List<News> news = repository.findAll();

        return news.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private NewsDTO convertToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle(news.getTitle());
        newsDTO.setContent(news.getContent());
        return newsDTO;
    }
}
