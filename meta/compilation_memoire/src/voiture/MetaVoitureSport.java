package voiture;

public class MetaVoitureSport extends VoitureSport implements Surveillable, Meta {
    public MetaVoitureSport() { super(); }

    @Override
    public int surveiller(int limite) {
        return getVitesse() - limite;
    }
}
