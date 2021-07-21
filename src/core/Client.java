package core;

import java.util.Date;

public class Client extends DatabaseConnection {

    int ID;
    String name;
    String type_nif;
    String NIF;
    String phone;
    String mobile;
    Boolean is_validate;
    Date create_date;
    String id_address;

    public Boolean insertClient(Client client){
        String insert = "INSERT INTO CLIENT (C_NAME, C_TYPE_NIF, C_NIF,C_PHONE, C_MOBILE,C_CREATE_DATE, C_ID_ADDRESS) VALUES (" + client.name +
                "," + client.type_nif +
                "," + client.NIF +
                "," + client.phone +
                "," + client.mobile +
                "," + client.create_date +
                "," + client.id_address +
                ")";

        return true;
    }
    public Boolean updateClient(Client client){
        String update = "UPDATE CLIENT SET " +
                ", C_NAME=" + client.name +
                "C_TYPE_NIF=" + client.type_nif +
                ", C_NIF=" + client.NIF +
                ", C_PHONE=" + client.phone+
                ", C_MOBILE=" + client.mobile +
                ", C_CREATE_DATE=" + client.create_date +
                ", C_ID_ADDRESS=" + client.id_address +
                " WHERE ID = " + client.ID ;
        return true;
    }

    public Boolean deleteClient(int ID){
        String delete = "DELETE CLIENT WHERE ID = " + ID;
        return true;
    }

    public Client[] selectClient(){
    return new Client [] {};
    }
}
