package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private int ID;
    private String fornavn;
    private String efternavn;
    private String fullname=fornavn+""+efternavn;
    private int alder;
    private String stilling;
    private int telefonnr;


    public Employee(int ID, String fornavn, String efternavn, int alder, String stilling, int telefonnr) {
        this.ID = ID;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.stilling = stilling;
        this.telefonnr = telefonnr;
    }

    Employee(){

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

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(int telefonnr) {
        this.telefonnr = telefonnr;
    }

    public void GemEmpFil(String file) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String employee = String.format("%d %s %s %d %s %d",
                ID, fornavn, efternavn, alder, stilling,telefonnr);
        outputToFile.println(employee);
        outputToFile.flush();
    }

    public static void GemEmp(String file,ArrayList<Employee> employees) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).GemEmpFil(file);
        }
    }
    public static void hentEmp(String file, ArrayList<Employee> employees) throws Exception {
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()) {
            employees.add(new Employee(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt()));
            scanner.nextLine();
        }
        scanner.close();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}