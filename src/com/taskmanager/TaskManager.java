package com.taskmanager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public void createTache(Tache tache) throws SQLException{
        String query = "INSERT INTO Taches(titre, description, date_echeance, priorite, statut_id, categorie_id, utilisateur_id)"+"VALUES(?,?,?,?,?,?,?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)
        ){
            statement.setString(1, tache.getTitre());
            statement.setString(2, tache.getDescription());
            statement.setDate(3, Date.valueOf(tache.getDate_echeance()));
            statement.setInt(4, tache.getPriorite());
            statement.setInt(5, tache.getStatut_id());
            statement.setInt(6, tache.getCategorie_id());
            statement.setInt(7, tache.getUtilisateur_id());
            statement.executeUpdate();
            System.out.println("Tache cree avec succes");
        }
    }

    public void updateTache(int id, Tache tache) throws SQLException{
        String query = "UPDATE Taches SET titre=?, description=?, date_echeance=?, priorite=? WHERE id=?";
        try(
                Connection conn =  DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)
        ){
            statement.setString(1,tache.getTitre());
            statement.setString(2, tache.getDescription());
            statement.setString(3, tache.getDate_echeance());
            statement.setInt(4, tache.getPriorite());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Tache mise a jour avec succes");
        }
    }

    public void deleteTache(int id) throws SQLException {
        String query = "DELETE FROM Taches WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Tache supprime avec succes !");
        }
    }

    public List<Tache> afficheTache(int page, int pageSize) throws SQLException{
        List<Tache> taches = new ArrayList<>();
        String query = "SELECT * FROM Taches LIMIT ? OFFSET ?";
        try (
                Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setInt(1, pageSize);
            statement.setInt(2, (page-1)*pageSize);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Tache tache = new Tache();
                tache.setId(rs.getInt("id"));
                tache.setTitre(rs.getString("titre"));
                tache.setDescription(rs.getString("description"));
                tache.setDate_echeance(rs.getString("date_echeance"));
                tache.setPriorite(rs.getInt("priorite"));
                taches.add(tache);
            }
        }
        return taches;
    }
}
