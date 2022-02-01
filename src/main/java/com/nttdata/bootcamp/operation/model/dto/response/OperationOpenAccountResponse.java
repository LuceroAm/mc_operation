package com.nttdata.bootcamp.operation.model.dto.response;

import com.nttdata.bootcamp.operation.model.thirdparty.CustomerResponse;
import com.nttdata.bootcamp.operation.model.thirdparty.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;


/**
 * <b>Class</b>: {@link OperationOpenAccountResponse}<br/>
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationOpenAccountResponse {

      @Id
    private String id = UUID.randomUUID().toString();
    private String numberDocument;
    private CustomerResponse customer;
    private String accountNumber;
    private ProductResponse associatedProduct;
    private String cardNumber;
    private String amount;
    private String date;

}
