package com.example.demo;

public class Vagtplan {
    String Mandag;
    String Tirsdag;
    String Onsdag;
    String Torsdag;
    String Fredag;
    Employee Ansat;

    public Vagtplan(String mandag, String tirsdag, String onsdag, String torsdag, String fredag, Employee ansat) {
        Mandag = mandag;
        Tirsdag = tirsdag;
        Onsdag = onsdag;
        Torsdag = torsdag;
        Fredag = fredag;
        Ansat = ansat;
    }

    public Vagtplan(){

    }

    public String getMandag() {
        return Mandag;
    }

    public void setMandag(String mandag) {
        Mandag = mandag;
    }

    public String getTirsdag() {
        return Tirsdag;
    }

    public void setTirsdag(String tirsdag) {
        Tirsdag = tirsdag;
    }

    public String getOnsdag() {
        return Onsdag;
    }

    public void setOnsdag(String onsdag) {
        Onsdag = onsdag;
    }

    public String getTorsdag() {
        return Torsdag;
    }

    public void setTorsdag(String torsdag) {
        Torsdag = torsdag;
    }

    public String getFredag() {
        return Fredag;
    }

    public void setFredag(String fredag) {
        Fredag = fredag;
    }

    public Employee getAnsat() {
        return Ansat;
    }

    public void setAnsat(Employee ansat) {
        Ansat = ansat;
    }
}
