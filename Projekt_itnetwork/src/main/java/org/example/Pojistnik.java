package org.example;
class Pojistnik {
    /*proměnné*/
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefonniCislo;
/*konstruktor třídy*/
    public Pojistnik(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }
    public String getJmeno() {
        return jmeno;
    }
    public String getPrijmeni() {
        return prijmeni;
    }
    public int getVek() {
        return vek;
    }
    public int getTelefonniCislo() {
        return telefonniCislo;
    }

    @Override /*metoda pro volání Stringové hodnoty třídy*/
    public String toString() {
        return jmeno + "\t" + prijmeni + "\t" + vek + "\t" + telefonniCislo;
    }
}

