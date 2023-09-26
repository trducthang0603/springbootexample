package com.example.javaprojectbuild.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public FileNotFoundException(String message) {
        super(message);
    }
    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class FileStorageException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public FileStorageException(String message) {
            super(message);
        }

        public FileStorageException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
