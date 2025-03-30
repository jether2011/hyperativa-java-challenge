package br.com.hyperativa.service.domain.entity.dto;

import java.util.Objects;

public record CardCreateDTO(String cardNumber) {
    public CardCreateDTO {
        Objects.requireNonNull(cardNumber, "CardNumber cannot be null");

        if (cardNumber.isBlank()) {
            throw new IllegalArgumentException("CardNumber cannot be blank");
        }
    }
}
