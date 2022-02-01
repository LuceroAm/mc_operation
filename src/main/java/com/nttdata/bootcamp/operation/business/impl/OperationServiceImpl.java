package com.nttdata.bootcamp.operation.business.impl;

import com.nttdata.bootcamp.operation.business.OperationService;
import com.nttdata.bootcamp.operation.model.Operation;
import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.CustomerResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.ProductResponse;
import com.nttdata.bootcamp.operation.repository.OperationRepository;
import com.nttdata.bootcamp.operation.util.OperationBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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

    @Override
    public Mono<OperationOpenAccountResponse> operationOpenAccountResponse(OperationCreateAccountRequest operationRequest){
        return operationRepository.save(OperationBuilder
                .createAccountBuilder(operationRequest))
                .flatMap(this::getCustomer);
    }

    @Override
    public Mono<OperationOpenAccountResponse> findById(String id) {
        return operationRepository.findById(id)
                .flatMap(this::getCustomer);
    }

    @Override
    public Flux<OperationOpenAccountResponse> findAll() {
        log.info("Obtener todos los registros de los Clientes");
        return operationRepository.findAll()
                .flatMap(this::getCustomer);
    }

    @Override
    public Mono<OperationOpenAccountResponse> update(OperationCreateAccountRequest operationRequest) {
        log.info("Actualizar un registro de un Cliente");
        return operationRepository.findById(operationRequest.getId())
                .flatMap(operationBD->{
                    return  operationOpenAccountResponse(operationRequest);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<OperationOpenAccountResponse> remove(String id) {
        log.info("Eliminar un registro de un Cliente");
        return  operationRepository
                .findById(id)
                .flatMap(this::getCustomer)
                .flatMap(operationResponse -> operationRepository.deleteById(operationResponse.getId())
                        .thenReturn(operationResponse));
    }


    public Mono<OperationOpenAccountResponse> getCustomer(Operation model) {

        return webClientCustomer.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam("numberDocument", model.getNumberDocument())
                                .build())
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .flatMap( customerResponse ->
                        getProduct(model,customerResponse));

    }

    public Mono<OperationOpenAccountResponse> getProduct(Operation model,CustomerResponse customerResponse) {

        return webClientProduct.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam("accountNumber", model.getAccountNumber())
                                .build())
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .map( productResponse ->
                        OperationBuilder.createAccountResponseBuilder3(model,customerResponse,productResponse));

    }
}
