package io.d2a.dhbw.io.jtail;

public class JTailException extends Exception {

    public JTailException() {
    }

    public JTailException(final String message) {
        super(message);
    }

    public JTailException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public JTailException(final Throwable cause) {
        super(cause);
    }

    public JTailException(final String message, final Throwable cause,
        final boolean enableSuppression,
        final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
