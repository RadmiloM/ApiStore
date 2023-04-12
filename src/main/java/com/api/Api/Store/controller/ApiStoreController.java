package com.api.Api.Store.controller;

import com.api.Api.Store.entity.ApiStore;
import com.api.Api.Store.service.ApiStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiStoreController {

    private final ApiStoreService apiStoreService;

    public ApiStoreController(ApiStoreService apiStoreService) {
        this.apiStoreService = apiStoreService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ApiStore apiStore) {
        apiStoreService.create(apiStore);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ApiStore>> findAll() {
        var apis = apiStoreService.fetchAllApis();
        return ResponseEntity.ok(apis);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiStore> findById(@PathVariable long id){
        var api = apiStoreService.findById(id);
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        apiStoreService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody ApiStore apiStore) {
        apiStoreService.update(id, apiStore);
        return ResponseEntity.ok().build();
    }
}
