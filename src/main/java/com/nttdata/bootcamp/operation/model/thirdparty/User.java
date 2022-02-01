package com.nttdata.bootcamp.operation.model.thirdparty;

import lombok.Data;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link User}<br/>
 * <b>Copyright</b>: &Copy; 2022 Everis Per&uacute;. <br/>
 * <b>Company</b>: Everis del Per&uacute;. <br/>
 *
 * @author Everis Per&uacute;. (EVE) <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (EVE)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 05, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@Data
public class User {
  public int id;
  public String name;
  public String username;
  public String email;
//  public Address address;
  public String phone;
  public String website;
//  public Company company;
}
