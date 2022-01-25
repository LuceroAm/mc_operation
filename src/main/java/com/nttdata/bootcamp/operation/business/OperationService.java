package com.nttdata.bootcamp.operation.business;

import com.nttdata.bootcamp.operation.model.dto.request.OperationRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: {@link OperationService}<br/>
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


public interface OperationService {
    Mono<OperationResponse> create(OperationRequest operationRequest);

    Mono<OperationResponse> findById(String id);

    Flux<OperationResponse> findAll();

    Mono<OperationResponse> update(OperationRequest operationRequest);

    Mono<OperationResponse> remove(String id);
}
