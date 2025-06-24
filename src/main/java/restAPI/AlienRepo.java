package restAPI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepo {

    private Connection con;

    public AlienRepo() {
        String url = "jdbc:mysql://localhost:3306/restdb";
        String username = "root";
        String password = "MYSQL@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public List<Alien> getAliens() {
        List<Alien> aliens = new ArrayList<>();
        String sql = "SELECT * FROM alien";

        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Alien a = new Alien();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setPoint(rs.getInt("points"));
                aliens.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching aliens: " + e.getMessage());
        }

        return aliens;
    }

    public Alien getAlien(int id) {
        String sql = "SELECT * FROM alien WHERE id = ?";
        Alien a = new Alien();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setName(rs.getString("name"));
                    a.setPoint(rs.getInt("points"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching alien by ID: " + e.getMessage());
        }

        return a;
    }

    public void create(Alien a1) {
        String sql = "INSERT INTO alien (id, name, points) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, a1.getId());
            ps.setString(2, a1.getName());
            ps.setInt(3, a1.getPoint());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting alien: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
}
