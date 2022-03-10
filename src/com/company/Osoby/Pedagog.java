package com.company.Osoby;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedagog extends Osoba {
    String titul;
    ArrayList<String> aprobace;

    public Pedagog(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, String titul) {
        super(jmeno, prijmeni, rodne_cislo, datum_narozeni);
        aprobace = new ArrayList<>();
        this.titul = titul;
    }

    public String vratJmeno() {
        return String.format("%s %s %s (%s)", titul, jmeno, prijmeni);
    }

    @Override
    public String vratInfo() {
        return String.format("%s %s %s (%s)", titul, jmeno, prijmeni, getAprobace());
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public String getAprobace() {
        String apro = "";
        for (String a : aprobace)
            apro += a + " ";

        return apro.trim().replace(" ", ",");
    }

    public void pridejAprobaci(String aprobace) {
        this.aprobace.add(aprobace);
    }
}
