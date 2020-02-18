package com.sub;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.io.FileInputStream;


public class Test {

    public static final File FILE = new File( "person.xml" );
    public static void main(String[] args) {
            saveToXML();

            readXML();


        }

    private static void readXML() {
        try {
            FileInputStream fileInputStream = new FileInputStream( FILE );
            XMLDecoder decoder = new XMLDecoder(fileInputStream);

            Person p2 = (Person) decoder.readObject();
            decoder.close();
            fileInputStream.close();

            System.out.println(p2.getFirstName() + "\n");
            System.out.println(p2.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void saveToXML() {
        Person p1 = new Person( "Seba", "UBH", 39, 1.83, false );
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE);
            XMLEncoder encoder = new XMLEncoder(fileOutputStream);
            encoder.writeObject( p1 );
            encoder.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
