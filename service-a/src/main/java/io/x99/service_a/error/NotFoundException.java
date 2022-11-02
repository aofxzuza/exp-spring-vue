package io.x99.service_a.error;

public class NotFoundException  extends RuntimeException {

    public NotFoundException(String text) {
        super(text);
    }
}