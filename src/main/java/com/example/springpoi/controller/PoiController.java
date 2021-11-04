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

    @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Poi e) {
        poiService.create(e);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Flux<Poi> findByName(@PathVariable("name") String name) {
        return poiService.findByName(name);
    }

    @PutMapping("update")
    public Mono<Poi> updatePoi(@RequestBody Poi poiDetails) {
        return poiService.update(poiDetails);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        poiService.delete(id);
    }
}
