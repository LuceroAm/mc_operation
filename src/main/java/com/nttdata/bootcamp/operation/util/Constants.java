package com.nttdata.bootcamp.operation.util;

public class Constants {

    public final static String MAIN_PATH = "/operation";
    public final static String ID = "/{id}";
    public final static String OPEN_ACCOUNT = "/open-account";
    public final static String PRUEBA = "/prueba/{documentNumber}";
    public final static String PRUEBA1 = "/prueba1/{documentNumber}";

    public final static String SAVE_VALUE="Metodo a traves del cual se envia la informacion de la operacion que  sera registrada dentro de la base de datos.";
    public final static String SAVE_NOTE="Para el registro de la operacion , sera necesario el llenado de todo los campos , a excepcion de los Id´s los cuales seran generados automaticamente.";

    public final static String GETDATA_VALUE="Metodo a traves del cual se Obtiene la informacion de todas las operaciones registradas.";
    public final static String GETDATA_NOTE="Para la obtencion de todos los registros  de las operaciones , solo se debe enviar la consulta.";

    public final static String GET_ID_VALUE="Metodo a traves del cual se Obtiene la informacion de las operaciones registradas su Id ";
    public final static String GET_ID_NOTE="Para la obtencion de datos de una  operacion , sera necesario enviar el Id de la operacion a consultar";

    public final static String UPDATE_ID_VALUE="Metodo a traves del cual se Actualiza la informacion de la operacion mediante su Id ";
    public final static String UPDATE_ID_NOTE="Para Actualizar los  datos de la operacion , sera necesario enviar todo el registro con los datos ya actualizados junto a sus Id`s ";

    public final static String DELETE_ID_VALUE="Metodo a traves del cual se Elimina la informacion de la operacion mediante su Id ";
    public final static String DELETE_ID_NOTE="Para eliminar los  datos de una operacion , sera necesario enviar el Id de la operacion ";

}
