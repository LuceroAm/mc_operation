package com.nttdata.bootcamp.operation.util;

import com.nttdata.bootcamp.operation.model.Operation;
import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.CustomerResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.ProductResponse;

public class OperationBuilder {

    public static OperationOpenAccountResponse createAccountResponseBuilder3(Operation model,CustomerResponse customerResponse , ProductResponse productResponse){
        return OperationOpenAccountResponse.builder()
                .id(model.getId())
                .numberDocument(model.getNumberDocument())
                .customer(customerResponse)
                .accountNumber(model.getAccountNumber())
                .associatedProduct(productResponse)
                .cardNumber(model.getCardNumber())
                .amount(model.getAmount())
                .date(model.getDate())
                .build();
    }

    public static Operation createAccountBuilder(OperationCreateAccountRequest operationRequest) {
        return Operation.builder()
                .cardNumber(operationRequest.getCardNumber())
                .accountNumber(operationRequest.getAccountNumber())
                .numberDocument(operationRequest.getNumberDocument())
                .password(operationRequest.getPassword())
                .amount(operationRequest.getAmount())
                .date(operationRequest.getDate())
                .build();
    }

}
