package com.example.demo.Controller;

import com.example.demo.Model.DTO.RequestDTO;
import com.example.demo.Service.IRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requests")
@Api(value = "Request controller")
public class RequestController {
    private final IRequestService service;

    @GetMapping
    @CrossOrigin
    @ApiOperation(value = "Get all requests")
    public List<RequestDTO> findAllRequests() {
         return service.findAllRequests();
    }

    @PostMapping("/save_request")
    @CrossOrigin
    @ApiOperation(value = "Save request")
    public ResponseEntity<String> saveRequest(@ApiParam(value = "RequestDTO object", required = true) @RequestBody RequestDTO requestDTO) {
        service.saveRequest(requestDTO);
        return ResponseEntity.ok("Request Created");
    }

    @DeleteMapping("/delete_request/{id}")
    @CrossOrigin
    @ApiOperation(value = "Delete request")
    public ResponseEntity<String> deleteRequest(@ApiParam(value = "Request id", required = true) @PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }

    @PutMapping("/update_request")
    @CrossOrigin
    @ApiOperation(value = "Update request")
    public ResponseEntity<String> updateRequest(@ApiParam(value = "RequestDTO object", required = true) @RequestBody RequestDTO requestDTO) {
        service.updateRequest(requestDTO);
        return ResponseEntity.ok("Request updated successfully");
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @ApiOperation(value = "Get request by id")
    public RequestDTO getRequestById(@ApiParam(value = "Request id") @PathVariable Long id) {
        return service.getRequestById(id);
    }
}
