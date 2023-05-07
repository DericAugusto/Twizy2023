package com.example.utils;

import java.io.IOException;
import java.sql.*;

public class database {

    private String host;
    private String dbname;
    private String username;
    private String password;

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public database(String host, String dbname, String username, String password) {
        // Les informations de connexion à la base de données
        this.host = host;
        this.dbname = dbname;
        this.username = username;
        this.password = password;

        try {
            // Établir la connexion
            this.conn = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.dbname, this.username, this.password);
            System.out.println("Connected to DB");

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public ResultSet query(String query) {
        try {
            // Créer la requête SQL
            this.stmt = this.conn.createStatement();

            // Exécuter la requête
            this.rs = stmt.executeQuery(query);

            return this.rs;

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }

    public void updateDB(String query) throws SQLException {
        // Créer la requête SQL
        this.stmt = this.conn.createStatement();

        int rowsAffected = stmt.executeUpdate(query);
        System.out.println(rowsAffected + " ligne(s) insérée(s).");
    }

    public void closeAll() throws SQLException {
        this.conn.close();
        this.stmt.close();
        System.out.println("DB closed");
    }
}
