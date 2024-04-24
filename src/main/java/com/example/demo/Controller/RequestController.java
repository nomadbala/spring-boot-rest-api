package com.example.demo.Controller;

import com.example.demo.Model.DTO.RequestDTO;
import com.example.demo.Service.IRequestService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requests")
public class RequestController {
    private final IRequestService service;

    @GetMapping
    @CrossOrigin
    public List<RequestDTO> findAllRequests() {
         return service.findAllRequests();
    }

    @PostMapping("/save_request")
    @CrossOrigin
    public ResponseEntity<String> saveRequest(@RequestBody RequestDTO requestDTO) {
        service.saveRequest(requestDTO);
        return ResponseEntity.ok("Request Created");
    }

    @DeleteMapping("/delete_request/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }

    @PutMapping("/update_request")
    @CrossOrigin
    public ResponseEntity<String> updateRequest(@RequestBody RequestDTO requestDTO) {
        service.updateRequest(requestDTO);
        return ResponseEntity.ok("Request updated successfully");
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public RequestDTO getRequestById(@PathVariable Long id) {
        return service.getRequestById(id);
    }
}
