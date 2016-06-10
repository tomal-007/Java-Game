/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;


public class Reader implements Runnable{
    public ConnectionUtilities connection;

    public Reader(ConnectionUtilities con){
        connection=con;
    }

    @Override
    public void run() {

        Scanner in=new Scanner(System.in);

        while(true){

            String text=in.nextLine();

            connection.write(text);

        }

    }

}
