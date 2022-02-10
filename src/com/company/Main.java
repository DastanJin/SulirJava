package com.company;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDate ld2 = LocalDate.of(2000,4,28);
        LocalDate ld3 = LocalDate.of(2001, Month.MARCH,15);

        Trida t1 = new Trida("Gabriela Ohmová",(byte)2);
        Zak zak2 = new Zak("Jana", "Vyborna","123444/2345",ld2,false,(byte)3);
        Zak zak3 = new Zak("Jindrich", "Ospaly","123213/4323",ld3,true);
        Zak zak4 = new Zak("Iva","Moudra","123432/9987",LocalDate.of(2002,12,14),false);

        t1.pridejZaka(zak2);
        t1.pridejZaka(zak3);
        t1.pridejZaka("Kocka","Stekala","123222/3333",ld2,false);
        t1.pridejZaka(zak3);
        t1.pridejZaka(zak4);

        System.out.println(t1.vratInfo());
        t1.zvysRocnik();
        t1.odeberZaka("123432/8987");
        System.out.println(t1.vratInfo());







    }
}
