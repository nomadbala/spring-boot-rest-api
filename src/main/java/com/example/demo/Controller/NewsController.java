package com.example.demo.Controller;

import com.example.demo.Model.DTO.NewsDTO;
import com.example.demo.Service.INewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
@Api(value = "News controller")
public class NewsController {
    @NonNull
    private final INewsService service;

    @GetMapping
    @CrossOrigin
    @ApiOperation(value = "Get all news")
    public List<NewsDTO> getNews() {
        return service.getNews();
    }
}
