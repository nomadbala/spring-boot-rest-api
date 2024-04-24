package com.example.demo.Service;

import com.example.demo.Model.DTO.RequestDTO;

import java.util.List;

public interface IRequestService {
    List<RequestDTO> findAllRequests();

    void saveRequest(RequestDTO requestDTO);

    void deleteRequest(Long id);

    void updateRequest(RequestDTO requestDTO);

    RequestDTO getRequestById(Long id);
}
