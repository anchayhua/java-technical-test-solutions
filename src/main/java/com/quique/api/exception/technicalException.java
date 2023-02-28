package com.quique.api.exception;

/**
 *
 * @author nanchayhua
 */
public class technicalException extends BaseException {

    private static final long serialVersionUID = 1L;

    public technicalException(String message, Exception exception) {
        super(message, exception);
    }

    public technicalException(String code, String message) {
        super(code, message);
    }

    public technicalException(String code, String message, Exception exception) {
        super(code, message, exception);
    }

    public technicalException(Exception exception) {
        super(exception);
    }

    public technicalException(String message) {
        super(message);
    }
}
