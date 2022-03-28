package voiture;

public class MetaVoiture extends Voiture implements Surveillable, Meta{

    public MetaVoiture(int vitesse) {
        super(vitesse);
    }

    @Override
    public int surveiller(int limite) {
        return getVitesse() - limite;
    }
}
