package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pojistovna {
    private List<Pojistnik> seznamPojistenych;
    public Pojistovna() { /*konstruktor se seznamem pojištěných*/
        seznamPojistenych = new ArrayList<>();
    }
    public void pridatPojisteneho(Pojistnik pojistnik) {
        /*metoda pro přidání pojištěného*/
        seznamPojistenych.add(pojistnik);
    }

    public void vypisPojistene() {
        /*ošetření volání výpisu na prázdný seznam*/
        if (seznamPojistenych.isEmpty())
            System.out.print("Zatím neevidujeme žádné pojištěné.");
        else/*pokud seznam není prázdný, vypíše všechny pojištěné*/
            System.out.println("Výpis pojištěných:");
        for (Pojistnik pojistnik : seznamPojistenych) {
            System.out.println(pojistnik);
        }
    }

    public Pojistnik vyhledatPojistene(String jmeno, String prijmeni) {
        /*metoda pro hledání pojištěného podle jména a příjmení*/
        for (Pojistnik pojistnik : seznamPojistenych) { /*procházení + ošetření velkých/malých písmen*/
            if (pojistnik.getJmeno().toLowerCase().equals(jmeno) && pojistnik.getPrijmeni().toLowerCase().equals(prijmeni)) {
                return pojistnik;
            }
        }
        return null;
    }
}
