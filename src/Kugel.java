import GLOOP.*;
import java.lang.*;
public class Kugel{
    private GLKugel kugel;
    private Box dieBox;
    private Spielfeld feld;
    
    private double radius;
    private boolean istAktiv;
    private double vX, vZ;
    private double xPos, zPos, xSpeed, zSpeed;

    public Kugel(Box pBox, double pRadius){
        radius = pRadius;
            xPos = Math.random()*980-490;
            zPos = Math.random()*980-490;
            xSpeed = Math.random()*2-1;
            zSpeed = Math.random()*2-1;
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
    public void bewege(){

        if (xPos>=500){
            xSpeed = xSpeed*-1;
        }
        if (xPos<=-500){
            xSpeed = xSpeed*-1;
        }
        if (zPos>=500){
            zSpeed = zSpeed*-1;
        }
        if (zPos<=-500){
            zSpeed = zSpeed*-1;
        }
        kugel.verschiebe(xSpeed,0,zSpeed);
    }




}
