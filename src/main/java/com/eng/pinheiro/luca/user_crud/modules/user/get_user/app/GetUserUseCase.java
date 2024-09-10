package com.eng.pinheiro.luca.user_crud.modules.user.get_user.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.pinheiro.luca.user_crud.shared.entities.User;
import com.eng.pinheiro.luca.user_crud.shared.UserRepository;

@Service
public class GetUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> execute(String userId) {
        UUID userUUID = UUID.fromString(userId);
        return userRepository.findById(userUUID);
    }
}
