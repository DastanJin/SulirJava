package com.company.Main;

import java.time.LocalDate;

import static java.lang.Integer.*;

public class Validace {
    public static boolean overRodneCislo(String rodneCislo, LocalDate datum_narozeni, boolean chlapec) {
            // datum_narozeni.toString() >>> "RRRR-MM-DD"
        int rr = parseInt(datum_narozeni.toString().substring(2, 4));           //Ziskani roku z data jako int
        int mm = parseInt(datum_narozeni.toString().substring(5, 7));           //Ziskani mesice z data jako int
        mm = chlapec ? mm : mm + 50;                                            //Pripocteni +50 k mesici v pripade ZENY
        int dd = parseInt(datum_narozeni.toString().substring(8, 10));          //Ziskani dnu z data jako int
        int cele_cislo = parseInt(rodneCislo.replace("/",""));  //Ziskani rodnehoCisla bez lomitka jako int RRMMDDXXXX


        //Overovani delky rodnehoCisla
        if (rodneCislo.length() != 11){
            System.out.println("\n\rRodne cislo: Spatna delka");
            return false;
        }
        //Overovani roku rodnehoCisla
        if (parseInt(rodneCislo.substring(0, 2)) != rr){
            System.out.println("\n\rRodne cislo: Spatny rok");
            return false;
        }
        //Overovani mesice rodnehoCisla
        if (parseInt(rodneCislo.substring(2, 4)) != mm){
            System.out.println("\n\rRodne cislo: Spatny mesic");
            return false;
        }
        //Overovani dnu rodnehoCisla
        if (parseInt(rodneCislo.substring(4, 6)) != dd){
            System.out.println("\n\rRodne cislo: Spatny den");
            return false;
        }
        //Overovani delitelnosti cislem 11 rodnehoCisla
        if (cele_cislo%11 != 0){
            System.out.println("\n\rRodne cislo: Neni delitelne 11");
            return false;
        }

        return true;
    }

}
