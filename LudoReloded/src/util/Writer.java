/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


public class Writer implements Runnable{
    public ConnectionUtilities connection;

    public Writer(ConnectionUtilities con){
        connection=con;
    }

    @Override
    public void run() {

        while(true){
            Object o=connection.read();
            System.out.println(o.toString());
        }

    }


}
