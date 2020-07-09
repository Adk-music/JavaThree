package ru.gb.jt.chat.server.core;

import java.sql.*;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement psChangeNick;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat.db");
            statement = connection.createStatement();
            psChangeNick = connection.prepareStatement("UPDATE users SET nickname = ? WHERE nickname = ? ;");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static String getNickname(String login, String password) {
        String query = String.format("select nickname from users where login='%s' and password='%s'", login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next())
                return set.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean changeNickname(String oldNickname, String newNickname){
        try{
            statement.executeUpdate("UPDATE users SET nickname = ' " + newNickname +
                    "WHERE nickname = ' " + oldNickname + ";");
            return true;
        } catch (SQLException e){
            return false;
        }
    }

}
