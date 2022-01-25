package com.nttdata.bootcamp.operation.util;

import com.nttdata.bootcamp.operation.model.Operation;
import com.nttdata.bootcamp.operation.model.dto.request.OperationRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationResponse;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class OperationBuilder {
    public final static Operation operationRequestToOperationEntity (OperationRequest request){
        return Operation.builder()
                .id(request.getId())
                .cardNnumber(request.getCardNnumber())
                .accountNumber(request.getAccountNumber())
                .numberDocument(request.getNumberDocument())
                .password(request.getPassword())
                .typeOperation(request.getTypeOperation())
                .additionalAmount(request.getAdditionalAmount())
                .build();


    }

    public static OperationResponse operationEntityToOperationResponse(Operation model){
        return OperationResponse.builder()
                .accountNumber(model.getAccountNumber())
                .typeOperation(model.getTypeOperation())
                .additionalAmount(model.getAdditionalAmount())
                .totalAmount(model.getTotalAmount())
                .date(model.getDate())
                .build();
    }

}
