package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Pojistovna pojistovna = new Pojistovna();
        Scanner sc = new Scanner(System.in);
/*Založení pomocných proměnných*/
        int volba = 0; //pro počáteční vypsání menu
        String vstupJmeno;
        String vstupPrijmeni;
        int vstupVek;
        int vstupTelefonníCislo;
/*while cyklus pro ukončení aplikace po zadání '4'
a pro počáteční vypsání menu (volba defaultně 0)
* */
        while (volba != 4) {
            System.out.println("\nVyberte si akci:");
            System.out.println("--------------------------------");
            System.out.println("1, Přidat nového pojištěného");
            System.out.println("--------------------------------");
            System.out.println("2, Vypsat všechny pojištěné");
            System.out.println("--------------------------------");
            System.out.println("3, Vyhledat pojištěného");
            System.out.println("--------------------------------");
            System.out.println("4, Konec");
            System.out.println("--------------------------------");
/*Ošetření špatného zadání vstupu - není číslo */
            try {
                volba = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("--------------------");
                System.out.println("Špatný formát vstupu!");
            }
/*Volba co chce uživatel aby aplikace udělala*/
            switch (volba) {
                case 1: /*volba '1' přídá nového pojistníka*/
                    System.out.println("Zadejte křestní jméno nového pojištěného:");
                    vstupJmeno = sc.nextLine().trim();
                    System.out.println("Zadejte příjmení:");
                    vstupPrijmeni = sc.nextLine().trim();
                    System.out.println("Zadejte věk (číslicí):");
                    /*Ošetření zda se zadal věk číslicí*/
                    try {
                        vstupVek = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Toto není číselný vstup. Zadejte pojištěného znovu.");
                        break;
                    }
                    System.out.println("Zadejte telefonní číslo:");
                    /*Ošetření zda se zadalo tel. číslo číslicí*/
                    try {
                        vstupTelefonníCislo = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Toto není číselný vstup. Zadejte pojištěného znovu.");
                        break;
                    }
                    /*přidání pojištěného do seznamu pojištěných*/
                    pojistovna.pridatPojisteneho(new Pojistnik(vstupJmeno, vstupPrijmeni, vstupVek, vstupTelefonníCislo));
                    break;

                case 2: /*volba '2' vypíše všechny pojištěné*/
                    pojistovna.vypisPojistene();
                    break;
                case 3:/* volba '3' vyhledá pojištěného podle jména a příjmení*/
                    /* vstupy */
                    System.out.println("Zadejte křestní jméno hledaného pojištěného:");
                    vstupJmeno = sc.nextLine().trim();
                    System.out.println("Zadejte příjmení:");
                    vstupPrijmeni = sc.nextLine().trim();
                    /*volání metody*/
                    Pojistnik pojistnik = pojistovna.vyhledatPojistene(vstupJmeno, vstupPrijmeni);
                    if (pojistnik == null) { /*ošetření prázdného výstupu*/
                        System.out.println("Takového pojištěného u nás neevidujeme.");
                    } else { /*výpis pojištěného pomocí toString*/
                        System.out.println("Výpis nalezených pojištěných dle zadaného jména a příjmení:");
                        System.out.println(pojistnik);
                    }
                    break;
                case 4:/*ukončí aplikaci*/
                    System.out.println("Děkujeme za použití aplikace. Hezký den!");
                    return;
                default:/*defaultní výstup - při špatném zadání volby*/
                    System.out.println("--------------------");
                    System.out.println("Chybný vstup!");
                    System.out.println("Zadejte číslici 1-4.\n");
            }
        }
    }
}