import GLOOP.*;
public class Spielfeld{
    private GLQuader untergrund,rand1,rand2,rand3,rand4;
    private double breite, tiefe;

    public Spielfeld(double pBreite, double pTiefe){
        breite = pBreite;
        tiefe = pTiefe;
        untergrund = new GLQuader(0,-10,0, breite,20,tiefe);
        untergrund.setzeTextur("src/img/Marmor.jpg");
        rand1 =new GLQuader(-510,0,0,20,40,1040);
        rand2 =new GLQuader(510,0,0,20,40,1040);
        rand3 =new GLQuader(0,0,510,1040,40,20);
        rand4 =new GLQuader(0,0,-510,1040,40,20);
        rand1.setzeMaterial(GLMaterial.OBSIDIAN);
        rand2.setzeMaterial(GLMaterial.OBSIDIAN);
        rand3.setzeMaterial(GLMaterial.OBSIDIAN);
        rand4.setzeMaterial(GLMaterial.OBSIDIAN);
    }

}
