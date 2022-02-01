package com.nttdata.bootcamp.operation.model.thirdparty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * <b>Class</b>: {@link PruebaResponse}<br/>
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
public class PruebaResponse {

    private String numberDocument;
    private Customer customer;

}
