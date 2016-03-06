package refactoring.catalog.patterns.generalization.extractAdapter.domain;

/**
 * @author mdrozdz
 */
public class QueryException extends Exception {
    public static final String LOGIN_FAILED = "LOGIN_FAILED";

    public QueryException(String loginFailed, String s, SDLoginFailedException lfe) {
    }

    public QueryException(String loginFailed, String s, SDSocketInitFailedException ife) {
    }

    public QueryException(String loginFailed, String s, SDNotFoundException nfe) {
    }
}
