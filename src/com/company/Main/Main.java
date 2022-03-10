package com.company.Main;

import com.company.Osoby.Pedagog;
import com.company.Osoby.Zak;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDate ld2 = LocalDate.of(2000, 4, 28);
        LocalDate ld3 = LocalDate.of(2012, Month.MARCH, 15);

        Trida t1 = new Trida(new Pedagog("Gabriela", "Ohmová", "123456/9876", ld2, "Mgr."), (byte) 2);
        t1.tridni.pridejAprobaci("CJ");
        t1.tridni.pridejAprobaci("TV");
        Zak zak2 = new Zak("Jana", "Vyborna", "123444/2345", ld2, false, (byte) 3);
        Zak zak3 = new Zak("Jindrich", "Ospaly", "123213/4323", ld3, true);
        Zak zak4 = new Zak("Iva", "Moudra", "123432/9987", LocalDate.of(2002, 12, 14), false);

        t1.pridejZaka(zak2);
        t1.pridejZaka(zak3);
        t1.pridejZaka("Kocka", "Stekala", "123222/3333", ld2, false);
        t1.pridejZaka("Nejaky", "Clovek", "040119/4915", LocalDate.of(2004, 1, 19), true);
        t1.pridejZaka(zak4);

        t1.zvysRocnik();
        t1.odeberZaka("123432/8987");
        System.out.println(t1.vratInfo());
        System.out.println(Validace.overRodneCislo("040119/5135", LocalDate.of(2004, 1, 19), true));


    }
}
