package com.company.Osoby;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Zak extends Osoba {

    private boolean chlapec;
    private byte rocnik;

    public Zak(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec) {
        super(jmeno, prijmeni, rodne_cislo, datum_narozeni);
        this.chlapec = chlapec;
    }

    public Zak(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec, byte rocnik) {
        this(jmeno, prijmeni, rodne_cislo, datum_narozeni, chlapec);
        this.rocnik = rocnik;
    }

    @Override
    public String vratInfo() {
        String txt = "";
        String date = datum_narozeni.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        String rok = rocnik != 0 ? "," + rocnik + ". ročník" : "";
        txt += String.format("%s %s (%s) %s", jmeno, prijmeni,date,rok);
        return txt;
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

    public boolean isChlapec() {
        return chlapec;
    }

    public byte getRocnik() {
        return rocnik;
    }

    public void setRocnik(byte rocnik) {
        this.rocnik = rocnik;
    }


}
