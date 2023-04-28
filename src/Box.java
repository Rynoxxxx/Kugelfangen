import GLOOP.*;
public class Box{
    private GLZylinder box;
    private Spielfeld feld;
    private double vX,vZ;
    private double breite, tiefe;

    public Box(double pbreite , double ptiefe) {
        breite = pbreite;
        tiefe = ptiefe;
        box= new GLZylinder(0,10,0,breite,tiefe);
        box.drehe(90,0,0);
    }
    //Steuerung-------------------------------------------------
    public void bewegeLinks(){
        box.verschiebe(-1, 0, 0);
    }
    public void bewegeRechts(){
        box.verschiebe(1, 0, 0);
    }
    public void bewegeOben() {
        box.verschiebe(0, 0, -1);
    }
    public void bewegeUnten(){
        box.verschiebe(0, 0, 1);
    }
    //Gub Position---------------------------------------------
    public double gibXBox(){
        return box.gibX();
    }
    public double gibYBox(){
        return box.gibY();
    }
    public double gibZBox(){
        return box.gibZ();
    }

}
