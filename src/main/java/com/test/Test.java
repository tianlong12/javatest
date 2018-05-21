package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class Test {


static public class Thread1 extends Thread{



    public void run() {
        File file =new File("/Users/adewin/Desktop/lsl");
        StringBuilder result =new StringBuilder();
        try {
            BufferedReader br =new BufferedReader(new FileReader(file));
            String s =null;
            while((s =br.readLine()) != null) { //一次读一行内容
                result.append(System.lineSeparator() +s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( result);
    }




}



    static public class Thread2 extends Thread{



        public void run() {
            File file =new File("/Users/adewin/Desktop/lsl");
            StringBuilder result =new StringBuilder();
            try {
                BufferedReader br =new BufferedReader(new FileReader(file));
                String s =null;
                while((s =br.readLine()) != null) { //一次读一行内容
                    result.append(System.lineSeparator() +s);
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println( result);
        }




    }



    public static void main(String[] args) {


new Thread1().start();
        new Thread2().start();



    }






}
