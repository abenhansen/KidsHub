package com.example.demo;

public class Vagtplan {
    private int Dag;
    private String ansat;
    private int VagtID;


    public Vagtplan() {

    }

    public Vagtplan(int dag, String ansat, int vagtID) {
        Dag = dag;
        this.ansat = ansat;
        VagtID = vagtID;
    }

    public int getDag() {
        return Dag;
    }

    public void setDag(int dag) {
        Dag = dag;
    }

    public String getAnsat() {
        return ansat;
    }

    public void setAnsat(String ansat) {
        this.ansat = ansat;
    }

    public int getVagtID() {
        return VagtID;
    }

    public void setVagtID(int vagtID) {
        VagtID = vagtID;
    }

    @Override
    public String toString() {
        return "Vagtplan{" +
                "Dag=" + Dag +
                ", ansat='" + ansat + '\'' +
                ", VagtID=" + VagtID +
                '}';
    }
}