/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testSoftheme;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class SearchZero {

    private static FileInputStream fin = null;
    private static FileOutputStream fout = null;
    private static BufferedInputStream bin = null;
    private static BufferedOutputStream bout = null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;
    private static final String FILE_INPUT = "INPUT.TXT";
    private static final String FILE_OUTPUT = "OUTPUT.TXT";

    public static void main(String[] args) throws IOException {
        ArrayList input = null;
        int lenghtOfZero = 0;
        writeInFileZero();
        input = readFromFile(FILE_INPUT);
        lenghtOfZero = searchZero(input);
        writeInFile(lenghtOfZero);
        System.out.println(lenghtOfZero);
//        System.out.println(input.toString());
    }

    public static ArrayList readFromFile(String filePath) throws FileNotFoundException, IOException {
        fin = new FileInputStream(filePath);
        bin = new BufferedInputStream(fin);
        din = new DataInputStream(bin);
        ArrayList input = new ArrayList();
        int temp = din.read();
        int i = 0;
        while (temp != -1) {
            input.add(temp);
            temp = din.read();
            i++;
        }
        din.close();
        return input;
    }

    public static void writeInFileZero() throws IOException {
        fout = new FileOutputStream(FILE_INPUT);
        bout = new BufferedOutputStream(fout);
        dout = new DataOutputStream(bout);
        Random rand = new Random();
        int bit = rand.nextInt(2);
        for (int i = 0; i < 100; i++) {
            bit = rand.nextInt(2);
            dout.write(bit);
        }
        bout.close();
    }
    
    public static void writeInFile(int numb) throws IOException {
        fout = new FileOutputStream(FILE_OUTPUT);
        bout = new BufferedOutputStream(fout);
        dout = new DataOutputStream(bout);
        
        dout.writeChar((char)numb);
        bout.close();
    }

    private static int searchZero(ArrayList input) {
        int result = 0;
        int buf = 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0) {
                buf++;
            } else {
                if (buf > result) {
                    result = buf;
                }
                buf = 0;
            }
        }
        return result;
    }
}
