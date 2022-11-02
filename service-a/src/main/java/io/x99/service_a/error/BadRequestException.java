package io.x99.service_a.error;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String text) {
        super(text);
    }
}