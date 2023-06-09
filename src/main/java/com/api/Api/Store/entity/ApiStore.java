package com.api.Api.Store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiStore {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String url;

}
