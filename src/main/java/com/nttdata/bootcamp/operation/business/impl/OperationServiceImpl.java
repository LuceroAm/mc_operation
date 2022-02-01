package com.nttdata.bootcamp.operation.business.impl;

import com.nttdata.bootcamp.operation.business.OperationService;
import com.nttdata.bootcamp.operation.model.Operation;
import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.request.OperationRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
import com.nttdata.bootcamp.operation.model.dto.response.OperationResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.Customer;
import com.nttdata.bootcamp.operation.model.thirdparty.CustomerResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.PruebaResponse;
import com.nttdata.bootcamp.operation.repository.OperationRepository;
import com.nttdata.bootcamp.operation.util.OperationBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * <b>Class</b>: {@link OperationServiceImpl}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>10/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */


@Service
@Slf4j
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private WebClient webClientCustomer;
    @Autowired
    private WebClient webClientProduct;
    @Autowired
    private WebClient webClientUser;

    @Override
    public Mono<OperationResponse> create(OperationRequest operationRequest) {
        log.info("Guardar datos del Cliente");
        return operationRepository.save(OperationBuilder
                        .operationRequestToOperationEntity(operationRequest))
                .map(operation -> OperationBuilder
                        .operationEntityToOperationResponse(operation));
    }

    @Override
    public Mono<OperationResponse> findById(String id) {
        return operationRepository.findById(id)
                .map(operation -> OperationBuilder
                        .operationEntityToOperationResponse(operation));
    }

    @Override
    public Flux<OperationResponse> findAll() {
        log.info("Obtener todos los registros de los Clientes");
        return operationRepository.findAll()
                .map(operation -> OperationBuilder
                        .operationEntityToOperationResponse(operation));
    }

    @Override
    public Mono<OperationResponse> update(OperationRequest operationRequest) {
        log.info("Actualizar un registro de un Cliente");
        return operationRepository.findById(operationRequest.getId())
                .flatMap(operationBD->{
                    return  create(operationRequest);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<OperationResponse> remove(String id) {
        log.info("Eliminar un registro de un Cliente");
        return  operationRepository
                .findById(id)
                .map(operation -> OperationBuilder
                        .operationEntityToOperationResponse(operation))
                .flatMap(operationResponse -> operationRepository.deleteById(operationResponse.getId())
                        .thenReturn(operationResponse));
    }

    @Override
    public Mono<OperationOpenAccountResponse> pruebaOperationOpenAccountResponse(OperationCreateAccountRequest operationRequest){

        return operationRepository.save(OperationBuilder
                .createAccountBuilder(operationRequest))
                .flatMap(this::consumoDefinitivo);
    }


    @Override
    public Mono<OperationOpenAccountResponse> openAccount(OperationCreateAccountRequest operationRequest){
        return operationRepository.save(OperationBuilder
                .createAccountBuilder(operationRequest))
                .map(operation -> OperationBuilder
                            .createAccountResponseBuilder(operation));

    }

    @Override
    public Mono<PruebaResponse> prueba(String documentNumber) {
        return webClientCustomer.get()
                .uri(uriBuilder ->
                        uriBuilder
                            .queryParam("numberDocument", documentNumber)
                            .build())
                .retrieve()
                .bodyToMono(Customer.class)
                .map( customer -> {
                    PruebaResponse prueba1 = new PruebaResponse();
                    prueba1.setNumberDocument(documentNumber);
                    prueba1.setCustomer(customer);
                    return prueba1;
                });

    }

    @Override
    public Mono<Customer> prueba1(String documentNumber) {
        Mono<Customer> customer ;
        customer =  webClientCustomer.get()
                .uri(uriBuilder ->
                        uriBuilder
                            .queryParam("numberDocument", documentNumber)
                            .build())
                .retrieve()
                .bodyToMono(Customer.class);
        log.info("Info   "+customer.toString());
        return customer;
    }

    public Mono<OperationOpenAccountResponse> consumoDefinitivo(Operation model) {

        return webClientCustomer.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam("numberDocument", model.getNumberDocument())
                                .build())
                .retrieve()
                .bodyToMono(Customer.class)
//                .map( customer -> {
//                    OperationOpenAccountResponse response = new OperationOpenAccountResponse();
//                    response.setId(model.getId());
//                    response.setAccountNumber(model.getAccountNumber());
//                    response.setNumberDocument(model.getNumberDocument());
//                    response.setCustomer(customer);
//                    return response;
//                });
                .map( customer ->
                        OperationBuilder.createAccountResponseBuilder2(model,customer));

    }
}
