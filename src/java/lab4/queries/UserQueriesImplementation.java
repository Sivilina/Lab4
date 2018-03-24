/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import lab4.entities.User;

/**
 *
 * @author strogiy.otec
 */
@RequestScoped
public class UserQueriesImplementation implements UserQueries {

    private Connection connection;
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Lab4";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static final String SELECT_QUERY = "select * from users where users.login = ? and users.password = ?";
    private static final String SELECT_ALL_QUERY = "select * from users";

    @PostConstruct
    private void init() {
        long before = System.currentTimeMillis();
        System.out.println("INIT CONNECTOR");         
            connection = DataBaseConnection.getConnection();
            long after = System.currentTimeMillis();
            System.out.println("Time: " + (after - before));
        
    }

    @PreDestroy
    private void destroy() {
        System.out.println("DESTROY connector");
        try {
            if (connection != null) {
                connection.close();
                System.out.println("CLOSED");
            }
        } catch (final SQLException ex) {
            ex.printStackTrace(); // NO need to throw exception into front end side
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (final SQLException ex) {
                    Logger.getLogger(UserQueriesImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public User selectUserByLoginAndPassword(final String login, final String password) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_QUERY)) {
            st.setString(1, login);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                final User user = User.newBuilder()
                        .setId(result.getInt("id"))
                        .setAge(result.getInt("age"))
                        .setName(result.getString("name"))
                        .setPassword(result.getString("password"))
                        .setLogin(login)
                        .build();
                return user;

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        throw new NullPointerException("Nu such user in db");
    }

}
