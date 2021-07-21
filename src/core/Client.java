package core;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
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

        try {      
                //GET COONECTION // PREPARED STMT
                DatabaseConnection.statement().execute(insert);

                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
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

    public ArrayList selectClient(){
            //ADD COLUMNS TO TABLE MODEL
        ArrayList <Client> clients = null;
        
        //SQL STATEMENT
        String select = "SELECT * FROM CLIENT";
        
        try {
            ResultSet rs = DatabaseConnection.statement().executeQuery(select);
            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                Client x = new Client();
                x.ID = Integer.parseInt(rs.getString(1));
                x.name = rs.getString(2);
                x.phone = rs.getString(3);
                x.mobile = rs.getString(4);
                clients.add(x);
            }
            
           return clients; 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
