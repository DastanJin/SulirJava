package com.company.Main;

import com.company.Osoby.Pedagog;
import com.company.Osoby.Zak;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trida {
    ArrayList<Zak> zaci;
    Pedagog tridni;
    Byte rocnik;

    public Trida(Pedagog tridni, Byte rocnik) {
        this.zaci = new ArrayList<>();
        this.tridni = tridni;
        this.rocnik = rocnik;
    }

    public void pridejZaka(Zak z) {
        if (!Validace.overRodneCislo(z.getRodne_cislo(), z.getDatum_narozeni(), z.isChlapec())) {
            System.out.printf("Zak %s neprosel validaci rodneho cisla\n\r",z.vratInfo());
        } else {
            if (jeZakVeTride(z) == -1) {
                z.setRocnik(rocnik);
                zaci.add(z);
                System.out.printf("\n\rZak %s byl uspesne pridan\n\r", z.vratInfo());
            } else
                System.out.printf("\n\rZak %s je jiz soucasti tridy\n\r", z.vratInfo());
        }
        //throw new RuntimeException("Zak je jiz soucasti tridy") ;
    }

    public void pridejZaka(String jmeno, String prijmeni, String rodne_cislo, LocalDate datum_narozeni, boolean chlapec) {
        this.pridejZaka(new Zak(jmeno, prijmeni, rodne_cislo.replace("\\","/").trim(), datum_narozeni, chlapec));
    }

    public void odeberZaka(String rodnecislo) {
        if (jeZakVeTride(rodnecislo) == -1)
            System.out.println("\n\rZak nenalezen");
        else {
            zaci.remove(jeZakVeTride(rodnecislo));
            System.out.println("\n\rZak %s uspesne odebran");
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
        StringBuilder txt = new StringBuilder("*************** Seznam ????k?? ***************" + System.lineSeparator());
        for (Zak z : zaci)
            txt.append(z.vratInfo()).append(System.lineSeparator());
        txt.append("*******************************************");
        return txt.toString();
    }

    public String vratInfo() {
        String txt = String.format("\n\r**************** %d. t????da *****************", rocnik) + System.lineSeparator();
        txt += "t????dn??: " + tridni.vratInfo() + System.lineSeparator();
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
