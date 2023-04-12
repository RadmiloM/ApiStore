package com.api.Api.Store.service;

import com.api.Api.Store.entity.ApiStore;
import com.api.Api.Store.exception.ApiNotFoundException;
import com.api.Api.Store.repository.ApiStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiStoreService {

    private final ApiStoreRepository apiStoreRepository;

    public ApiStoreService(ApiStoreRepository apiStoreRepository) {
        this.apiStoreRepository = apiStoreRepository;
    }

    public void create(ApiStore apiStore) {
        apiStoreRepository.save(apiStore);
    }

    public ApiStore findById(long id) {
        var api = apiStoreRepository.findById(id);
        if (api.isEmpty()) {
            throw new ApiNotFoundException("api with id " + id + " is not present in database");
        }
        return api.get();
    }

    public List<ApiStore> fetchAllApis() {
        return apiStoreRepository.findAll();
    }

    public void delete(long id) {
        var api = apiStoreRepository.findById(id);
        if (api.isEmpty()) {
            throw new ApiNotFoundException("api with id " + id + " was not found in database");
        }
        var apiDB = api.get();
        apiStoreRepository.delete(apiDB);
    }

    public void update(long id, ApiStore apiStore) {
        var api = apiStoreRepository.findById(id);
        if (api.isEmpty()) {
            throw new ApiNotFoundException("api with id " + id + " was not found in database");
        }
        var apiDB = api.get();
        if (apiStore.getUrl() != null && !"".equals(apiStore.getUrl())) {
            apiDB.setUrl(apiStore.getUrl());
        }
        apiStoreRepository.save(apiDB);

    }

}
