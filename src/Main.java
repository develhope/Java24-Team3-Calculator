import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nella strabiliante calcolatrice del gruppo 3!");
    }

    public static double potenza (double base, int esponente) {
        if (base == 0) {
            if (esponente == 0) {
                System.out.println("0 elevato a 0 non avrebbe senso, ma restituisco 0.");
            }
            return 0;
        } else {
            if (esponente == 0) {
                return 1;
            } else {
                if (base == 1) {
                    return 1;
                } else {
                    double risultato = base;

                    if (esponente > 0) {
                        for (int i = 1; i < esponente; i++) {
                                risultato *= base;
                        }

                        return risultato;
                    } else {
                        for (int i = -1; i > esponente; i--) {
                            risultato *= base;
                        }

                        return 1 / risultato;
                    }
                }
            }
        }
    }
}