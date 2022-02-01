package com.nttdata.bootcamp.web.expose;


import com.nttdata.bootcamp.operation.business.OperationService;
import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.request.OperationRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
import com.nttdata.bootcamp.operation.model.dto.response.OperationResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.Customer;
import com.nttdata.bootcamp.operation.model.thirdparty.PruebaResponse;
import com.nttdata.bootcamp.operation.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservice Customer", description = "Esta API se encarga de la gestion de los Clientes")
@Slf4j
public class OperationController {


    @Autowired
    private OperationService operationService;

//    crear cuenta
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<OperationResponse> create(@RequestBody OperationRequest request)
    {
        log.info("Metoth Create Operations");
        return operationService.create(request);
    }

    @GetMapping
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public Flux<OperationResponse> findAll() {
        log.info("Metoth findAll ");
        return operationService.findAll();
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public Mono<OperationResponse> findById(@PathVariable("id") String id) {
        log.info("Metoth findById ");
        return operationService.findById(id);
    }

    @PutMapping(Constants.ID)
    @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
    public Mono<ResponseEntity<OperationResponse>> Update(@RequestBody OperationRequest request) {
        log.info("Metoth update ");
        return operationService.update(request)
                .flatMap(operationResponse -> Mono.just(ResponseEntity.ok(operationResponse)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @DeleteMapping(Constants.ID)
    @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
    public Mono<ResponseEntity<OperationResponse>> deletebyId(@PathVariable("id") String id) {
        log.info("Metoth deletebyId ");
        return operationService.remove(id)
                .flatMap(operationResponse -> Mono.just(ResponseEntity.ok(operationResponse)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }



    //    crear cuenta
    @PostMapping(Constants.OPEN_ACCOUNT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<OperationOpenAccountResponse> openAccount(@RequestBody OperationCreateAccountRequest request)
    {
        log.info("Metoth Create Operations");
//        return operationService.openAccount(request);
        return operationService.pruebaOperationOpenAccountResponse(request);
    }

    @GetMapping(Constants.PRUEBA)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<PruebaResponse> prueba(@PathVariable("documentNumber") String documentNumber) {
        log.info("Metoth Create Operations");
//        String document = String.valueOf(request);
        return operationService.prueba(documentNumber);
    }
    @GetMapping(Constants.PRUEBA1)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<Customer> prueba1(@PathVariable("documentNumber") String documentNumber){
        log.info("Metoth Create Operations");
//        String document = String.valueOf(request);
        return operationService.prueba1(documentNumber);
    }

}
