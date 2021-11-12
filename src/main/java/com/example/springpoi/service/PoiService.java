package com.example.springpoi.service;

import com.example.springpoi.model.Poi;
import com.example.springpoi.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PoiService implements IPoiService {

    @Autowired
    private final PoiRepository poiRepository;

    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public Mono<Poi> create(Poi poi) {
        return poiRepository.save(poi);
    }

    public Mono<Poi> findById(Long id) {
        return poiRepository.findById(id);
    }

    public Flux<Poi> findByType(String type) {
        return poiRepository.findByType(type);
    }

    @Override
    public Flux findAll() {
        return poiRepository.findAll();
    }

    public Mono<Poi> update(Poi p) {
        return poiRepository.save(p);
    }


    public Mono delete(Long id) {
        return poiRepository.deleteById(id);
    }
}
