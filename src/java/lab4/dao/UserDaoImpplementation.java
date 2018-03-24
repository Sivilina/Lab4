/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lab4.entities.User;
import lab4.queries.UserQueries;

/**
 *
 * @author strogiy.otec
 */
@ApplicationScoped
public class UserDaoImpplementation implements UserDao {

    @Inject
    private UserQueries queries;

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return queries.selectUserByLoginAndPassword(login, password);
    }

}
