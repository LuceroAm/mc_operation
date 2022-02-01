package com.nttdata.bootcamp.operation.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>Class</b>: {@link OperationCreateAccountRequest}<br/>
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
@Document(collection = "operation")
@Builder
public class OperationCreateAccountRequest {

    private String id;
    private String numberDocument;
    private String accountNumber;
    private String cardNumber;
    private String password;
    private String amount;

    public String getDate(){
        Date fecha = new Date();
        String Fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(fecha);
        String fe = Fecha.toString();
        return fe;
    }

}
