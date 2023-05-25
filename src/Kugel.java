import GLOOP.*;
import java.lang.*;
public class Kugel{
    public GLKugel kugel;
    private Box dieBox;
    private Spielfeld feld;
    
    private double radius;
    private int index;
    private Kugel[] Kugeln;
    private boolean istAktiv;
    private double vX, vZ;
    private double xPos, zPos, xSpeed, zSpeed, tempSpeedX, tempSpeedZ;

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

    //----------------bewegung----------------------

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

    //-------------------loch und kugel---------------------------

    public boolean hit() {
        double distance = Math.sqrt(Math.pow(kugel.gibX() - dieBox.gibXBox(), 2) + Math.pow(kugel.gibY() - dieBox.gibYBox(), 2) + Math.pow(kugel.gibZ() - dieBox.gibZBox(), 2));
        if (distance<dieBox.radius+this.radius) return true;
        else return false;
    }
    public void weg(){
        kugel.verschiebe(0,100000,0);
    }

    //-----------------kugeln treffen kugeln---------------------------

    public void physics() {
        for (int i = 0; i < Kugeln.length; i++) {
            if (!(index == i)) {
                double d = Math.sqrt(Math.pow(kugel.gibX()-Kugeln[i].gibX(),2))+Math.sqrt(Math.pow(kugel.gibZ()-Kugeln[i].gibZ(),2))+Math.sqrt(Math.pow(kugel.gibY()-Kugeln[i].gibY(),2));
                if (d<radius*2){
                    tempSpeedX = xSpeed;
                    tempSpeedZ = zSpeed;
                    this.xSpeed = Kugeln[i].getSpeedX();
                    this.zSpeed = Kugeln[i].getSpeedZ();
                    Kugeln[i].setSpeedX(tempSpeedX);
                    Kugeln[i].setSpeedZ(tempSpeedZ);
                }
            }
        }
    }
    public double getSpeedX(){
        return xSpeed;
    }
    public double getSpeedZ(){
        return zSpeed;
    }
    public void setSpeedX(double pSpeedX){
        this.xSpeed = pSpeedX;
    }
    public void setSpeedZ(double pSpeedZ){
        this.zSpeed = pSpeedZ;
    }

    public double gibX(){
        return kugel.gibX();
    }
    public double gibZ(){
        return kugel.gibZ();
    }
    public double gibY(){
        return kugel.gibY();
    }


    //---------------falls außerhalb------------------------


    public void ausFeld() {

            if (((kugel.gibX() > 502.5 || kugel.gibX() < -502.5 || kugel.gibZ() > 502.5 || kugel.gibZ() < -502.5))&&kugel.gibY()<100) {
                kugel.setzePosition(0, radius, 0);
            }
        }

}

