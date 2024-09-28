package com.lehcene.app_bancaire.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EmailAlreadyExistsException extends RuntimeException {
    private final String errorMessage;
}
