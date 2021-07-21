package core;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Client extends DatabaseConnection {

    int ID;
    public String name;
    public String type_nif;
    public String NIF;
    public String phone;
    public String mobile;
    public Boolean is_validate;
    public Date create_date;
    public String id_address;
    
    // Constructor 0
    public Client(){
        
    }
    //Constructor 1
    public Client(String name,String type_nif,String NIF,String phone,String mobile,Date create_date){
    this.name = name;
    this.type_nif = type_nif;
    this.NIF = NIF;
    this.phone = phone;
    this.mobile = mobile;
    this.create_date = create_date;
}
    
    
    public Boolean insertClient(Client client){
        String insert = "INSERT INTO CLIENTS (C_NAME, C_TYPE_NIF, C_NIF,C_PHONE, C_MOBILE,C_CREATE_DATE) VALUES ('" + client.name +
                "','" + client.type_nif +
                "','" + client.NIF +
                "','" + client.phone +
                "','" + client.mobile +
                "','" + client.create_date +
                "')";

        try {      
                //GET COONECTION : PREPARED STMT : Execute SQL
                DatabaseConnection.statement().execute(insert);
                System.out.println("insert correcto");
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
    }

    public Boolean updateClient(Client client){
        String update = "UPDATE CLIENTS SET " +
                ", C_NAME='" + client.name +
                ", C_TYPE_NIF='" + client.type_nif +
                ", C_NIF='" + client.NIF +
                ", C_PHONE='" + client.phone+
                ", C_MOBILE='" + client.mobile +
                ", C_CREATE_DATE='" + client.create_date +
                ", C_ID_ADDRESS='" + client.id_address +
                " WHERE ID = '" + client.ID ;
        return true;
    }

    public Boolean deleteClient(int ID){
        String delete = "DELETE CLIENTS WHERE ID = " + ID;
        return true;
    }

    public ArrayList selectClient(){
        ArrayList <Client> clients = null;
        
        String select = "SELECT * FROM CLIENTS";
        
        try {
            ResultSet rs = DatabaseConnection.statement().executeQuery(select);

            while (rs.next()) {

                Client x = new Client();
                x.ID = Integer.parseInt(rs.getString(1));
                x.name = rs.getString(2);
                x.phone = rs.getString(3);
                x.mobile = rs.getString(4);
                clients.add(x);
            }
            System.out.println("Select Exictoso y retorno de ArrayList<Client>");
           return clients; 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
