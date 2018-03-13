package com.example.demo;

public class Vagtplan {
    private String Dag;
    private String ansat;
    private int VagtID;

    public Vagtplan(String dag, String ansat, int vagtID) {
        Dag = dag;
        this.ansat = ansat;
        VagtID = vagtID;
    }
    public Vagtplan() {

    }
    @Override
    public String toString() {
        return "Vagtplan{" +
                "Dag='" + Dag + '\'' +
                ", ansat='" + ansat + '\'' +
                ", VagtID=" + VagtID +
                '}';
    }

    public String getDag() {
        return Dag;
    }

    public void setDag(String dag) {
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


}