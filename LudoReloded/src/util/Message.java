package util;

import java.io.Serializable;

/**
 * Created by ASUS on 5/26/2016.
 */
public class Message implements Serializable {
    public int instruction;
    public String receiver;
    public String username;
    public String password;
    public String text;
    public boolean isSuccessful;
    public Message(int instruction,String username,String password ){
        this.instruction=instruction;
        this.username=username;
        this.password=password;
    }
    public Message(int instruction,String username,String receiver,String text){
        this.instruction=instruction;
        this.username=username;
        this.receiver=receiver;
        this.text=text;
    }
    public Message(int instruction,boolean isSuccessful){
        this.instruction=instruction;
        this.isSuccessful=isSuccessful;
    }
}
/*
1 for client requesting for sign up
2 for client requesting for log in
3 for normal string message
4 server returning login status

 */