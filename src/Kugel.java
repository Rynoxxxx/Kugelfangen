import GLOOP.*;
import java.lang.*;
public class Kugel{
    private GLKugel kugel;
    private Box dieBox;
    private Spielfeld feld;
    
    private double radius;
    private boolean istAktiv;
    private double vX, vZ;
    private double xPos, zPos;

    public Kugel(Box pBox, double pRadius){
        radius = pRadius;
        do {
             xPos = Math.random()*1000-500;
        }while(Math.abs(xPos)<490);
        do {
            zPos = Math.random()*1000-500;
        }while(Math.abs(zPos)<490);
        kugel = new GLKugel(xPos, radius, zPos, radius);
    }


}
