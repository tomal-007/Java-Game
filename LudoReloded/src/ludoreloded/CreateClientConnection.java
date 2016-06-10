/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoreloded;
import java.util.HashMap;
import util.ConectionUtillities;

/**
 *
 * @author uesr
 */
public class CreateClientConnection implements Runnable{
    public HashMap<String,Information> clientList;
    public ConectionUtillities connection;

    public CreateClientConnection(HashMap<String,Information> list, ConectionUtillities con){
        clientList=list;
        connection=con;
    }
    
    @Override
    public void run() {
        Object o=connection.read();
        String username=o.toString();        
        clientList.put(username, new Information(connection, username));
        new Thread(new ServerReaderWriter(username,connection, clientList)).start();
        
    }
    
    
    
}

