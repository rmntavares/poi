package com.example.springpoi.service;

import com.example.springpoi.model.Poi;
import com.example.springpoi.PoiRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PoiService implements IPoiService{

    private final PoiRepository poiRepository;

    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public void create(Poi poi){
        poiRepository.save(poi);
    }

    public Mono<Poi> findById(Long id) {
        return poiRepository.findById(id);
    }

    public Flux<Poi> findByName(String name) {
        return poiRepository.findByName(name);
    }

    @Override
    public Flux findAll() {
        return poiRepository.findAll();
    }

    public Mono<Poi> update(Poi p) {
        return poiRepository.save(p);
    }


    public void delete(Long id) {
        poiRepository.deleteById(id);
    }
}
