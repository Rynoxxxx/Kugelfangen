import GLOOP.*;
import java.lang.*;
public class Kugel{
    private GLKugel kugel;
    private Box dieBox;
    private Spielfeld feld;
    
    private double radius;
    private int index;
    private Kugel[] Kugeln;
    private boolean istAktiv;
    private double vX, vZ;
    private double xPos, zPos, xSpeed, zSpeed;

    public Kugel(Box pBox, double pRadius, int pIndex){
        radius = pRadius;
        index = pIndex;
            xPos = Math.random()*980-490;
            zPos = Math.random()*980-490;
            xSpeed = Math.random()*2-1;
            zSpeed = Math.random()*2-1;
            dieBox =pBox;
            if (Math.random()>0.5){
                if (Math.random()>0.5){
                    xPos=-490;
                }
                else{
                    xPos = 490;
                }
            }
            else{
                if (Math.random()>0.5){
                    zPos=-490;
                }
                else{
                    zPos = 490;
                }
            }
        kugel = new GLKugel(xPos, radius, zPos, radius);

    }
    public void getArray(Kugel[] pKugel){
        Kugeln =pKugel;
    }
    public void bewege(){

        if (kugel.gibX()>=500){
            xSpeed = xSpeed*-1;
        }

        if (kugel.gibX()<=-500){
            xSpeed = xSpeed*-1;
        }
        if (kugel.gibZ()>=500){
            zSpeed = zSpeed*-1;
        }
        if (kugel.gibZ()<=-500){
            zSpeed = zSpeed*-1;
        }
        kugel.verschiebe(xSpeed,0,zSpeed);
    }
    public boolean hit() {
        double distance = Math.sqrt(Math.pow(kugel.gibX() - dieBox.gibXBox(), 2) + Math.pow(kugel.gibY() - dieBox.gibYBox(), 2) + Math.pow(kugel.gibZ() - dieBox.gibZBox(), 2));
        if (distance<40) return true;
        else return false;
    }
    public void weg(){
        kugel.verschiebe(0,10000,0);
    }

    public void physics() {
        for (int i = 0; i > Kugeln.length; i++) {
            if (!(index == i)) {
                xSpeed = xSpeed*-1;
                zSpeed = zSpeed*-1;

            }
        }

    }


}
