import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {


            Hra hra =new Hra(10);

            hra.pridaniLode(new Lode(2,"torpedoborec", 'T'));
            hra.pridaniLode(new Lode(3, "kriznik", 'K'));
            hra.pridaniLode(new Lode(4, "bitevniLod", 'B'));
            hra.pridaniLode(new Lode(5,"letadlovaLod", 'L'));

            hra.arena.doPole();
            hra.vypisLodek();

            try {
                hra.strileniLodi();
            }catch (InputMismatchException e){
                System.out.println("Zadal jsi spatnou odpoved.(jde to cele od znova)");
            }

        }catch (Exception e ){
            throw new  RuntimeException(e);
        }
    }
}