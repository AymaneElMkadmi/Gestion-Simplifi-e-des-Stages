
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        GestionStagiaires gestionStagiaires = new GestionStagiaires();
        GestionStages gestionStages = new GestionStages();
        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un stagiaire");
            System.out.println("2. Supprimer un stagiaire");
            System.out.println("3. Afficher tous les stagiaires");
            System.out.println("4. Ajouter un stage");
            System.out.println("5. Associer un stagiaire à un stage");
            System.out.println("6. Afficher tous les stages avec stagiaires");
            System.out.println("7. Rechercher un stagiaire");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Niveau d'étude : ");
                    String niveau = scanner.nextLine();
                    gestionStagiaires.ajouter(new Stagiaire(nom, prenom, niveau));
                    break;

                case 2:
                    System.out.print("Nom du stagiaire à supprimer : ");
                    String nomSupprimer = scanner.nextLine();
                    gestionStagiaires.supprimer(nomSupprimer);
                    break;

                case 3:
                    gestionStagiaires.afficher();
                    break;

                case 4:
                    System.out.print("Titre du stage : ");
                    String titre = scanner.nextLine();
                    System.out.print("Durée (en jours) : ");
                    int duree = scanner.nextInt();
                    gestionStages.ajouter(new Stage(titre, duree));
                    break;

                case 5:
                    System.out.print("Nom du stagiaire : ");
                    String nomStagiaire = scanner.nextLine();
                    System.out.print("Titre du stage : ");
                    String titreStage = scanner.nextLine();
                    Stagiaire stagiaire = gestionStagiaires.rechercherParNom(nomStagiaire);
                    if (stagiaire != null) {
                        for (Stage stage : gestionStages.stages) {
                            if (stage.getTitre().equalsIgnoreCase(titreStage)) {
                                stage.ajouterStagiaire(stagiaire);
                                System.out.println("Stagiaire associé avec succès !");
                            }
                        }
                    } else {
                        System.out.println("Stagiaire ou stage introuvable.");
                    }
                    break;

                case 6:
                    gestionStages.afficher();
                    break;

                case 7:
                    System.out.print("Nom du stagiaire à rechercher : ");
                    String rechercheNom = scanner.nextLine();
                    Stagiaire resultat = gestionStagiaires.rechercherParNom(rechercheNom);
                    if (resultat != null) {
                        resultat.afficherInfos();
                    } else {
                        System.out.println("Stagiaire introuvable.");
                    }
                    break;

                case 8:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 8);

        scanner.close();
    }
}