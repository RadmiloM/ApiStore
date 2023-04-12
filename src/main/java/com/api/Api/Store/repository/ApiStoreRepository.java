package com.api.Api.Store.repository;

import com.api.Api.Store.entity.ApiStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiStoreRepository extends JpaRepository<ApiStore,Long> {

}
