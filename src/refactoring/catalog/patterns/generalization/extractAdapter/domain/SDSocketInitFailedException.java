package refactoring.catalog.patterns.generalization.extractAdapter.domain;

/**
 * @author mdrozdz
 */
public class SDSocketInitFailedException extends QueryException {
    public SDSocketInitFailedException(String loginFailed, String s, SDLoginFailedException lfe) {
        super(loginFailed, s, lfe);
    }

    public SDSocketInitFailedException(String loginFailed, String s, SDSocketInitFailedException ife) {
        super(loginFailed, s, ife);
    }
}
