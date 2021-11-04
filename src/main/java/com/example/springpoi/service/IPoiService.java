package com.example.springpoi.service;

import com.example.springpoi.model.Poi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPoiService {
    void create(Poi p);

    Mono<Poi> findById(Long id);

    Flux<Poi> findByName(String name);

    Flux findAll();

    Mono update(Poi p);

    void delete(Long id);
}
