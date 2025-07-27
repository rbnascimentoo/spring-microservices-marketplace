package com.rnascimento.marketplace.user_service.infrastructure.adapter.out;

import com.rnascimento.marketplace.user_service.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

