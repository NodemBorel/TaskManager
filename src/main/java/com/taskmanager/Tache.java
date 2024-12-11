package com.taskmanager;

public class Tache {
    private int id;
    private String titre;
    private String description;
    private String date_echeance;
    private int priorite;
    private int statut_id;
    private int categorie_id;
    private int utilisateur_id;

    public Tache(){}

    public Tache(String titre, String description, String date_echeance, int priorite, int statut_id, int categorie_id, int utilisateur_id){
        this.titre = titre;
        this.description = description;
        this.date_echeance = date_echeance;
        this.priorite = priorite;
        this.statut_id = statut_id;
        this.categorie_id = categorie_id;
        this.utilisateur_id = utilisateur_id;
    }

    public int getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(int statut_id) {
        this.statut_id = statut_id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_echeance() {
        return date_echeance;
    }

    public void setDate_echeance(String date_echeance) {
        this.date_echeance = date_echeance;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }
}
