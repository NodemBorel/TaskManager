import java.sql.*;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/task";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connexion établie !");

            int pageNumber = 1;
            int pageSize = 10;
            int offset = (pageNumber - 1) * pageSize;
            String query = "SELECT * FROM Taches LIMIT ? OFFSET ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, offset);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Tâche: " + rs.getString("titre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}