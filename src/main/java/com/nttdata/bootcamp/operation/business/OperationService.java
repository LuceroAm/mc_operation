package com.nttdata.bootcamp.operation.business;

import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
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

    Mono<OperationOpenAccountResponse> operationOpenAccountResponse(OperationCreateAccountRequest operationRequest);
    Mono<OperationOpenAccountResponse> findById(String id);
    Flux<OperationOpenAccountResponse> findAll();
    Mono<OperationOpenAccountResponse> update(OperationCreateAccountRequest operationRequest);
    Mono<OperationOpenAccountResponse> remove(String id);

}
