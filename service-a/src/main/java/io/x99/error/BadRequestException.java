package io.x99.error;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String text) {
        super(text);
    }
}