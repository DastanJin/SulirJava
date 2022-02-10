package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trida {
    ArrayList<Zak> zaci;
    String tridni;
    Byte rocnik;

    public Trida(String tridni, Byte rocnik) {
        this.zaci = new ArrayList<>();
        this.tridni = tridni;
        this.rocnik = rocnik;
    }

    public void pridejZaka(Zak z) {
        if (jeZakVeTride(z) == -1) {
            z.setRocnik(rocnik);
            zaci.add(z);
            System.out.printf("Zak %s byl uspesne pridan\n\r", z.vratInfo());
        } else
            System.out.printf("Zak %s je jiz soucasti tridy\n\r", z.vratInfo());
        //throw new RuntimeException("Zak je jiz soucasti tridy") ;
    }

    public void pridejZaka(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec) {
        this.pridejZaka(new Zak(jmeno, prijmeni, rodne_cislo, datum_narozeni, chlapec));
    }

    public void odeberZaka(String rodnecislo) {
        if (jeZakVeTride(rodnecislo) == -1)
            System.out.println("Zak nenalezen");
        else {
            zaci.remove(jeZakVeTride(rodnecislo));
            System.out.println("Zak %s uspesne odebran");
        }


    }

    private int jeZakVeTride(Zak zak) {
        return zaci.indexOf(zak);
    }

    private int jeZakVeTride(String rodne_cislo) {
        for (Zak z : zaci) {
            if (z.getRodne_cislo().equals(rodne_cislo))
                return zaci.indexOf(z);
        }
        return -1;
    }

    public void zvysRocnik() {
        rocnik++;
        for (Zak z : zaci)
            z.setRocnik(rocnik);
    }

    public String vratInfoOZacich() {
        StringBuilder txt = new StringBuilder("*************** Seznam žáků ***************" + System.lineSeparator());
        for (Zak z : zaci)
            txt.append(z.vratInfo()).append(System.lineSeparator());
        txt.append("*******************************************");
        return txt.toString();
    }

    public String vratInfo() {
        String txt = String.format("*************** %d. třída ***************", rocnik) + System.lineSeparator();
        txt += "třídní: " + tridni + System.lineSeparator();
        txt += this.vratInfoOZacich();
        return txt;
    }

    @Override
    public String toString() {
        return "Trida{" +
                "zaci(pocet)=" + zaci.size() +
                ", tridni='" + tridni + '\'' +
                ", rocnik=" + rocnik +
                '}';
    }
}
