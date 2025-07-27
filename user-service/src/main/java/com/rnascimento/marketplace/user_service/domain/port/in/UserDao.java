package com.rnascimento.marketplace.user_service.domain.port.in;

import com.rnascimento.marketplace.user_service.domain.model.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    boolean delete(Long id);
}

