package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Zak {

    private String jmeno, prijmeni, rodne_cislo;
    private LocalDate datum_narozeni;
    private boolean chlapec;
    private byte rocnik;

    public Zak() {
    }

    public Zak(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rodne_cislo = rodne_cislo;
        this.datum_narozeni = datum_narozeni;
        this.chlapec = chlapec;
    }

    public Zak(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec, byte rocnik) {
        this(jmeno, prijmeni, rodne_cislo, datum_narozeni, chlapec);
        this.rocnik = rocnik;
    }

    public String vratInfo() {
        String txt = "";
        String date = datum_narozeni.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        String rok = rocnik != 0 ? "," + rocnik + ". ročník" : "";
        txt += String.format("%s %s (%s) %s", jmeno, prijmeni,date,rok);
        return txt;

    }
    public void zmenPrijmeni(String nove_prijmeni){
        prijmeni = nove_prijmeni;
    }
    public void zvysRocnik(){
        rocnik++;
    }
    public String pohlavi(){
        return chlapec?"chlapec":"divka";
    }
    public boolean plnoletost(){
        return LocalDate.now().isAfter(datum_narozeni.plusYears(18));
    }

    @Override
    public String toString() {
        return "Zak{" +
                "jmeno='" + jmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                ", rodne_cislo='" + rodne_cislo + '\'' +
                ", datum_narozeni=" + datum_narozeni +
                ", chlapec=" + chlapec +
                ", rocnik=" + rocnik +
                '}';
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

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public boolean isChlapec() {
        return chlapec;
    }

    public void setChlapec(boolean chlapec) {
        this.chlapec = chlapec;
    }

    public byte getRocnik() {
        return rocnik;
    }

    public void setRocnik(byte rocnik) {
        this.rocnik = rocnik;
    }

    public String getRodne_cislo() {
        return rodne_cislo;
    }

    public LocalDate getDatum_narozeni() {
        return datum_narozeni;
    }
}
