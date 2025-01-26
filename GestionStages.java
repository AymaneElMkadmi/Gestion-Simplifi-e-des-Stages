import java.util.ArrayList;

public class GestionStages implements Gestion<Stage> {
    ArrayList<Stage> stages;

    public GestionStages() {
        this.stages = new ArrayList<>();
    }

    @Override
    public void ajouter(Stage stage) {
        stages.add(stage);
        System.out.println("Stage ajouté avec succès !");
    }

    @Override
    public void supprimer(String titre) {
        stages.removeIf(stage -> stage.getTitre().equalsIgnoreCase(titre));
        System.out.println("Stage supprimé si trouvé.");
    }

    @Override
    public void afficher() {
        if (stages.isEmpty()) {
            System.out.println("Aucun stage à afficher.");
        } else {
            for (Stage s : stages) {
                s.afficherStage();
            }
        }
    }

    public int calculerNombreStages() {
        return stages.size();
    }
}
