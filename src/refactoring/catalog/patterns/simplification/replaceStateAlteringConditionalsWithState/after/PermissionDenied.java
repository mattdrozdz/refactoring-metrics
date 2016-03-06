package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.after;

/**
 * @author mdrozdz
 */
public class PermissionDenied extends PermissionState {
    public PermissionDenied() {
        super("DENIED");
    }
}
