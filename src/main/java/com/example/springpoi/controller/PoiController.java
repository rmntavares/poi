package com.example.springpoi.controller;

import com.example.springpoi.model.Poi;
import com.example.springpoi.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/")
public class PoiController {

    @Autowired
    private PoiService poiService;

    @RequestMapping(value = "/pois", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Poi> findAll() {
        Flux<Poi> poi = (Flux<Poi>) poiService.findAll();
        return poi;
    }

    @RequestMapping(value = "/pois/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Poi>> findById(@PathVariable("id") Long id) {
        Mono<Poi> p = poiService.findById(id);
        HttpStatus status = p != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Poi>>(p, status);
    }

    @RequestMapping(value = {"/pois/create"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mono<Poi>> create(@RequestBody Poi poi) {
        Mono<Poi> p = poiService.create(poi);
        HttpStatus status = p != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Mono<Poi>>(p,status);
    }

    @RequestMapping(value = "/poi/{type}", method = RequestMethod.GET)
    public Flux<Poi> findByType(@PathVariable("type") String type) {
        return poiService.findByType(type);
    }

    @PutMapping("/pois/{id}")
    public Mono<Poi> updatePoi(@PathVariable("id") Long id,@RequestBody Poi poiDetails) {
        poiDetails.setID(id);
        return poiService.update(poiDetails);
    }

    @RequestMapping(value = "/pois/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono> delete(@PathVariable("id") Long id) {
        Mono p = poiService.delete(id);
        HttpStatus status = p != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Mono>(p,status);
    }
}
