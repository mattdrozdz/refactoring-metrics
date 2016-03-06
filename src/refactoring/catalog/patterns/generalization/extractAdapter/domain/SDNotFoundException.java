package refactoring.catalog.patterns.generalization.extractAdapter.domain;

/**
 * @author mdrozdz
 */
public class SDNotFoundException extends QueryException {
    public SDNotFoundException(String loginFailed, String s, SDLoginFailedException lfe) {
        super(loginFailed, s, lfe);
    }

    public SDNotFoundException(String loginFailed, String s, SDSocketInitFailedException ife) {
        super(loginFailed, s, ife);
    }
}
