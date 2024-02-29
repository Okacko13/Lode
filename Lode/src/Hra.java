import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * Trida hra spusti celou hru
 */
public class Hra {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private ArrayList<Lode> lodky = new ArrayList<>();
    private int rozmeryStrany;
    private String[][] arrayOdhaduHrace = new String[10][10];
    private String[][] arrayOdhaduProtihrace = new String[10][10];


    /**
     * instance tridy ProtivnikArena
     */
    public ProtivnikArena protivnikArena;

    /**
     * instance tridy Arena
     */
    public Arena arena;


    /**
     * konstruktor trydy Hra
     * nastavuji se v nem instance trid
     * @param rozmeryStrany  ma vstupni hodnotu rozmery Strany
     * @throws Exception vyhazuje vyjimky, kdyz rozmer strany je mensi nez 0
     */
    public Hra(int rozmeryStrany) throws Exception{
    this.rozmeryStrany = rozmeryStrany;
    arena = new Arena(this.rozmeryStrany);
    protivnikArena = new ProtivnikArena(this.rozmeryStrany);
    arrayOdhaduHrace = new String[this.rozmeryStrany][this.rozmeryStrany];
    arrayOdhaduProtihrace = new String[this.rozmeryStrany][this.rozmeryStrany];
}

    /**
     * nastavi odhado pole hrace
     */
    public void odhadovePoleVlozeniHrace(){    //vlozeni hodnot ohadoveho pole pocitace
    for(int i = 0; i<rozmeryStrany;i++){
        for(int j = 0;j<rozmeryStrany;j++){
            arrayOdhaduHrace[i][j]="~";
        }
    }
}

    /**
     * nastavi odhado pole pocitace
     */
    public void odhadovePoleVlozeniProtihrace(){  //vlozeni hodnot do ohadoveho pole pocitace
    for(int i = 0; i<rozmeryStrany;i++){
        for(int j = 0;j<rozmeryStrany;j++){
            arrayOdhaduProtihrace[i][j]="~";
        }
    }
}

    /**
     * vypise pole odhadu hrace
     */
    public void vypsaniOdhaduHrace() { //vypsani ohadoveho pole hrace
    for(int a = 0;a<rozmeryStrany;a++){
        System.out.print("\t" +(a));
    }
    int i = -1;
    System.out.print("\n");
    for (int y = 0; y < arrayOdhaduHrace.length; y++) {
        i++;
        for (int x = 0; x < arrayOdhaduHrace[y].length; x++) {
            if( x % 10 == 0 ){
                System.out.print(i);
            }
            System.out.print("\t" + arrayOdhaduHrace[y][x]);
        }
        System.out.println();
    }
}

    /**
     * vypise pole odhadu pocitace
     */
    public void vypsaniOdhaduProtihrace() {   //vypsani ohadoveho pole pocitace
    for(int a = 0;a<rozmeryStrany;a++){
        System.out.print("\t" +(a));
    }
    int i = -1;
    System.out.print("\n");
    for (int y = 0; y < arrayOdhaduProtihrace.length; y++) {
        i++;
        for (int x = 0; x < arrayOdhaduProtihrace[y].length; x++) {
            if(x % 10 == 0){
                System.out.print(i);
            }
            System.out.print("\t" + arrayOdhaduProtihrace[y][x]);
        }
        System.out.println();
    }
}

    /**
     * Strileni lodi.
     * Metoda, ktera postupne necha strilet hace a pak pocitac a tocito do te dobi, dokud to nekdo nevyhraje
     */
    public void strileniLodi() {
    System.out.println("\n>>>>>>>>>>>>>>>>>>> Lode <<<<<<<<<<<<<<<<<<<<<\n\n");



    this.odhadovePoleVlozeniHrace();
    this.odhadovePoleVlozeniProtihrace();

    System.out.println("Faze dosazovani lodi: ");
    arena.doPole();
    arena.pridaniLodeDoAreny();
    arena.vypsatPole();

    boolean konec = false;
    int potrebaProVyhru = 4;

    int rd4 = random.nextInt(4);
    int rd6 = random.nextInt(6)+1;

    boolean zasah = false;
    int mimo = -1;
    int trefaBota1 = mimo;
    int trefaBota2 = mimo;
    int puvodniTrefa1 = mimo;
    int puvodniTrefa2 = mimo;
    int posunX = 0;
    int posunY = 0;

    if(rd6==1){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 2, kriznik - 1, letadlova lod - 1\n");
    }else if(rd6==2){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 1, kriznik - 2, bitevni lod - 1\n");
    }else if(rd6==3){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 1, kriznik - 2, letadlova lod - 1\n");
    }else if(rd6==4){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 1, bitevni lod - 2, letadlova lod - 1\n");
    }else if(rd6==5){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 1, bitevni lod - 2, letadlova lod - 1\n");
    }else if(rd6==6){
        System.out.println("\nSeznam souperovych lodi: torpedoborec - 1, bitevni lod - 3");
    }

    protivnikArena.vytvoreniProtivnickeAreny();
    protivnikArena.pridaniLodiProtivnika(rd6);
    System.out.println("\nFaze prestrelovani: ");


        int pocetTrefenychCastiLodi = 0;


        while(!konec){ //cyklus, ktery neustale prohazuje odhadovani hrace a pocitace



        System.out.println("\nKam chces vystrelit?");
        int trefa1 = scanner.nextInt();
        int trefa2 = scanner.nextInt();


        if ((trefa1 < 0 || trefa1 > arena.rozmerStrany) || (trefa2 < 0 || trefa2 > arena.rozmerStrany)) {
            System.out.println("Tvoje trefa je mimo hraci pole.");
        } else {
            if (arrayOdhaduHrace[trefa1][trefa2].equals("*")) {
                System.out.println("Na toto misto uz jsi vystrelil!");
                this.vypsaniOdhaduHrace();
            } else if (!protivnikArena.poleProtivnika[trefa1][trefa2].equals("~")) {
                System.out.println("Lod zasazena!");
                arrayOdhaduHrace[trefa1][trefa2] = "*";

                protivnikArena.pridaniKrizkuNaMisto(trefa1, trefa2);
                if (rd6 == 1) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[1][1].equals("X") && protivnikArena.poleProtivnika[1][2].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[2][4].equals("X") && protivnikArena.poleProtivnika[2][5].equals("X") && protivnikArena.poleProtivnika[2][6].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[4][1].equals("X") && protivnikArena.poleProtivnika[5][1].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[6][4].equals("X") && protivnikArena.poleProtivnika[6][5].equals("X") && protivnikArena.poleProtivnika[6][4].equals("X") && protivnikArena.poleProtivnika[6][6].equals("X") && protivnikArena.poleProtivnika[6][7].equals("X") && protivnikArena.poleProtivnika[6][8].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");

                        konec =true;
                    }
                } else if (rd6 == 2) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[1][1].equals("X") && protivnikArena.poleProtivnika[2][1].equals("X") && protivnikArena.poleProtivnika[3][1].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[2][6].equals("X") && protivnikArena.poleProtivnika[3][6].equals("X") && protivnikArena.poleProtivnika[4][6].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[5][3].equals("X") && protivnikArena.poleProtivnika[5][4].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[7][4].equals("X") && protivnikArena.poleProtivnika[7][5].equals("X") && protivnikArena.poleProtivnika[7][6].equals("X") && protivnikArena.poleProtivnika[7][7].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");
                        konec =true;
                    }
                } else if (rd6 == 3) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[3][2].equals("X") && protivnikArena.poleProtivnika[4][2].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[1][4].equals("X") && protivnikArena.poleProtivnika[2][4].equals("X") && protivnikArena.poleProtivnika[3][4].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[6][1].equals("X") && protivnikArena.poleProtivnika[7][1].equals("X") && protivnikArena.poleProtivnika[8][1].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[1][8].equals("X") && protivnikArena.poleProtivnika[2][8].equals("X") && protivnikArena.poleProtivnika[3][8].equals("X") && protivnikArena.poleProtivnika[4][8].equals("X") && protivnikArena.poleProtivnika[5][8].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");
                        konec =true;
                    }
                } else if (rd6 == 4) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[2][1].equals("X") && protivnikArena.poleProtivnika[2][2].equals("X") && protivnikArena.poleProtivnika[2][3].equals("X") && protivnikArena.poleProtivnika[2][4].equals("X") && protivnikArena.poleProtivnika[2][5].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[1][7].equals("X") && protivnikArena.poleProtivnika[1][8].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[5][4].equals("X") && protivnikArena.poleProtivnika[5][5].equals("X") && protivnikArena.poleProtivnika[5][6].equals("X") && protivnikArena.poleProtivnika[5][7].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[7][3].equals("X") && protivnikArena.poleProtivnika[7][4].equals("X") && protivnikArena.poleProtivnika[7][5].equals("X") && protivnikArena.poleProtivnika[7][6].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");
                        konec =true;
                    }
                } else if (rd6 == 5) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[2][3].equals("X") && protivnikArena.poleProtivnika[2][4].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[8][4].equals("X") && protivnikArena.poleProtivnika[8][5].equals("X") && protivnikArena.poleProtivnika[8][6].equals("X") && protivnikArena.poleProtivnika[8][7].equals("X") && protivnikArena.poleProtivnika[8][8].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[2][7].equals("X") && protivnikArena.poleProtivnika[3][7].equals("X") && protivnikArena.poleProtivnika[4][7].equals("X") && protivnikArena.poleProtivnika[5][7].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[6][2].equals("X") && protivnikArena.poleProtivnika[6][3].equals("X") && protivnikArena.poleProtivnika[6][4].equals("X") && protivnikArena.poleProtivnika[6][5].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");
                        konec =true;
                    }
                } else if (rd6 == 6) {

                    int pocetSestrelenychLodi = 0;
                    if (protivnikArena.poleProtivnika[1][4].equals("X") && protivnikArena.poleProtivnika[1][5].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[2][1].equals("X") && protivnikArena.poleProtivnika[3][1].equals("X") && protivnikArena.poleProtivnika[4][1].equals("X") && protivnikArena.poleProtivnika[5][1].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[4][3].equals("X") && protivnikArena.poleProtivnika[5][3].equals("X") && protivnikArena.poleProtivnika[6][3].equals("X") && protivnikArena.poleProtivnika[7][3].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    if (protivnikArena.poleProtivnika[6][5].equals("X") && protivnikArena.poleProtivnika[6][6].equals("X") && protivnikArena.poleProtivnika[6][7].equals("X") && protivnikArena.poleProtivnika[6][8].equals("X")) {
                        pocetSestrelenychLodi++;
                    }
                    System.out.println("Pocet sestrelenych lodi: " + pocetSestrelenychLodi + "\n");
                    this.vypsaniOdhaduHrace();
                    if (pocetSestrelenychLodi == potrebaProVyhru) {
                        System.out.println("\nVyhral jsi! Gratuluji!");
                        break;
                    }
                }
            } else {
                System.out.println("Nic jsi netrefil!\n");
                protivnikArena.pridaniKrizkuNaMisto(trefa1, trefa2);
                arrayOdhaduHrace[trefa1][trefa2] = "X";
                this.vypsaniOdhaduHrace();
            }
        }


        System.out.println("\nHraje protihrac: ");

        int pocetKol = 0;
        int generovaniSouradnic1 = random.nextInt(rozmeryStrany);
        int generovaniSouradnic2 = random.nextInt(rozmeryStrany);

        if(puvodniTrefa1==mimo && puvodniTrefa2 == mimo){   //kdyz jsou hodnot trefa 1 a trefa 2 rovny 0, pridá jim random cislo od 0-9
            trefaBota1 = generovaniSouradnic1;
            trefaBota2 = generovaniSouradnic2;
        } else {
            boolean zamereno = false;
            int x = puvodniTrefa1;
            int y = puvodniTrefa2;

            while(!zamereno){
                x++;
                if(x== rozmeryStrany || this.arrayOdhaduProtihrace[x][y].equals("X")){
                    x = puvodniTrefa1;
                    break;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("*")){
                    continue;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("~")){
                    zamereno = true;
                    break;
                }
            }
            while(!zamereno){
                x--;
                if(x== -1 || this.arrayOdhaduProtihrace[x][y].equals("X")){
                    x = puvodniTrefa1;
                    break;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("*")){
                    continue;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("~")){
                    zamereno = true;
                    break;
                }
            }
            while(!zamereno){
                y++;
                if(y == rozmeryStrany || this.arrayOdhaduProtihrace[x][y].equals("X")){
                    y = puvodniTrefa2;
                    break;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("*")){
                    continue;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("~")){
                    zamereno = true;
                    break;
                }
            }
            while(!zamereno){
                y--;
                if(y == -1 || this.arrayOdhaduProtihrace[x][y].equals("X")){
                    y = puvodniTrefa2;
                    break;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("*")){
                    continue;
                }
                if(this.arrayOdhaduProtihrace[x][y].equals("~")){
                    zamereno = true;
                    break;
                }
            }

            if(zamereno == true){
                trefaBota1 = x;
                trefaBota2 = y;
            } else {
                trefaBota1 = generovaniSouradnic1;
                trefaBota2 = generovaniSouradnic2;
                puvodniTrefa1 = mimo;
                puvodniTrefa2 = mimo;
            }

        }
        System.out.println("Trefa1: " + trefaBota1 + ", trefa2: " + trefaBota2);

        if(arena.poleAreny[trefaBota1][trefaBota2].equals("~")){  //kdyz se trefa1 a trefa 2 netrefi do zadne z lodi
            this.arrayOdhaduProtihrace[trefaBota1][trefaBota2]="X";
            System.out.println(" Protihrac nic netrefil");
            this.vypsaniOdhaduProtihrace();


        }
        else if(this.arrayOdhaduProtihrace[trefaBota1][trefaBota2].equals("X") || this.arrayOdhaduProtihrace[trefaBota1][trefaBota2].equals("*")){ //kdyz se vygeneruje stejne policko
            System.out.println("Trefa na stejne misto.");
            this.vypsaniOdhaduProtihrace();

        } else if (arena.poleAreny[trefaBota1][trefaBota2].equals("T")) {        //kdyz trefa 1 a trefa 2 trefi torpedoborec
            System.out.println("\nTvuj torpedoborec byl zasazen: " + trefaBota1 + ", " + trefaBota2);
            this.arrayOdhaduProtihrace[trefaBota1][trefaBota2] = "*";
            pocetTrefenychCastiLodi++;
            if(puvodniTrefa1 == mimo){
                puvodniTrefa1 = trefaBota1;
            }
            if(puvodniTrefa2 == mimo){
                puvodniTrefa2 = trefaBota2;
            }

            //  stavBudouci1 = trefaBota1;
            // stavBudouci2 = trefaBota2;


            this.vypsaniOdhaduProtihrace();
        } else if (arena.poleAreny[trefaBota1][trefaBota2].equals("K")) { //kdyz trefa 1 a trefa 2 trefi kriznik
            System.out.println("\nTvuj kriznik byl zasazen: " + trefaBota1 + ", " + trefaBota2);
            this.arrayOdhaduProtihrace[trefaBota1][trefaBota2] = "*";
            pocetTrefenychCastiLodi++;
            if(puvodniTrefa1 == mimo){
                puvodniTrefa1 = trefaBota1;
            }
            if(puvodniTrefa2 == mimo){
                puvodniTrefa2 = trefaBota2;
            }
            this.vypsaniOdhaduProtihrace();

        } else if (arena.poleAreny[trefaBota1][trefaBota2].equals("B")) { //kdyz trefa 1 a trefa 2 trefi bojovou lod
            System.out.println("\nTvoje bitevni lod byla zasazena: " + trefaBota1 + ", " + trefaBota2);
            this.arrayOdhaduProtihrace[trefaBota1][trefaBota2] = "*";
            pocetTrefenychCastiLodi++;
            if(puvodniTrefa1 == mimo){
                puvodniTrefa1 = trefaBota1;
            }
            if(puvodniTrefa2 == mimo){
                puvodniTrefa2 = trefaBota2;
            }
            this.vypsaniOdhaduProtihrace();

        } else if (arena.poleAreny[trefaBota1][trefaBota2].equals("L")) { //kdyz trefa 1 a trefa 2 trefi letadlovou lod
            System.out.println("\nTvoje letadlova lod byla zasazena: " + trefaBota1 + ", " + trefaBota2);
            this.arrayOdhaduProtihrace[trefaBota1][trefaBota2] = "*";
            pocetTrefenychCastiLodi++;
            this.vypsaniOdhaduProtihrace();
            if(puvodniTrefa1 == mimo){
                puvodniTrefa1 = trefaBota1;
            }
            if(puvodniTrefa2 == mimo){
                puvodniTrefa2 = trefaBota2;
            }

        }
        if(pocetTrefenychCastiLodi== arena.pocetPolicek){     // melo by ukoncit hru kdyz jsou trefeny vsechny souperova policka jine nez prazdne
            System.out.println("\nProhrál jsi. Pocitac nasel vsechny tve lode.");

            konec = true;
        }
    }
}

    /**
     * Pridani lode.

     * @param l the l
     */
    public void pridaniLode(Lode l) {   //pridani lodi do arrayListu (slouzi jenom k vypisu na zacatku)
        lodky.add(l);
    }

    /**
     * Vypis lodek.
     */
    public void vypisLodek() {      //slouzi jenom k vypisu lodi z arraylistu na zacatku
        System.out.println(lodky.toString());
    }

}
