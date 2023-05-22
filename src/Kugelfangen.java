import GLOOP.*;
public class
Kugelfangen {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;

    private Box dieBox;
    private Spielfeld spielfeld;
    private Kugel[] dieKugel;

    public Kugelfangen() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        tastatur = new GLTastatur();

        spielfeld = new Spielfeld(1000, 1000);
        dieBox = new Box(40, 5);
        dieKugel = new Kugel[50];
        for( int i=0; i < dieKugel.length; i++){
            dieKugel[i] = new Kugel(dieBox, 10, i);
        }
        for( int i=0; i < dieKugel.length; i++){
           dieKugel[i].getArray(dieKugel);
        }
        fuehreAus();

    }
    //----------------Start-----------------------
    public void fuehreAus() {
        while (0 == 0) {
            Steureung();
            for( int i=0; i < dieKugel.length; i++) {

                dieKugel[i].bewege();
                dieKugel[i].physics();
                if(dieKugel[i].hit()){
                    dieKugel[i].weg();
                }
            }


            Sys.warte(1);
        }

    }
    //-----------------------------Steuerung------------------------

    public void Steureung(){
        if ((tastatur.istGedrueckt('a'))&&(dieBox.gibXBox()>-460)) {
            dieBox.bewegeLinks();
        }
        if ((tastatur.istGedrueckt('d'))&&(dieBox.gibXBox()<460)) {
            dieBox.bewegeRechts();
        }
        if ((tastatur.istGedrueckt('w'))&&(dieBox.gibZBox()>-460)) {
            dieBox.bewegeOben();
        }
        if ((tastatur.istGedrueckt('s'))&&(dieBox.gibZBox()<460)) {
            dieBox.bewegeUnten();}

    }
}

