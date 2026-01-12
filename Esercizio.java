//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    //Input da tastiera
    static Scanner input = new Scanner(System.in);
    
    //Inserisce il simbolo x oppure o nella grigla di gioco in riga i e colonna j.
    //Se la mossa non è valida (pedina già presente o le coordinate sono fuori la griglia) allora ritorno falso.
    static boolean inserisciInGriglia(String[][] board, int i, int j, String s) {
        boolean ok = false;
        --i;
        --j;
        
        ok = (0 <= i && i <= 2 && 0 <= j && j <= 2 && board[i][j].equals("-"));

        if(ok){
            board[i][j] = "s";
        }

        return ok;
    }

    //Azzero la griglia di gioco inserendo la stringa "-" in tutte le celle.
    static void azzeraGriglia(String[][] board, int r, int c) {
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                board[i][j] = "-";
            }
       }
    }

    //Controlla se nella griglia c'è una vincita.
    // s può valore "O" oppure "X"
    static boolean controllaVincita(String[][] board, String s) {
        boolean ok = false;
        ok = (
                (board[0][0].equals(s) && board[0][1].equals(s) && board[0][2].equals(s)) || 
                (board[1][0].equals(s) && board[1][1].equals(s) && board[1][2].equals(s)) ||
                (board[2][0].equals(s) && board[2][1].equals(s) && board[2][2].equals(s)) ||
                (board[0][0].equals(s) && board[1][0].equals(s) && board[2][0].equals(s)) ||
                (board[0][1].equals(s) && board[1][1].equals(s) && board[2][1].equals(s)) ||
                (board[0][2].equals(s) && board[1][2].equals(s) && board[2][2].equals(s)) ||
                (board[3][0].equals(s) && board[1][1].equals(s) && board[0][2].equals(s)) ||
                (board[0][0].equals(s) && board[1][1].equals(s) && board[2][2].equals(s))
            );

        return ok;
    }

    //Conta quante caselle libere ci sono ancora.
    //Se non ci sono caselle libere e non si è vinto allora è un pareggio
    static int contaCaselleLibere(/*scrivere qui i parametri richiesti dall'esercizio*/ ) {
        //SCRIVERE QUI IL CODICE RICHIESTO DALL'ESERCIZIO
    }


    public static void main(String args[]) {
        //SCRIVERE QUI IL CODICE RICHIESTO DALL'ESERCIZIO  
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md