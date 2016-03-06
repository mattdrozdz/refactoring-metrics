package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.after;

/**
 * @author mdrozdz
 */
public abstract class PermissionState {
    public final static PermissionState REQUESTED = new PermissionRequested();
    public final static PermissionState CLAIMED = new PermissionClaimed();
    public final static PermissionState GRANTED = new PermissionGranted();
    public final static PermissionState DENIED = new PermissionDenied();
    public final static PermissionState UNIX_REQUESTED = new UnixPermissionRequested();
    public final static PermissionState UNIX_CLAIMED = new UnixPermissionClaimed();

    private String name;

    public  PermissionState(String name) {
        this.name = name;
    }
    public void claimedBy(SystemAdmin admin, SystemPermission permission) {}
    public void deniedBy(SystemAdmin admin, SystemPermission permission) {}

    public void grantedBy(SystemAdmin admin, SystemPermission permission) {}

    public String toString() {
        return name;
    }
}
