package com.everis.client.controller;

import com.everis.client.dao.entity.ClientPersonal;
import com.everis.client.service.personal.ClientPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientPersonalController {

    @Autowired
    ClientPersonalService<ClientPersonal> clientPersonalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClientPersonal> createClient(@RequestBody ClientPersonal clientPersonal){
        return clientPersonalService.createClient(clientPersonal);
    }

    @GetMapping
    public Flux<ClientPersonal> getClients(){
        return clientPersonalService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<ClientPersonal> updateClient(@PathVariable("id") UUID id, @RequestBody ClientPersonal clientPersonal){
        return clientPersonalService.updateClient(id, clientPersonal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ClientPersonal> deleteClientById(@PathVariable("id") UUID id){
        return clientPersonalService.deleteClient(id);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity> findById(@PathVariable("id") UUID id){
        return clientPersonalService.findById(id)
                .map(ResponseEntity::ok);
    }
}
