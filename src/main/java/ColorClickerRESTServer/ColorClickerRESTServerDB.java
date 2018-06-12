package ColorClickerRESTServer;

import Models.Player;
import WebsocketModels.SaveScore;

import java.sql.*;

public class ColorClickerRESTServerDB {
    private Connection conn;

    private Connection Connection() {
        try {
            conn = DriverManager.getConnection("mssql.fhict.local", "dbi359176", "Subzamboo2");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public String[][] getHighscores() {
        conn = Connection();
        String[][] highscores = new String[3][];
        int r = 1;
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT  score,username,gameType FROM highscores;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                highscores[1][r] = String.valueOf(rs.getInt("score"));
                highscores[2][r] = rs.getString("username");
                highscores[3][r] = rs.getString("gameType");
                r++;
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
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("username");
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
            String query = "SELECT count() FROM users WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerId);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("total");
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
            String query = "SELECT count() FROM users WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("total");
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