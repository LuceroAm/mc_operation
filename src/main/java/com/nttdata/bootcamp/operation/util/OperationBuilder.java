package com.nttdata.bootcamp.operation.util;

import com.nttdata.bootcamp.operation.model.Operation;
import com.nttdata.bootcamp.operation.model.dto.request.OperationCreateAccountRequest;
import com.nttdata.bootcamp.operation.model.dto.request.OperationRequest;
import com.nttdata.bootcamp.operation.model.dto.response.OperationOpenAccountResponse;
import com.nttdata.bootcamp.operation.model.dto.response.OperationResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.Customer;
import com.nttdata.bootcamp.operation.model.thirdparty.CustomerResponse;

public class OperationBuilder {
    public final static Operation operationRequestToOperationEntity (OperationRequest request){
        return Operation.builder()
                .id(request.getId())
                .cardNumber(request.getCardNumber())
                .accountNumber(request.getAccountNumber())
                .numberDocument(request.getNumberDocument())
                .password(request.getPassword())
//                .typeOperation(request.getTypeOperation())
                .additionalAmount(request.getAdditionalAmount())
                .build();


    }

    public static OperationResponse operationEntityToOperationResponse(Operation model){
        return OperationResponse.builder()
                .id(model.getId())

                .accountNumber(model.getAccountNumber())
                .numberDocument(model.getNumberDocument())
                .additionalAmount(model.getAdditionalAmount())
                .totalAmount(model.getTotalAmount())
                .date(model.getDate())
                .build();
    }

    public static OperationOpenAccountResponse createAccountResponseBuilder(Operation model){
        return OperationOpenAccountResponse.builder()
                .id(model.getId())
                .numberDocument(model.getNumberDocument())
                .accountNumber(model.getAccountNumber())
                .cardNumber(model.getCardNumber())
                .amount(model.getAmount())
                .date(model.getDate())
                .build();
    }

    public static OperationOpenAccountResponse createAccountResponseBuilder2(Operation model,OperationOpenAccountResponse response){
        return response.builder()
                .id(model.getId())
                .numberDocument(model.getNumberDocument())
                .accountNumber(model.getAccountNumber())
                .cardNumber(model.getCardNumber())
                .amount(model.getAmount())
                .date(model.getDate())
                .build();
    }

    public static OperationOpenAccountResponse createAccountResponseBuilder2(Operation model,CustomerResponse customerResponse){
        return OperationOpenAccountResponse.builder()
                .id(model.getId())
//                .customer(customerResponse)
                .numberDocument(model.getNumberDocument())
                .accountNumber(model.getAccountNumber())
                .cardNumber(model.getCardNumber())
                .amount(model.getAmount())
                .date(model.getDate())
                .build();
    }

    public static Operation createAccountBuilder(OperationCreateAccountRequest operationRequest) {
        return Operation.builder()
//                .id(request.getId())
                .cardNumber(operationRequest.getCardNumber())
                .accountNumber(operationRequest.getAccountNumber())
                .numberDocument(operationRequest.getNumberDocument())
                .password(operationRequest.getPassword())
                .amount(operationRequest.getAmount())
                .date(operationRequest.getDate())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer model){
        return CustomerResponse.builder()
                .address(model.getAddress())
                .typeDocument(model.getTypeDocument())
                .entityName(model.getEntityName())
                .numberDocument(model.getNumberDocument())
                .typeCustomer(model.getTypeCustomer())
                .build();
    }
}
