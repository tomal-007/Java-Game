/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionUtilities {
    public Socket sc;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;

    public ConnectionUtilities(String host, int port){
        try {
            sc=new Socket(host,port);
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public ConnectionUtilities(Socket socket){
        try {
            sc=socket;
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void write(Object o){
        try {
            oos.writeObject(o);
        } catch (IOException ex) {
            System.out.println("Trouble writing object");
        }
    }

    public Object read(){
        try {
            Object o=ois.readObject();
            return o;
        } catch (Exception ex) {
            System.out.println("Trouble reading object");
        }
        return null;
    }
}
