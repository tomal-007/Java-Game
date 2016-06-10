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
public class ServerReaderWriter implements Runnable{

    public HashMap<String,Information> clientList;
    public ConectionUtillities connection;
    public String user;
    
    public ServerReaderWriter(String username,ConectionUtillities con, HashMap<String,Information> list){
        connection=con;
        clientList=list;
        user=username;
    }
    
    @Override
    public void run() {
        while(true){
            
            Object o=connection.read();
            String data=o.toString();
            
            String msg[]=data.split(":",2);
            
            String username=msg[0];
            String msgInfo=msg[1];
            
            if(clientList.containsKey(username)){
                Information info=clientList.get(username);
                info.connection.write(msgInfo);
            }
            else{
               connection.write(username+" not found ");
            }
            
        }
    }
    
    
}

