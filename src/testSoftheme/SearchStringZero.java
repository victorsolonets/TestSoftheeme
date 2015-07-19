/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testSoftheme;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Victor
 */
public class SearchStringZero {

    private static FileInputStream fin = null;
    private static FileOutputStream fout = null;
    private static BufferedInputStream bin = null;
    private static BufferedOutputStream bout = null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;
    private static final String FILE_INPUT = "INPUT.TXT";
    private static final String FILE_OUTPUT = "OUTPUT.TXT";

    public static void main(String[] args) throws IOException {
        String input = null;
        int lenghtOfZero = 0;
        writeInFileZero();
        input = readFromFile(FILE_INPUT);
        lenghtOfZero = searchZeroWithStr(input);
        writeInFile(lenghtOfZero);
        System.out.println(lenghtOfZero);
    }

    public static String readFromFile(String filePath) throws FileNotFoundException, IOException {
        fin = new FileInputStream(filePath);
        bin = new BufferedInputStream(fin);
        din = new DataInputStream(bin);
        String input = "";
        int temp = din.read();
        int i = 0;
        while (temp != -1) {
            input += temp;
            temp = din.read();
            i++;
        }
        din.close();
        System.out.println(input);
        return input;
    }

    public static void writeInFileZero() throws IOException {
        fout = new FileOutputStream(FILE_INPUT);
        bout = new BufferedOutputStream(fout);
        dout = new DataOutputStream(bout);
        Random rand = new Random();
        int bit = rand.nextInt(2);
        for (int i = 0; i < 20; i++) {
            bit = rand.nextInt(2);
            dout.write(bit);
        }
        dout.close();
    }

    public static void writeInFile(int numb) throws IOException {
        fout = new FileOutputStream(FILE_OUTPUT);
        bout = new BufferedOutputStream(fout);
        dout = new DataOutputStream(bout);
        dout.writeChar((char) numb);
        bout.close();
    }

    private static int searchZeroWithStr(String input) {

        String pattern = "[0]+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        int result = 0;
        String buff = "";
        if (m.find()) {
            buff = m.group();
            if (buff.length() > result) {
                result = buff.length();
                input.replaceFirst("", "0");
                System.out.println(input);
            }
        }
        return result;
    }

    private static int searchZero(String input) {
        int result = 0;
        int buf = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 0) {
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
