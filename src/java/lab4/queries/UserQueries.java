/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.queries;

import lab4.entities.User;

/**
 *
 * @author strogiy.otec
 */
public interface UserQueries {

    User selectUserByLoginAndPassword(final String login, final String password);
}
