public class Giocatore {
    public static int[] giocatoreN = new int[Impostazioni.numGiocatori];
    public int k;
    public int posizioneX;
    public int posizioneY;
    public boolean spara = false;
    public boolean vivo = true;
    public int numVite = 2;
    //public boolean colpito = false;
    boolean error = false;

    public Giocatore(int giocatoreN) {
        this.giocatoreN[giocatoreN - 1] = giocatoreN;
        this.k = giocatoreN;
    }

    void posizionaGiocatore() {

        boolean posizionato = false;

        while (!posizionato) {
            int posizioneX, posizioneY;
            java.util.Scanner myInput = new java.util.Scanner(System.in);

            System.out.println("Posizione X del giocatore " + (giocatoreN[this.k - 1]));
            posizioneX = myInput.nextInt();
            this.posizioneX = posizioneX;
            System.out.println("Posizione Y del giocatore " + (giocatoreN[this.k - 1]));
            posizioneY = myInput.nextInt();
            this.posizioneY = posizioneY;

            if ((this.posizioneX > Impostazioni.dimensioneX) || (this.posizioneY > Impostazioni.dimensioneY)) {
                System.out.println("INPUT INVALIDO!");
                this.error = true;
            } else {
                if ((Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].equals(Impostazioni.OSTACOLO)) || (Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].contains(Impostazioni.GIOCATORE))) {
                    System.out.println("INPUT INVALIDO!");
                    this.error = true;
                } else {
                    Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.GIOCATORE + (this.k);
                    posizionato = true;
                    this.error = false;
                }
            }
        }
    }

    void muoviSu() {
        // this.posizioneX
        this.posizioneY--;

        if ((this.posizioneX > Impostazioni.dimensioneX) || (this.posizioneY > Impostazioni.dimensioneY)) {
            System.out.println("INPUT INVALIDO!");
            this.error = true;
            // this.posizioneX
            this.posizioneY++;
        } else {
            if ((Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].equals(Impostazioni.OSTACOLO)) || (Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].contains(Impostazioni.GIOCATORE))) {
                System.out.println("INPUT INVALIDO!");
                // this.posizioneX
                this.error = true;
                this.posizioneY++;
            } else {
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.GIOCATORE + " " + (this.k);
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY] = Impostazioni.CASELLA_VUOTA;
                this.error = false;
                this.spara = false;
            }
        }
    }

    void muoviGiu() {
// this.posizioneX
        this.posizioneY++;

        if ((this.posizioneX > Impostazioni.dimensioneX) || (this.posizioneY > Impostazioni.dimensioneY)) {
            System.out.println("INPUT INVALIDO!");
            this.error = true;
            // this.posizioneX
            this.posizioneY--;
        } else {
            if ((Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].equals(Impostazioni.OSTACOLO)) || (Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].contains(Impostazioni.GIOCATORE))) {
                System.out.println("INPUT INVALIDO!");
                this.error = true;
                // this.posizioneX
                this.posizioneY--;
            } else {
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.GIOCATORE + " " + (this.k);
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 2] = Impostazioni.CASELLA_VUOTA;
                this.error = false;
                this.spara = false;
            }
        }
    }

    void muoviDestra() {
        this.posizioneX++;
        //this.posizioneY--;

        if ((this.posizioneX > Impostazioni.dimensioneX) || (this.posizioneY > Impostazioni.dimensioneY)) {
            System.out.println("INPUT INVALIDO!");
            this.error = true;
            this.posizioneX--;
            //this.posizioneY++;
        } else {
            if ((Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].equals(Impostazioni.OSTACOLO)) || (Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].contains(Impostazioni.GIOCATORE))) {
                System.out.println("INPUT INVALIDO!");
                this.error = true;
                this.posizioneX--;
                //this.posizioneY++;
            } else {
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.GIOCATORE + " " + (this.k);
                Impostazioni.griglia[this.posizioneX - 2][this.posizioneY - 1] = Impostazioni.CASELLA_VUOTA;
                this.error = false;
                this.spara = false;
            }
        }
    }

    void muoviSinistra() {
        this.posizioneX--;
        //this.posizioneY--;

        if ((this.posizioneX > Impostazioni.dimensioneX) || (this.posizioneY > Impostazioni.dimensioneY)) {
            System.out.println("INPUT INVALIDO!");
            this.error = true;
            this.posizioneX++;
            //this.posizioneY++;
        } else {
            if ((Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].equals(Impostazioni.OSTACOLO)) || (Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1].contains(Impostazioni.GIOCATORE))) {
                System.out.println("INPUT INVALIDO!");
                this.error = true;
                this.posizioneX++;
                //this.posizioneY++;
            } else {
                Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.GIOCATORE + " " + (this.k);
                Impostazioni.griglia[this.posizioneX][this.posizioneY - 1] = Impostazioni.CASELLA_VUOTA;
                this.error = false;
                this.spara = false;
            }
        }
    }

    boolean spara() {
        return this.spara = true;
    }

    void statoGiocatore() {
        System.out.println("Numero di vite: " + this.numVite);
        System.out.println("Posizione X: " + this.posizioneX);
        System.out.println("Posizione Y: " + this.posizioneY);

        if (this.numVite > 0) {
            this.vivo = true;
            System.out.println("Vivo: SI");
        } else {
            this.vivo = false;
            Impostazioni.numGiocatori--;
            Impostazioni.griglia[this.posizioneX - 1][this.posizioneY - 1] = Impostazioni.CASELLA_VUOTA;
            System.out.println("Vivo: NO");
        }
    }

    void colpito() {
        this.numVite--;
    }
}




