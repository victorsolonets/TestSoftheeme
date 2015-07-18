/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    static volatile int x = 3;
    static int i = 0;

    static class Thread1 extends Thread {

        public void run() {
            System.out.println("Thread1 start");
            System.out.println("Thread1 x = " + x);
            i = 0;
            for (int j = 0; j < 3; j++) {
                x *= 3;
                i+=1;
                System.out.println("Thread1 x = " + x + " i = " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Thread1 end");
        }
    }

    static class Thread2 extends Thread {

        public void run() {
            System.out.println("Thread2 start");
            System.out.println("Thread2 x = " + x);
            i = 0;
            for (int j = 0; j < 3; j++) {
                x *= 2;
                i+=1;
                System.out.println("Thread2 x = " + x + " i = " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Thread2 end");
        }
    }

    public static void main(String[] args) {
        int x=7;
        for (int i=0; i<5; i++) { x=x+3 ;};
        System.out.println(x);
    }
}
