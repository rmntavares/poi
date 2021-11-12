package com.example.springpoi.controller;

import com.example.springpoi.PoiRepository;
import com.example.springpoi.model.Poi;
import com.example.springpoi.service.IPoiService;
import com.example.springpoi.service.PoiService;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@WebFluxTest(PoiController.class)
@Import(PoiService.class)
class PoiControllerTest {

    @MockBean
    PoiService poiService ;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void findAll() throws Exception {
        webTestClient.get().uri("/api/pois").exchange().expectStatus().isOk();
    }

    @Test
    void findById() {
        Poi poi = new Poi();
        poi.setID(5L);

        Mockito.when(poiService.findById(5L)).thenReturn(Mono.just(poi));

        webTestClient.get().uri("/api/pois/{id}",5)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void create() {
        Poi poi = new Poi();

        poi.setName("Test10");
        poi.setAddressname("teste");
        poi.setCollisioncenter("teste");
        poi.setZipcode("teste");
        poi.setLongi("1234");
        poi.setLat("1234");
        poi.setCity("teste");
        poi.setChargingstation("teste");
        poi.setDealer("teste");
        poi.setType("teste");
        poi.setDescription("teste");

        Mockito.when(poiService.create(poi)).thenReturn(Mono.just(poi));

        webTestClient.post().uri("/api/pois/create").contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(poi))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(poiService,times(1)).create(poi);
    }

    @Test
    void findByType() {
        webTestClient.get().uri("/api/poi/{type}","teste")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void updatePoi() {
        Poi poi = new Poi();
        poi.setID(10L);
        poi.setName("Test");
        poi.setAddressname("teste");
        poi.setCollisioncenter("teste");
        poi.setZipcode("1234-123");
        poi.setLongi("1234");
        poi.setLat("1234");
        poi.setCity("teste");
        poi.setChargingstation("teste");
        poi.setDealer("teste");
        poi.setType("teste");
        poi.setDescription("teste");

        Mockito.when((poiService.update(poi)).then(Mono.just(poi)));

        webTestClient.put().uri("/api/poi/{id}",10L)
                .exchange()
                .expectStatus().isOk();

        Mockito.verify(poiService,times(1)).update(poi);
    }

    @Test
    void delete() {
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(poiService.delete(4L)).thenReturn(voidReturn);

        webTestClient.delete().uri("/api/pois/{id}",4).exchange().expectStatus().isOk();
    }
}