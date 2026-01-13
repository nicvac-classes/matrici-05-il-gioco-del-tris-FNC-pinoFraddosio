//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    //Input da tastiera
    static Scanner in = new Scanner(System.in);
    
    //Inserisce il simbolo x oppure o nella grigla di gioco in riga i e colonna j.
    //Se la mossa non è valida (pedina già presente o le coordinate sono fuori la griglia) allora ritorno falso.
    static boolean inserisciInGriglia(String[][] board, int i, int j, String s) {
        boolean ok = false;
        --i;
        --j;
        
        ok = (0 <= i && i <= 2 && 0 <= j && j <= 2 && board[i][j].equals("-"));

        if(ok){
            board[i][j] = s;
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
    
        for(int i = 0; i < 3; i++){
            if (
                (s.equals(board[i][0]) && s.equals(board[i][1]) && s.equals(board[i][2])) ||
                (s.equals(board[0][i]) && s.equals(board[1][i]) && s.equals(board[2][i]))
            ) {
                return true;
            }
        }

        if (
            (s.equals(board[0][0]) && s.equals(board[1][1]) && s.equals(board[2][2])) ||
            (s.equals(board[2][0]) && s.equals(board[1][1]) && s.equals(board[0][2]))
        ) {
            return true;
        }

        return false;
    }
    

    //Conta quante caselle libere ci sono ancora.
    //Se non ci sono caselle libere e non si è vinto allora è un pareggio
    static int contaCaselleLibere(String[][] board) {
        int c = 0;

        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(board[i][j].equals("-")){
                    ++c;
                }
            }
        }

        return c;
    }


    public static void main(String args[]) {

        String[][] board = new String[3][3];

        azzeraGriglia(board, 3, 3);

        System.out.println("Il gioco del tris");
        UtilsMatrice.visualizza(board);

        String s = "X";

        boolean vittoria = false;
        boolean pareggio = false;

        do{

            boolean checkMossa;
            int mossaR;
            int mossaC;

            do{
                System.out.print("Giocatore " + s + ", inserire la colonna e la riga [1-3]: ");
                mossaR = Integer.parseInt(in.nextLine());
                mossaC = Integer.parseInt(in.nextLine());
                checkMossa = inserisciInGriglia(board, mossaR, mossaC, s);
            }while(!checkMossa);

            System.out.println("Stato griglia dopo mossa: ");
            UtilsMatrice.visualizza(board);

            vittoria = controllaVincita(board, s);
            if(vittoria){
                System.out.println("Il giocatore " + s + " ha vinto la partita!");   
            }

            int cont = contaCaselleLibere(board);
            pareggio = !(vittoria) && (cont == 0);

            if(pareggio){
                System.out.println("La partita finisce in pareggio!");
            }

            if(s.equals("X")){
                s = "O";
            }else{
                s = "X";
            }

        }while(!vittoria && !pareggio);
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md