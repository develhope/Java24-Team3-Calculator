import java.io.Console;

import static java.lang.Double.NaN;
import static java.lang.Double.valueOf;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String[] operazioni = {"1) Somma (+)",
                    "2) Sottrazione (-)",
                    "3) Moltiplicazione (*)",
                    "4) Divisione (/)",
                    "5) Potenza (^)",
                    "6) Pari o dispari (%)",
                    "0) Termina programma"};

            System.out.println("Seleziona l'operazione che vuoi eseguire scrivendo il rispettivo numero e premendo INVIO.");
            for (String operazione : operazioni) {
                System.out.println(operazione);
            }

            System.out.println("RISULTATO: " + scegliOperazione(chiediInputMenu()));
        }
    }

    /*divide due numeri dati come input e restituisce il quoziente e il resto.
      In caso il secondo numero inserito sia zero, restituisce NaN.
     */
    public static double[] divisione(double num1, double num2) {
        double[] result = new double[2];
        if (num2 != 0) {
            result[0] = num1 / num2;
            result[1] = num1 % num2;
        } else {
            result[0] = NaN;
            result[1] = NaN;
        }
        return result;
    }

    //Per poter determinare se anche un numero decimale è pari o dispari, la funzione converte il parametro
    // che passo alla funzione in stringa, dopodichè la funzione prende l'ultimo carattere di
    //questa stringa che verrà riconvertito in numero.
    public static String determinaPariODispari(double num1) {
        if (Character.getNumericValue((Double.toString(num1)).charAt(Double.toString(num1).length() - 1)) % 2 == 0) {
            return "Pari";
        } else {
            return "Dispari";
        }
    }

    public static double sottrazione(double num1, double num2) {
        return num1 - num2;
    }

    public static double somma(double num1, double num2) {
        return num1 + num2;
    }

    public static double moltiplicazione(double num1, double num2) {
        return num1 * num2;
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