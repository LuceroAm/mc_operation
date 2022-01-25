package com.nttdata.bootcamp.operation.model.thirdparty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * <b>Class</b>: {@link CustomerResponse}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>07/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private String id = UUID.randomUUID().toString();
    private TypeCustomer typeCustomer;
    private EntityName entityName;
    private TypeDocument typeDocument;
    private String numberDocument;
    private String telephone;
    private String address;
    private String email;

}
