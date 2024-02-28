public class Main {

    public static void main(String[] args) {

    }
    //Per poter determinare se anche un numero decimale è pari o dispari, la funzione converte il parametro
    // che passo alla funzione in stringa, dopodichè la funzione prende l'ultimo carattere di
    //questa stringa che verrà riconvertito in numero.
    public static String determinaPariODispari (double num1){
        if (Character.getNumericValue((Double.toString(num1)).charAt(Double.toString(num1).length() - 1)) % 2 == 0){
            return "Pari";
        } else {
            return "Dispari";
        }
    }

}
