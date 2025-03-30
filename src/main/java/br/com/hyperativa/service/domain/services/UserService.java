package br.com.hyperativa.service.domain.services;

import br.com.hyperativa.service.domain.entity.User;
import br.com.hyperativa.service.domain.entity.dto.UserCreateDTO;
import br.com.hyperativa.service.domain.entity.dto.UserGetDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserGetDTO createUser(final UserCreateDTO userCreate);

    UserGetDTO getUser(final String username);

    User getUserEntity(final String username);

    List<UserGetDTO> getAllUsers(final Pageable pageable);
}
