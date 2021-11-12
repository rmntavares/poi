package com.example.springpoi.service;

import com.example.springpoi.model.Poi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPoiService {
    Mono<Poi> create(Poi p);

    Mono<Poi> findById(Long id);

    Flux<Poi> findByType(String type);

    Flux findAll();

    Mono update(Poi p);

    Mono delete(Long id);
}
