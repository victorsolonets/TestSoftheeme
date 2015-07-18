/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testSoftheme;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class SearchIntDiv {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Input the number - ");
        int numb = input.nextInt();
        search(numb);
    }

   public static void search(int numb) {
       StringBuffer div = new StringBuffer(""+numb+","+"1");
        for (int i = 2; i <= numb / 2; i++) {
            if (numb % i == 0) {
                div.append(","+i);
            }
        }
        System.out.println(div);
    }
}
