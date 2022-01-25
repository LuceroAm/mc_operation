package com.nttdata.bootcamp.operation.model.thirdparty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * <b>Class</b>: {@link ProductResponse}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>06/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id = UUID.randomUUID().toString();
    private ProductType productType;
    private AccountType accountType;
    private CreditType creditType;
    private String accountNumber;
    private TypeDocument typeDocument;
    private String numberDocument;
    private String cardNumber;
    private String password;
    private String amount;
}
