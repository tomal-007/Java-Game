/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoreloded;
import util.ConectionUtillities;

public class Information {
    public ConectionUtillities connection;
    public String username;
    
    public Information(ConectionUtillities con,String User){
        username=User;
        connection=con;
    }
}
