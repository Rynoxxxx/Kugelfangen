import GLOOP.*;
public class Box{
    public GLZylinder box;
    private Spielfeld feld;
    private double vX,vZ;
    public double breite, tiefe, radius;

    public Box(double pradius, double ptiefe) {
        radius = pradius;
        tiefe = ptiefe;
        box= new GLZylinder(0,5,0,radius,tiefe);
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
