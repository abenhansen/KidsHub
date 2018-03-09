package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Kid {
    private int ID;
    private String fornavn;
    private String efternavn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fodselsdag;
    private String indskrivning;
    private String foraelder;
    private String nummer;

    public Kid(int ID, String fornavn, String efternavn, String indskrivning, String foraelder, String nummer, String fodselsdag) {
        this.ID = ID;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.indskrivning = indskrivning;
        this.foraelder = foraelder;
        this.nummer = nummer;
        this.fodselsdag = fodselsdag;
    }

    public Kid() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getFodselsdag() {
        return fodselsdag;
    }

    public void setFodselsdag(String fodselsdag) {
        this.fodselsdag = fodselsdag;
    }

    public String getIndskrivning() {
        return indskrivning;
    }

    public void setIndskrivning(String indskrivning) {
        this.indskrivning = indskrivning;
    }

    public String getForaelder() {
        return foraelder;
    }

    public void setForaelder(String foraelder) {
        this.foraelder = foraelder;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public void GemKidFil(String file) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String kid = String.format("%d %s %s %s %s %s %s",
                ID, fornavn, efternavn, indskrivning,foraelder,nummer,fodselsdag );
        outputToFile.println(kid);
        outputToFile.flush();
    }

    public static void GemKid(String file,ArrayList<Kid> barn) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < barn.size(); i++) {
            barn.get(i).GemKidFil(file);
        }
    }
    public static void hentKids(String file, ArrayList<Kid> barn) throws Exception {
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()) {
            barn.add(new Kid(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(),scanner.next()));
            scanner.nextLine();
        }
        scanner.close();
    }
}

