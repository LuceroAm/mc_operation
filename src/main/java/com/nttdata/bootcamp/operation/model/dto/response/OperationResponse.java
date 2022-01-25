package com.nttdata.bootcamp.operation.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;


/**
 * <b>Class</b>: {@link OperationResponse}<br/>
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
public class OperationResponse {

      @Id
    private String id = UUID.randomUUID().toString();
    private String accountNumber;
    private String typeOperation;
    private String additionalAmount;
    private String totalAmount;
    private String date;
}
