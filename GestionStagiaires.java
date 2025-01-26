
import java.util.ArrayList;

public class GestionStagiaires implements Gestion<Stagiaire> {
    private ArrayList<Stagiaire> stagiaires;

    public GestionStagiaires() {
        this.stagiaires = new ArrayList<>();
    }

    @Override
    public void ajouter(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
        System.out.println("Stagiaire ajouté avec succès !");
    }

    @Override
    public void supprimer(String nom) {
        stagiaires.removeIf(stagiaire -> stagiaire.getNom().equalsIgnoreCase(nom));
        System.out.println("Stagiaire supprimé si trouvé.");
    }

    @Override
    public void afficher() {
        if (stagiaires.isEmpty()) {
            System.out.println("Aucun stagiaire à afficher.");
        } else {
            for (Stagiaire s : stagiaires) {
                s.afficherInfos();
            }
        }
    }

    public Stagiaire rechercherParNom(String nom) {
        for (Stagiaire s : stagiaires) {
            if (s.getNom().equalsIgnoreCase(nom)) {
                return s;
            }
        }
        return null;
    }
}