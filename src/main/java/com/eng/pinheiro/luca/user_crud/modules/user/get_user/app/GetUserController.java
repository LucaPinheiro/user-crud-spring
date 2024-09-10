package com.eng.pinheiro.luca.user_crud.modules.user.get_user.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.pinheiro.luca.user_crud.shared.entities.User;

@RestController
@RequestMapping("/users")
public class GetUserController {

    @Autowired
    private GetUserUseCase getUserUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        Optional<User> user = getUserUseCase.execute(id);

        // Verifica se o usuário foi encontrado
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
