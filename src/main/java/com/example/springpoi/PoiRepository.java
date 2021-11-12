package com.example.springpoi;

import com.example.springpoi.model.Poi;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public interface PoiRepository extends ReactiveCrudRepository<Poi,Long> {

    Flux<Poi> findByType(final String type);
}
