package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.after;

/**
 * @author mdrozdz
 */
public class UnixPermissionRequested extends PermissionState {
    public UnixPermissionRequested() {
        super("UNIX_REQUESTED");
    }

    @Override
    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandledBy(admin);
        permission.setState(UNIX_CLAIMED);
    }
}
