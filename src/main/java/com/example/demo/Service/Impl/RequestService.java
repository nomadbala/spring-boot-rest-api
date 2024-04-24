package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.RequestDTO;
import com.example.demo.Model.Request;
import com.example.demo.Repository.RequestRepository;
import com.example.demo.Service.IRequestService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service
@AllArgsConstructor
public class RequestService implements IRequestService {
    private final RequestRepository repository;

    @Override
    public List<RequestDTO> findAllRequests() {
        List<Request> requests = repository.findAll();

        return requests.stream()
                .map(this::convertToRequestDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveRequest(RequestDTO requestDTO) {
        Request request = convertToRequest(requestDTO);

        repository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateRequest(RequestDTO requestDTO) {
        Request request = convertToRequest(requestDTO);

        repository.save(request);
    }

    @Override
    public RequestDTO getRequestById(Long id) {
        Optional<Request> optionalRequest = repository.findById(id);
        RequestDTO requestDTO = null;
        if (optionalRequest.isPresent()) {
            requestDTO = convertToRequestDTO(optionalRequest.get());
        }
        return requestDTO;
    }

    private RequestDTO convertToRequestDTO(Request request) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProduct(request.getProduct());
        requestDTO.setQuantity(request.getQuantity());
        requestDTO.setDeliveryAddress(request.getDeliveryAddress());
        requestDTO.setPhoneNumber(request.getPhoneNumber());

        return requestDTO;
    }

    private Request convertToRequest(RequestDTO requestDTO) {
        Request request = new Request();
        request.setProduct(requestDTO.getProduct());
        request.setQuantity(requestDTO.getQuantity());
        request.setDeliveryAddress(requestDTO.getDeliveryAddress());
        request.setPhoneNumber(requestDTO.getPhoneNumber());

        return request;
    }
}
