import java.util.Scanner;

/**
 * Trida, ktera nam urci hracovo pole
 */
public class Arena {
    /**
     * rozmer strany.
     */
    protected int rozmerStrany;

    public String[][] poleAreny ; //pole harace

    public Scanner scanner = new Scanner(System.in);
    private String voda = "~";

    /**
     * konstruktor
     *
     * @param rozmerStrany the rozmer strany
     * @throws Exception vyhodi vyjimku, kdyz rozmer strany je mensi nez 0
     */
    public Arena(int rozmerStrany) throws Exception {
        setRozmerStrany(rozmerStrany);
        poleAreny = new String[this.rozmerStrany][this.rozmerStrany];
    }

    /**
     * Ulozi promenou ~ do dvojdimenzionalniho pole neboli hraci pole hrace
     */
    public void doPole(){ //prida hodnoty do pole Hrace
        for(int i = 0; i<rozmerStrany;i++){
            for(int j = 0;j<rozmerStrany;j++){
                poleAreny[i][j]=voda;
            }
        }
    }

    /**
     * vypise hraci pole hrace
     */
    public void vypsatPole() { //vypise pole hrace
        for(int a = 0;a<rozmerStrany;a++){
            System.out.print("\t" +(a));
        }
        int i = -1;
        System.out.print("\n");
        for (int y = 0; y < poleAreny.length; y++) {
            i++;
            for (int x = 0; x < poleAreny[y].length; x++) {
                if(x % 10 == 0){
                    System.out.print(i);
                }
                System.out.print("\t" + poleAreny[y][x]);
            }
            System.out.println();
        }
    }


    /**
     * zde se ulozi pocet policek, ktere jsou zabrany lodmi
     */
    protected int pocetPolicek = 0;


    public void setPocetPolicek(int pocetPolicek) {
        this.pocetPolicek = pocetPolicek;
    }


    public int getPocetPolicek(){
        return pocetPolicek;
    }

    /**
     * metoda, pomoci ktere si uzivatel nadefinuje lode do jehoh hhraciho pole
     */
    int i = 0;
    public void pridaniLodeDoAreny() {  // metoda na pridavani lodi do pole hrace
        System.out.println("\n(Ciselne hodnoty zadavej ve forme:\n\"cislo radku\"\n\"cislo sloupce\")\n");


        while(i!=4){

            System.out.println("Kterou lod chces pridat? (Celkove budou ctyry lodi)");
            String scan = scanner.next();

            this.pridaniLode(scan);
            i++;
            /*
            switch (scan)
            {

                 case "torpedoborec":
                    this.pridaniTorpedoborce();
                    break;
                case "T":
                    this.pridaniTorpedoborce();
                    break;
                case "t":
                    this.pridaniTorpedoborce();
                    break;

                case "kriznik":
                    this.pridaniKrizniku();
                    break;
                case "K":
                    this.pridaniKrizniku();
                    break;
                case "k":
                    this.pridaniKrizniku();
                    break;

                case "bitevniLod":
                    this.pridaniBitebniLodi();
                    break;
                case "B":
                    this.pridaniBitebniLodi();
                    break;
                case "b":
                    this.pridaniBitebniLodi();
                    break;

                case "letadlovaLod" :
                    this.pridaniLetadloveLode();
                    break;

                case "L" :
                    this.pridaniLetadloveLode();
                    break;

                case "l" :
                    this.pridaniLetadloveLode();
                    break;


            }
            */
        }
        System.out.println("\n");
    }
    /*
     public void pridaniTorpedoborce(){
        System.out.println("Kam chces torpedoborce polozit?");
        int n = scanner.nextInt();
        int n2 = scanner.nextInt();

        if ((n < 0 || n2 < 0)) {
            System.out.println("Prosim umisti lod do pole celou! (nevejde se ti do hraciho pole)");

        } else if ((n + 2) > poleAreny.length) {
            if(poleAreny[n][n2].equals(voda)&&poleAreny[n][n2+1].equals(voda)){
                for(int i = 0;i < 2; i++){
                    poleAreny[n][n2+1] = "T";
                    pocetPolicek++;
                }

                this.vypsatPole();
                i++;

            }else {
                System.out.println("Lode se nesmi prekrivat.");
            }


        } else if ((n2 + 2) > poleAreny.length) {
            if(poleAreny[n][n2].equals(voda)&&poleAreny[n+1][n2].equals(voda)){
                poleAreny[n][n2] = "T";
                poleAreny[n + 1][n2] = "T";
                pocetPolicek++;
                pocetPolicek++;

                this.vypsatPole();
                i++;

            }else {
                System.out.println("Lode se nesmi prekrivat.");
            }


        } else {
            System.out.println("Chces torpedoborec polozit svisle (s), nebo vodorovne (v)?");
            String odpoved = scanner.next();
            if (odpoved.equals("s")) {
                if(poleAreny[n][n2].equals(voda)&&poleAreny[n+1][n2].equals(voda)){
                    poleAreny[n][n2] = "T";
                    poleAreny[n + 1][n2] = "T";
                    pocetPolicek++;
                    pocetPolicek++;

                    this.vypsatPole();
                    i++;

                }else {
                    System.out.println("Lode se nesmi prekrivat.");
                }
            } else if (odpoved.equals("v")) {
                if(poleAreny[n][n2].equals(voda)&&poleAreny[n][n2+1].equals(voda)){
                    poleAreny[n][n2] = "T";
                    poleAreny[n][n2 + 1] = "T";
                    pocetPolicek++;
                    pocetPolicek++;

                    this.vypsatPole();
                    i++;

                }else {
                    System.out.println("Lode se nesmi prekrivat.");
                }
            } else {
                System.out.println("Mel jsi zadat s, nebo v.");
            }
        }
    }
    public void pridaniKrizniku(){

        System.out.println("Kam chces kriznik polozit?");
        int m = scanner.nextInt();
        int m2 = scanner.nextInt();

        if((m<0 || m2<0)){

            System.out.println("Prosim umisti lod do pole celou! (Nevejde se ti do hraciho pole)");


        }else if((m<(0) || (m+3)> poleAreny.length)) {

            if(poleAreny[m][m2].equals(voda)&&poleAreny[m][m2+1].equals(voda)&&poleAreny[m][m2+2].equals(voda)){
                poleAreny[m][m2] = "K";
                poleAreny[m][m2 + 1] = "K";
                poleAreny[m][m2 + 2] = "K";
                pocetPolicek++;
                pocetPolicek++;
                pocetPolicek++;

                this.vypsatPole();

                i++;

            }else{
                System.out.println("Nemuzes prekryvat lode pres sebe");
            }

        }else if(m2<(0) || (m2+3)> poleAreny.length){
            if(poleAreny[m][m2].equals(voda)&&poleAreny[m+1][m2].equals(voda)&&poleAreny[m+2][m2].equals(voda)){
                poleAreny[m][m2] = "K";
                poleAreny[m + 1][m2] = "K";
                poleAreny[m + 2][m2] = "K";
                pocetPolicek++;
                pocetPolicek++;
                pocetPolicek++;
                this.vypsatPole();

                i++;
            }else{
                System.out.println("Nemuzes prekrivat lode pres sebe");
            }

        }else {

            System.out.println("Chces kriznik polozit svisle (s), nebo vodorovne (v)?");
            String odpoved = scanner.next();
            if (odpoved.equals("s")) {
                if(poleAreny[m][m2].equals(voda)&&poleAreny[m+1][m2].equals(voda)&&poleAreny[m2+2][m2].equals(voda)){
                    for (int q = 0; q < 3; q++) {
                        poleAreny[m + q][m2] = "K";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;
                }else{
                    System.out.println("Lode se nemohou prekrivat!");
                }

            } else if (odpoved.equals("v")) {
                if(poleAreny[m][m2].equals(voda)&&poleAreny[m][m2+1].equals(voda)&&poleAreny[m][m2+2].equals(voda)){
                    for (int o = 0; o < 3 ; o++) {
                        poleAreny[m][m2 + o] = "K";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;
                }else{
                    System.out.println("Lode se nemohou prekrivat!");
                }
            } else {
                System.out.println("Mel jsi zadat h, nebo v.");
            }
        }
    }
    public void pridaniBitebniLodi(){
        System.out.println("Kam chces bitevni lod polozit?");
        int o = scanner.nextInt();
        int o2 = scanner.nextInt();

        if((o <0 || o2<0)){
            System.out.println("Prosim umisti lod do pole celou! (nevejde se ti do hracího pole)");

        }else if(o  <(0) || (o+4)> poleAreny.length){
            if(poleAreny[o][o2].equals(voda)&&poleAreny[o][o2+1].equals(voda)&&poleAreny[o][o2+2].equals(voda)&&poleAreny[o][o2+3].equals(voda)){
                for (int q = 0; q < 4; q++) {
                    poleAreny[o][o2 + q] = "B";
                    pocetPolicek++;
                }
                this.vypsatPole();

                i++;

            }else{
                System.out.println("Lode se nesmi prekrivat.");
            }
        }else if(o2<(0) || (o2+4)> poleAreny.length){
            if(poleAreny[o][o2].equals(voda)&&poleAreny[o+1][o2].equals(voda)&&poleAreny[o+2][o2].equals(voda)&&poleAreny[o+3][o2].equals(voda)){
                for (int q = 0; q < 4; q++) {
                    poleAreny[o + q][o2] = "B";
                    pocetPolicek++;
                }
                this.vypsatPole();

                i++;

            }else{
                System.out.println("Lode se nesmi prekrivat.");
            }

        } else {
            System.out.println("Chces bitevni lod polozit svisle (s), nebo vodorovne (v)?");
            String odpoved1 = scanner.next();
            if (odpoved1.equals("s")) {
                if(poleAreny[o][o2].equals(voda)&&poleAreny[o+1][o2].equals(voda)&&poleAreny[o+2][o2].equals(voda)&&poleAreny[o+3][o2].equals(voda)){
                    for (int q = 0; q < 4; q++) {
                        poleAreny[o+q][o2] = "B";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;

                }else{
                    System.out.println("Lode se nesmi prekrivat.");
                }
            } else if (odpoved1.equals("v")) {
                if(poleAreny[o][o2].equals(voda)&&poleAreny[o][o2+1].equals(voda)&&poleAreny[o][o2+2].equals(voda)&&poleAreny[o][o2+3].equals(voda)){
                    for (int q = 0; q < 4; q++) {
                        poleAreny[o][o2+q] = "B";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;
                }
            }else{
                System.out.println("Lode se nesmi prekrivat.");
            }
        }
    }
    public void pridaniLetadloveLode(){
        System.out.println("Kam chces letadlovou lod polozit?");

        int p = scanner.nextInt();
        int p2 = scanner.nextInt();

        if ((p < 0 || p2 < 0)) {
            System.out.println("Prosim umisti lod do pole celou! (nevejde se ti do hraciho pole)");

        } else if (p < (0) || (p + 5) > poleAreny.length) {
            if(poleAreny[p][p2].equals(voda)&&poleAreny[p][p2+1].equals(voda)&&poleAreny[p][p2+2].equals(voda)&&poleAreny[p][p2+3].equals(voda)){
                for (int q = 0; q < 5; q++) {
                    poleAreny[p][p2 + q] = "L";
                    pocetPolicek++;
                }
                this.vypsatPole();

                i++;

            }else{
                System.out.println("Nelze davat lode pre sebe.");
            }
        } else if (p2 < (0) || (p2 + 5) > poleAreny.length) {
            if(poleAreny[p][p2].equals(voda)&&poleAreny[p+1][p2].equals(voda)&&poleAreny[p+2][p2].equals(voda)&&poleAreny[p+3][p2].equals(voda)&&poleAreny[p+4][p2].equals(voda)){
                for (int q = 0; q < 5; q++) {
                    poleAreny[p + q][p2] = "L";
                    pocetPolicek++;
                }
                this.vypsatPole();
                i++;
            }else{
                System.out.println("Nelze prekrivat lode pres sebe.");
            }

        } else {
            System.out.println("Chces letadlovou lod polozit svisle (s), nebo vodorovne (v)?");
            String odpoved = scanner.next();
            if (odpoved.equals("s")) {
                if(poleAreny[p][p2].equals(voda)&&poleAreny[p+1][p2].equals(voda)&&poleAreny[p+2][p2].equals(voda)&&poleAreny[p+3][p2].equals(voda)&&poleAreny[p+4][p2].equals(voda)){
                    for (int q = 0; q < 5; q++) {
                        poleAreny[p + q][p2] = "L";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;

                }else{
                    System.out.println("Nelze prekrivat lode pres sebe.");
                }
            } else if (odpoved.equals("v")) {
                if(poleAreny[p][p2].equals(voda)&&poleAreny[p][p2+1].equals(voda)&&poleAreny[p][p2+2].equals(voda)&&poleAreny[p][p2+3].equals(voda)&&poleAreny[p][p2+4].equals(voda)){
                    for (int q = 0; q < 5; q++) {
                        poleAreny[p][p2 + q] = "L";
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;

                }else{
                    System.out.println("Nelze davat lode pre sebe");
                }
            } else {
                System.out.println("Mel jsi zadat h, nebo v.");

            }
        }
    }
     */

    public void pridaniLode(String kteraLod){
        
        int delkaLodePridavane = 0;
        String jmenoLodi = "";
        String znakLode = "";
        boolean realitaLodi = false;

        if(kteraLod.equals("t") || kteraLod.equals("T") || kteraLod.equals("torpedoborec") || kteraLod.equals("Torpedoborec")){
            delkaLodePridavane = 2;
            jmenoLodi = "torpedoborec";
            znakLode = "T";
            realitaLodi = true;

        } else if(kteraLod.equals("k") || kteraLod.equals("K") || kteraLod.equals("Kriznik") || kteraLod.equals("kriznik")){
            delkaLodePridavane = 3;
            jmenoLodi = "kriznik";
            znakLode = "K";
            realitaLodi = true;

        } else if(kteraLod.equals("b") || kteraLod.equals("B") || kteraLod.equals("bitevniLod") || kteraLod.equals("BitevniLod")){
            delkaLodePridavane = 4;
            jmenoLodi = "bitevni lod";
            znakLode = "B";
            realitaLodi = true;

        } else if(kteraLod.equals("l") || kteraLod.equals("L") || kteraLod.equals("letadlovaLod") || kteraLod.equals("LetadlovaLod")){
            delkaLodePridavane = 5;
            jmenoLodi = "letadlovou lod";
            znakLode = "L";
            realitaLodi = true;

        }

        if(realitaLodi == true){
            System.out.println("Kam chces " + jmenoLodi +" lod polozit?");

            int p = scanner.nextInt();
            int p2 = scanner.nextInt();

            if ((p < 0 || p2 < 0)) {
                System.out.println("Prosim umisti lod do pole celou! (nevejde se ti do hraciho pole)\n");

            } else if (((p2 + delkaLodePridavane ) > poleAreny.length && (p + delkaLodePridavane ) > poleAreny.length)) {
                System.out.println("nevejde se ti do pole");

            } else if ((p + delkaLodePridavane) > poleAreny.length) {
                if(poleAreny[p][p2].equals(voda) && poleAreny[p][p2+delkaLodePridavane].equals(voda)){
                    for (int q = 0; q < delkaLodePridavane; q++) {
                        poleAreny[p][p2 + q] = znakLode;
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;

                }else{
                    System.out.println("Nelze davat lode pre sebe.");
                }
            } else if ((p2 + delkaLodePridavane) > poleAreny.length) {
                if(poleAreny[p][p2].equals(voda) && poleAreny[p + delkaLodePridavane][p2].equals(voda)){
                    for (int q = 0; q < delkaLodePridavane; q++) {
                        poleAreny[p + q][p2] = znakLode;
                        pocetPolicek++;
                    }
                    this.vypsatPole();

                    i++;
                }else{
                    System.out.println("Nelze prekrivat lode pres sebe.");
                }

            } else {
                System.out.println("Chces letadlovou lod polozit svisle (s), nebo vodorovne (v)?");
                String odpoved = scanner.next();
                if (odpoved.equals("s")) {
                    if (poleAreny[p][p2].equals(voda) && poleAreny[p + delkaLodePridavane - 1][p2].equals(voda)) {
                        for (int q = 0; q < delkaLodePridavane; q++) {
                            poleAreny[p + q][p2] = znakLode;
                            pocetPolicek++;
                        }
                        this.vypsatPole();

                        i++;

                    } else {
                        System.out.println("Nelze prekrivat lode pres sebe.");
                    }
                } else if (odpoved.equals("v")) {
                    if (poleAreny[p][p2].equals(voda) && poleAreny[p][p2 + delkaLodePridavane -1].equals(voda)) {
                        for (int q = 0; q < delkaLodePridavane; q++) {
                            poleAreny[p][p2 + q] = znakLode;
                            pocetPolicek++;
                        }
                        this.vypsatPole();

                        i++;

                    } else {
                        System.out.println("Nelze davat lode pre sebe.");
                    }
                } else {
                    System.out.println("Mel jsi zadat h, nebo v.");

                }
            }
        }else{
            System.out.println("Neznama lod!\n");
        }

    }

    public boolean kontrolaVolnostiVodorovne(int delka, int osaX, int osaY) {

        boolean lzePolozit = false;



        return lzePolozit;
    }

    public boolean kontrolaVolnostiSvisle(int delka) {

        boolean lzePolozit = false;



        return lzePolozit;
    }



    /**
     * setter pro rozmer strany, ktery je obvzlasteny tim, ze hodnoty v nem muzou byt pouze vetsi jak 0
     *
     * @param rozmerStrany vstupi hodnota rozmer strany
     * @throws Exception vyhazuje vyjimky pri zadani rozmeru strany je mensi nez 0
     */
    public void setRozmerStrany(int rozmerStrany) throws Exception{
        if(rozmerStrany > 0){
            this.rozmerStrany = rozmerStrany;
        } else {
            throw new Exception("Rozmery maj kladnou hodnotu!");
        }
    }

}