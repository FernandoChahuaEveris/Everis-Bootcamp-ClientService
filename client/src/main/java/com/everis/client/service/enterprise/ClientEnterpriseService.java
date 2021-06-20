package com.everis.client.service.enterprise;

import com.everis.client.dao.entity.ClientEnterprise;
import com.everis.client.dao.entity.ClientPersonal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClientEnterpriseService<T extends ClientEnterprise> {

    public Mono<T> createClient(ClientEnterprise clientPersonal);

    public Flux<T> findAll();

    public Mono<T> updateClient(UUID id, ClientEnterprise clientPersonal);

    public Mono<T> findById(UUID id);

    public Mono<T> deleteClient(UUID id);
}
