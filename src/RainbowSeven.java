public class RainbowSeven {

    public static void main(String[] args) {

        boolean finePartita = false;
        int azione;

        Impostazioni mappa = new Impostazioni();
        mappa.creaMappa(10, 10, 4, 2);
        Giocatore giocatore1 = new Giocatore(1);
        Giocatore giocatore2 = new Giocatore(2);

        giocatore1.posizionaGiocatore();
        giocatore2.posizionaGiocatore();

        System.out.println("\n");
        mappa.visualizzaMappa();
        System.out.println("\n");

        while (!finePartita) {

            do {
                do {
                    System.out.println("Turno giocatore 1");
                    System.out.println("Seleziona azione: ");
                    System.out.println("[1] Muovi su ");
                    System.out.println("[2] Muovi giu ");
                    System.out.println("[3] Muovi dx ");
                    System.out.println("[4] Muovi sx ");
                    System.out.println("[5] Spara ");

                    java.util.Scanner myInput = new java.util.Scanner(System.in);

                    azione = myInput.nextInt();
                    if (azione < 1 && azione > 5) {
                        System.out.println("Errore di selezione!");
                    }
                }
                while (azione < 1 && azione > 5);


                switch (azione) {
                    case 1:
                        giocatore1.muoviSu();
                        break;
                    case 2:
                        giocatore1.muoviGiu();
                        break;
                    case 3:
                        giocatore1.muoviDestra();
                        break;
                    case 4:
                        giocatore1.muoviSinistra();
                        break;
                    case 5:
                        giocatore1.spara();
                        break;
                }
            }
            while (giocatore1.error);

            do {
                do {
                    System.out.println("Turno giocatore 2");
                    System.out.println("Seleziona azione: ");
                    System.out.println("[1] Muovi su ");
                    System.out.println("[2] Muovi giu ");
                    System.out.println("[3] Muovi dx ");
                    System.out.println("[4] Muovi sx ");
                    System.out.println("[5] Spara ");

                    java.util.Scanner myInput = new java.util.Scanner(System.in);

                    azione = myInput.nextInt();
                    if (azione < 1 && azione > 5) {
                        System.out.println("Errore di selezione!");
                    }
                }
                while (azione < 1 && azione > 5);


                switch (azione) {
                    case 1:
                        giocatore2.muoviSu();
                        break;
                    case 2:
                        giocatore2.muoviGiu();
                        break;
                    case 3:
                        giocatore2.muoviDestra();
                        break;
                    case 4:
                        giocatore2.muoviSinistra();
                        break;
                    case 5:
                        giocatore2.spara();
                        break;
                }
            }
            while (giocatore1.error);

            if (giocatore1.posizioneX == giocatore2.posizioneX || giocatore1.posizioneY == giocatore2.posizioneY) {
                if (giocatore1.spara()) {
                    giocatore2.colpito();
                } else if (giocatore2.spara()) {
                    giocatore1.colpito();
                }
            }

            mappa.visualizzaMappa();
            System.out.println("\n");

            System.out.println("Giocatore 1: ");
            giocatore1.statoGiocatore();
            System.out.println("\n");
            System.out.println("Giocatore 2: ");
            giocatore2.statoGiocatore();
            System.out.println("\n");

            System.out.println("Numero di giocatori: " + Impostazioni.numGiocatori());
            System.out.println("\n");

            if (Impostazioni.numGiocatori() < 2) {
                finePartita = true;
            }
        }
    }
}
