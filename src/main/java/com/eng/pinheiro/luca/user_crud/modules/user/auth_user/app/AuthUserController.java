package com.eng.pinheiro.luca.user_crud.modules.user.auth_user.app;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.pinheiro.luca.user_crud.shared.infra.dto.AuthUserRequestDTO;

@RestController
@RequestMapping("/candidate")
public class AuthUserController {

    @Autowired
    private AuthUserUsecase authUserUsecase;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthUserRequestDTO authCandidateRequestDTO) {
        try {
            this.authUserUsecase.execute(authCandidateRequestDTO);

            return ResponseEntity.ok("OK");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
