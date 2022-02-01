package com.nttdata.bootcamp.operation.model.thirdparty.customer;

import com.nttdata.bootcamp.operation.model.thirdparty.EntityName;
import com.nttdata.bootcamp.operation.model.thirdparty.TypeCustomer;
import com.nttdata.bootcamp.operation.model.thirdparty.TypeDocument;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <b>Class</b>: {@link CustomerRequest}<br/>
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
@Document(collection = "customer")
@Builder
public class CustomerRequest {
//    @ApiModelProperty(value = "id", position = 1)
//    private String id = UUID.randomUUID().toString();

    @ApiModelProperty(value = "typeCustomer", position = 2)
    private TypeCustomer typeCustomer;

    @ApiModelProperty(value = "entityName", position = 3)
    private EntityName entityName;

    @ApiModelProperty(value = "typeDocument", position = 4)
    private TypeDocument typeDocument;

    @ApiModelProperty(value = "numberDocument", position = 5)
    private String numberDocument;

    @ApiModelProperty(value = "telephone", position = 6)
    private String telephone;

    @ApiModelProperty(value = "address", position = 7)
    private String address;

    @ApiModelProperty(value = "email", position = 8)
    private String email;
}
