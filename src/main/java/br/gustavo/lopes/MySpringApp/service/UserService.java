package br.gustavo.lopes.MySpringApp.service;

import br.gustavo.lopes.MySpringApp.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User findById(long id);
    User findByEmail(String email);
    List<User> findAll();
    User edit(User user);
    User editById(long id, User user);
    void delete(long id);

}
