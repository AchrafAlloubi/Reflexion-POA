package dynamique;

import voiture.Voiture;
import voiture.VoitureSport;
import java.lang.reflect.InvocationTargetException;
import static java.lang.Class.forName;


public class VoitureFactory {
    public enum ModeConstruction { INSTANCIATION, META, REFLEXION }

    public static Voiture buildVoiture(ModeConstruction mode, boolean sport, int vitesse) {

        switch (mode)
        {
            case INSTANCIATION:
                return buildVoitureInstanciation(sport, vitesse);
            case META:
                return VoitureFactoryMeta.buildVoitureMeta("MetaVoiture", sport, vitesse);
            case REFLEXION:
                return buildVoitureReflexion(sport,vitesse);
        }

        return null;
    }

    private static Voiture buildVoitureInstanciation(boolean sport, int vitesse) {
        return sport ? new VoitureSport():new Voiture(vitesse);
    }

    private static Voiture buildVoitureReflexion(boolean sport, int vitesse) {
        Voiture voiture = null;

        if (sport) {

            Class classVoitureSport = null;

            try {
                classVoitureSport = forName("voiture.VoitureSport");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {

                assert classVoitureSport != null;
                voiture = (VoitureSport) classVoitureSport.getDeclaredConstructor().newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        else {

            Class classVoiture = null;

            try {
                classVoiture = forName("voiture.Voiture");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                voiture = (Voiture) classVoiture.getDeclaredConstructor(int.class).newInstance(vitesse);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return voiture;
    }
}
