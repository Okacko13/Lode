/**
 * trida pomoci ktere muzeme nastavovat lode
 */
public class Lode {

    private int delka;
    private String jmeno;
    private char zkratka;

    public Lode(int delka, String jmeno, char zkratkaVeHre) {
        this.delka = delka;
        this.jmeno = jmeno;
        this.zkratka = zkratkaVeHre;
    }

    public int getDelka() {
        return delka;
    }


    public void setDelka(int delka) {
        this.delka = delka;
    }


    public String getJmeno() {
        return jmeno;
    }


    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }


    public char getZkratkaVeHre() {
        return zkratka;
    }

    public void setZkratkaVeHre(char zkratkaVeHre) {
        this.zkratka = zkratkaVeHre;
    }


    @Override
    public String toString() {
        return "Lod:" +
                " delka= " + delka +
                ", jmeno= " + jmeno  +
                ", zkratka= " + zkratka + '\n' ;
    }
}
