package voiture;

public class Voiture{
    private int vitesse = 10;
    private int position = 0;
    private int id;

    private static int ID = 0;

    public Voiture(int vitesse) {
        this.id = ID;
        ID += 1;
        this.vitesse = vitesse;
    }

    public void deplacement() {
        position += vitesse;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Voiture ID=" + getId() + ", vitesse=" + getVitesse() + ", position=" + getPosition();
    }
}
