package ColorClickerRESTServer;

import Models.Score;
import java.sql.*;
import java.util.ArrayList;

public class ColorClickerRESTServerDB {
    private Connection conn;

    private Connection Connection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://mssql.fhict.local;database=dbi359176;user=dbi359176;password=Subzamboo2");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public ArrayList<Score> getHighscores() {
        conn = Connection();
        ArrayList<Score> highscores = new ArrayList<>();
        int r = 1;
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT  score,username,gameType FROM highscores;";
            try(ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    highscores.add(new Score(rs.getString("username"), rs.getInt("score"), rs.getString("gameType")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return highscores;
    }

    public boolean setHighscores(String playerName, int score, String gametype) {
        conn = Connection();
        try {
            String query = "Insert into highscores (username, score, gameType) values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerName);
            stmt.setInt(2, score);
            stmt.setString(3, gametype);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return true;
    }

    public boolean registerPlayer(String playerId, String playerName) {
        conn = Connection();
        try {
            String query = "INSERT into users (userId, username) values (? ,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerId);
            stmt.setString(2, playerName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return true;
    }

    public String getPlayer(String playerId) {
        conn = Connection();
        try {
            String query = "SELECT username FROM users WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerId);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    return rs.getString("username");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return null;
    }

    public int checkIdAvailability(String playerId) {
        conn = Connection();
        try {
            String query = "SELECT count(*) FROM users WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerId);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return 0;
    }

    public int checkNameAvailability(String name) {
        conn = Connection();
        try {
            String query = "SELECT count(*) FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return 0;
    }

}