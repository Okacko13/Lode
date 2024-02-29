import java.util.Random;

/**
 * Trida ktera nam urci pole pocitace
 * dedi od tridy Arena
 */
public class ProtivnikArena extends Arena{


    Random random = new Random();
    /**
     * pole pocitace, na ktere si pocitac uklada lode
     */
    protected String[][] poleProtivnika;
    public Arena arena;

    /**
     * konstruktor
     *
     * @param rozmerStrany  rozmer strany
     * @throws Exception  vyhazuje vyjimky, kdyz je rozmer strany je mensi nez 0
     */
    public ProtivnikArena(int rozmerStrany) throws Exception {
        super(rozmerStrany);
        poleProtivnika = new String[this.rozmerStrany][this.rozmerStrany];
        arena = new Arena(this.rozmerStrany);

    }

    /**
     * Vytvoreni protivnicke areny
     * vlozi na kazde policko pole protivnika ~
     */
    public void vytvoreniProtivnickeAreny(){//prida hodnoty do pole protivnika
        for(int i = 0; i<rozmerStrany;i++){
            for(int j = 0;j<rozmerStrany;j++){
                poleProtivnika[i][j]="~";
            }
        }
    }



    /**
     * Pridani krizku na misto.
     * Prida krizek na misto urcne vstupnimi hodnotami
     * @param i parametr urcujici hodnotu pro urceni radku
     * @param j parametr urcujici hodnotu pro urceni sloupce
     */
    public void pridaniKrizkuNaMisto(int i, int j){
        poleProtivnika[i][j]="X";
    }


    /**
     * Pridani lodi protivnika.
     * prida preddefinovane lode do pocitacova pole
     * @param i cislo, ktere urci ktera z preddefinovaych pozic lodi bude na vystupu
     */

    public void pridaniLodiProtivnika(int i){


        switch (i) {
            case 1 :
                poleProtivnika[1][1]="T";
                poleProtivnika[1][2]="T";

                poleProtivnika[4][1]="T";
                poleProtivnika[5][1]="T";

                poleProtivnika[2][4]="K";
                poleProtivnika[2][5]="K";
                poleProtivnika[2][6]="K";

                poleProtivnika[6][4]="L";
                poleProtivnika[6][5]="L";
                poleProtivnika[6][6]="L";
                poleProtivnika[6][7]="L";
                poleProtivnika[6][8]="L";
                arena.pocetPolicek = 12;
                break;

            case 2 :
                poleProtivnika[5][3]="T";
                poleProtivnika[5][4]="T";

                poleProtivnika[1][1]="K";
                poleProtivnika[2][1]="K";
                poleProtivnika[3][1]="K";

                poleProtivnika[2][6]="K";
                poleProtivnika[3][6]="K";
                poleProtivnika[4][6]="K";

                poleProtivnika[7][4]="B";
                poleProtivnika[7][5]="B";
                poleProtivnika[7][6]="B";
                poleProtivnika[7][7]="B";
                arena.pocetPolicek = 12;
                break;

            case 3 :
                poleProtivnika[3][2]="T";
                poleProtivnika[4][2]="T";

                poleProtivnika[1][4]="K";
                poleProtivnika[2][4]="K";
                poleProtivnika[3][4]="K";

                poleProtivnika[6][1]="K";
                poleProtivnika[7][1]="K";
                poleProtivnika[8][1]="K";

                poleProtivnika[1][8]="L";
                poleProtivnika[2][8]="L";
                poleProtivnika[3][8]="L";
                poleProtivnika[4][8]="L";
                poleProtivnika[5][8]="L";
                arena.pocetPolicek = 13;
                break;
            case 4 :
                poleProtivnika[1][7]="T";
                poleProtivnika[1][8]="T";

                poleProtivnika[5][4]="B";
                poleProtivnika[5][5]="B";
                poleProtivnika[5][6]="B";
                poleProtivnika[5][7]="B";

                poleProtivnika[7][3]="B";
                poleProtivnika[7][4]="B";
                poleProtivnika[7][5]="B";
                poleProtivnika[7][6]="B";

                poleProtivnika[2][1]="L";
                poleProtivnika[2][2]="L";
                poleProtivnika[2][3]="L";
                poleProtivnika[2][4]="L";
                poleProtivnika[2][5]="L";
                arena.pocetPolicek = 15;
                break;
            case 5 :
                poleProtivnika[2][3]="T";
                poleProtivnika[2][4]="T";

                poleProtivnika[2][7]="B";
                poleProtivnika[3][7]="B";
                poleProtivnika[4][7]="B";
                poleProtivnika[5][7]="B";

                poleProtivnika[6][2]="B";
                poleProtivnika[6][3]="B";
                poleProtivnika[6][4]="B";
                poleProtivnika[6][5]="B";

                poleProtivnika[8][4]="L";
                poleProtivnika[8][5]="L";
                poleProtivnika[8][6]="L";
                poleProtivnika[8][7]="L";
                poleProtivnika[8][8]="L";
                arena.pocetPolicek = 15;
                break;
            case 6 :
                poleProtivnika[1][4]="T";
                poleProtivnika[1][5]="T";

                poleProtivnika[2][1]="B";
                poleProtivnika[3][1]="B";
                poleProtivnika[4][1]="B";
                poleProtivnika[5][1]="B";

                poleProtivnika[4][3]="B";
                poleProtivnika[5][3]="B";
                poleProtivnika[6][3]="B";
                poleProtivnika[7][3]="B";

                poleProtivnika[6][5]="B";
                poleProtivnika[6][6]="B";
                poleProtivnika[6][7]="B";
                poleProtivnika[6][8]="B";
                arena.pocetPolicek = 14;
                break;
        }
    }
}
