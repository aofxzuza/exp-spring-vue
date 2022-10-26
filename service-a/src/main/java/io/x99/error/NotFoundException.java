package io.x99.error;

public class NotFoundException  extends RuntimeException {

    public NotFoundException(String text) {
        super(text);
    }
}