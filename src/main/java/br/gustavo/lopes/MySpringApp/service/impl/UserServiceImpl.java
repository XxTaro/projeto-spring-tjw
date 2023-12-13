package br.gustavo.lopes.MySpringApp.service.impl;

import br.gustavo.lopes.MySpringApp.model.User;
import br.gustavo.lopes.MySpringApp.repository.UserRepository;
import br.gustavo.lopes.MySpringApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editById(long id, User user) {
        User userToEdit = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userToEdit.setName(user.getName());
        userToEdit.setEmail(user.getEmail());
        userToEdit.setPassword(user.getPassword());
        return userRepository.save(userToEdit);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
