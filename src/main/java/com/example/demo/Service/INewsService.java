package com.example.demo.Service;

import com.example.demo.Model.DTO.NewsDTO;

import java.util.List;

public interface INewsService {
    List<NewsDTO> getNews();
}
