package refactoring.catalog.patterns.generalization.extractAdapter.domain;

import refactoring.catalog.patterns.generalization.extractAdapter.before.Query;

/**
 * @author mdrozdz
 */
public class SDLoginFailedException extends QueryException {
    public SDLoginFailedException(String loginFailed, String s, SDLoginFailedException lfe) {
        super(loginFailed, s, lfe);
    }

    public SDLoginFailedException(String loginFailed, String s, SDSocketInitFailedException ife) {
        super(loginFailed, s, ife);
    }
}
