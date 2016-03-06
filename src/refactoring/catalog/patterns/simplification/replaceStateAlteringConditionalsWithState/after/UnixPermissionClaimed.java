package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.after;

/**
 * @author mdrozdz
 */
public class UnixPermissionClaimed extends PermissionState {
    public UnixPermissionClaimed() {
        super("UNIX_CLAIMED");
    }

    @Override
    public void deniedBy(SystemAdmin admin, SystemPermission permission) {
        if (!permission.getAdmin().equals(admin))
            return;
        permission.setIsGranted(false);
        permission.setIsUnixPermissionGranted(false);
        permission.setState(DENIED);
        permission.notifyUserOfPermissionRequestResult();
    }

    @Override
    public void grantedBy(SystemAdmin admin, SystemPermission permission) {
        if (!permission.getAdmin().equals(admin))
            return;
        if (permission.getProfile().isUnixPermissionRequired())
            permission.setIsUnixPermissionGranted(true);
        permission.setState(GRANTED);
        permission.setIsGranted(true);
        permission.notifyUserOfPermissionRequestResult();
    }

}
