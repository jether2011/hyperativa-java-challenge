package br.com.hyperativa.service.domain.services;

import br.com.hyperativa.service.domain.entity.dto.CardCreateDTO;
import br.com.hyperativa.service.domain.entity.dto.CardGetDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService {
    CardGetDTO createCard(final CardCreateDTO cardCreate);

    CardGetDTO getCardByNumber(final String cardNumber);

    CardGetDTO getCardByIdentifier(final String cardNumberIdentifier);

    List<CardGetDTO> getAllUsers(final Pageable pageable);
}
