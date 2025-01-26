public class Stagiaire extends Personne {
    private String niveauEtude;

    public Stagiaire(String nom, String prenom, String niveauEtude) {
        super(nom, prenom);
        this.niveauEtude = niveauEtude;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Stagiaire: " + nom + " " + prenom + ", Niveau d'étude: " + niveauEtude);
    }
}