package br.com.hyperativa.service.domain.services.impl;

import br.com.hyperativa.service.domain.entity.Card;
import br.com.hyperativa.service.domain.entity.dto.CardCreateDTO;
import br.com.hyperativa.service.domain.entity.dto.CardGetDTO;
import br.com.hyperativa.service.domain.exceptions.CardCreateException;
import br.com.hyperativa.service.domain.exceptions.NotFoundException;
import br.com.hyperativa.service.domain.services.CardService;
import br.com.hyperativa.service.resources.repository.CardRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    public CardServiceImpl(final CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardGetDTO createCard(final CardCreateDTO cardCreate) {
        try {
            final Card created = cardRepository.save(new Card().cardNumber(cardCreate.cardNumber()));
            return new CardGetDTO(created.getId(), created.getCardNumberIdentifier());
        } catch (Exception e) {
            throw new CardCreateException("Card create error", e);
        }
    }

    @Override
    public CardGetDTO getCardByNumber(final String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber)
                .map(card -> new CardGetDTO(card.getId(), card.getCardNumberIdentifier()))
                .orElseThrow(() -> new NotFoundException("Card not found"));
    }

    @Override
    public CardGetDTO getCardByIdentifier(final String cardNumberIdentifier) {
        return cardRepository.findByCardNumberIdentifier(cardNumberIdentifier)
                .map(card -> new CardGetDTO(card.getId(), card.getCardNumberIdentifier()))
                .orElseThrow(() -> new NotFoundException("Card not found"));
    }

    @Override
    public List<CardGetDTO> getAllUsers(Pageable pageable) {
        return cardRepository.findAll(pageable)
                .map(card -> new CardGetDTO(card.getId(), card.getCardNumberIdentifier()))
                .toList();
    }
}
