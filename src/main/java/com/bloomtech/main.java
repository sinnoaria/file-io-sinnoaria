package com.bloomtech;

import java.io.*;
import java.util.Scanner;

public class main {
    private static final int BUFFER_SIZE = 256;

    public static void main(String[] args) {
        File inFile;
        File outFile;
        FileInputStream inStream;
        FileOutputStream outStream;
        Scanner inScan = new Scanner(System.in);
        String inFileName;
        String outFileName;
        String workingdirectory = "";
        int bytesRead;
        int bytesCopied = 0;
        byte[] buffer = new byte[BUFFER_SIZE];

        System.out.println("Enter the name of the file to copy:");
        inFileName = inScan.nextLine();
        System.out.println("Enter the name of the file to copy to:");
        outFileName = inScan.nextLine();

        inFile = new File(inFileName);
        outFile = new File(outFileName);


        try {
            inStream = new FileInputStream(inFile);
            outStream = new FileOutputStream(outFile);
            while((bytesRead = inStream.read(buffer)) > 0) {
                outStream.write(buffer,0, bytesRead);
                bytesCopied += bytesRead;
            }
            inStream.close();
            outStream.close();

            System.out.println("Copied: " + bytesCopied + " bytes from " + inFileName + " to " + outFileName);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }


    }
}
