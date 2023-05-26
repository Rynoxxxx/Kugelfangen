import GLOOP.*;
public class
Kugelfangen {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;
    private GLTafel counter, ende;
    private Box dieBox;
    private Spielfeld spielfeld;
    private Kugel[] dieKugel;
    public int points;

    public Kugelfangen() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        tastatur = new GLTastatur();

        spielfeld = new Spielfeld(1000, 1000);
        dieBox = new Box(40, 5);
        dieKugel = new Kugel[50];
        ende = new GLTafel(0,100,-500,200,120);
        ende.setzeSichtbarkeit(false);
        ende.setzeText("GEWONNEN",100);
        counter = new GLTafel(0,100,-500,200,120);
        for( int i=0; i < dieKugel.length; i++){
            dieKugel[i] = new Kugel(dieBox, 10, i);
        }
        for( int i=0; i < dieKugel.length; i++){
           dieKugel[i].getArray(dieKugel);
            dieKugel[i].kugel.setzeMaterial(GLMaterial.CHROM);
        }
        points=0;
        fuehreAus();

    }
    //----------------Start-----------------------
    public void fuehreAus() {
        while (0 == 0) {
            Steureung();
            for( int i=0; i < dieKugel.length; i++) {

                dieKugel[i].bewege();
                dieKugel[i].physics();
                dieKugel[i].ausFeld();
                if(dieKugel[i].hit()){
                    dieBox.box.skaliere(1.03,1.03,1);
                    dieBox.radius= dieBox.radius*1.03;
                    dieKugel[i].weg();

                    counter.setzeText("Punkte:"+points,100);
                    points=points+1;

                    }
                }
            if(points == 50) {
                counter.setzeSichtbarkeit(false);
                ende.setzeSichtbarkeit(true);
                Sys.warte(3000);
                Sys.beenden();
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

