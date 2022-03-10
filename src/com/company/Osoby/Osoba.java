package com.company.Osoby;

import java.time.LocalDate;

public abstract class Osoba {
    protected String jmeno, prijmeni, rodne_cislo;
    protected LocalDate datum_narozeni;

    public Osoba(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rodne_cislo = rodne_cislo;
        this.datum_narozeni = datum_narozeni;
    }
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String nove_prijmeni){
        prijmeni = nove_prijmeni;
    }

    public String getRodne_cislo() {
        return rodne_cislo;
    }

    public LocalDate getDatum_narozeni() {
        return datum_narozeni;
    }

    public abstract String vratInfo();

}
