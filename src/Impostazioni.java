public class Impostazioni {

    public final static String CASELLA_VUOTA = "  ";
    public final static String OSTACOLO = "##";
    public final static String GIOCATORE = "G";
    private static int numOstacoli;
    public static int dimensioneX;
    public static int dimensioneY;
    public static String[][] griglia;
    public static int numGiocatori;


    //void creaMappa(int dimensioneX, int dimensioneY, int numOstacoli, int numGiocatori)
    void creaMappa(int dimensioneX, int dimensioneY, int numOstacoli, int numGiocatori) {
        int i = 0;
        int j = 0;
        int k = 0;

        java.util.Random rd = new java.util.Random();
        this.numGiocatori = numGiocatori;
        this.griglia = new String[dimensioneX][dimensioneY];
        this.dimensioneX = dimensioneX;
        this.dimensioneY = dimensioneY;
        this.numOstacoli = numOstacoli;
        //this.numGiocatori = numGiocatori;

        //Crea la mappa e piazza gli ostacoli per un numero non superiore al numero di ostacoli impostati
        for (j = 0; j < this.dimensioneY; j++) {
            for (i = 0; i < this.dimensioneX; i++) {
                if (rd.nextBoolean() && numOstacoli > 0) {
                    this.griglia[i][j] = OSTACOLO;
                    numOstacoli--;
                } else {
                    this.griglia[i][j] = CASELLA_VUOTA;
                }
            }
            k = i - 1;
        }
    }

    //Questo metodo visualizza a display le celle della mappa in base se è presente un OSTACOLO, un GIOCATORE o una CASELLA VUOTA
    void visualizzaMappa() {
        int i = 0;
        int j = 0;
        int k = 0;

        for (j = 0; j < this.dimensioneY; j++) {
            for (i = 0; i < this.dimensioneX; i++) {
                System.out.print("|" + this.griglia[i][j] + "|");
                //System.out.print("|" + this.griglia[i][j] + "|\t");
            }
            k = i - 1;
            System.out.println("\n");
        }
    }

    //Visualizza il numero di giocatori nella mappa
    static int numGiocatori() {
        return numGiocatori;
    }

}
