package com.eng.pinheiro.luca.user_crud.modules.user.auth_user.app;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.pinheiro.luca.user_crud.shared.infra.dto.AuthUserRequestDTO;
import com.eng.pinheiro.luca.user_crud.shared.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthUserUsecase {

    @Autowired
    private UserRepository userRepository;

    public void execute(AuthUserRequestDTO authCandidateRequestDTO) throws AuthenticationException {
        var user = this.userRepository.findByUsername(authCandidateRequestDTO.username())
                .orElseThrow(() -> new UsernameNotFoundException("Username/password incorrect"));

        if (!authCandidateRequestDTO.password().equals(user.getPassword())) {
            throw new AuthenticationException("Username/password incorrect");
        }

    }
}
