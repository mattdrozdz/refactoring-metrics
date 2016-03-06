package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.after;

/**
 * @author mdrozdz
 */
public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private boolean isGranted;
    private boolean isUnixPermissionGranted;
    private PermissionState permissionState;

    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
    public final static String UNIX_CLAIMED = "UNIX_CLAIMED";

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        setPermission(PermissionState.REQUESTED);
        isGranted = false;
        notifyAdminOfPermissionRequest();

    }

    public void claimedBy(SystemAdmin admin) {
        permissionState.claimedBy(admin, this);
    }

    public void deniedBy(SystemAdmin admin) {
        permissionState.deniedBy(admin, this);
    }

    public void grantedBy(SystemAdmin admin) {
        permissionState.grantedBy(admin, this);
    }

    private void notifyAdminOfPermissionRequest() {
    }

    void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    void notifyUserOfPermissionRequestResult() {
    }

    void notifyUnixAdminsOfPermissionRequest() {
    }


    public boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    public PermissionState getState() {
        return permissionState;
    }

    void setState(PermissionState state) {
        this.permissionState = state;
    }

    public void setPermission(PermissionState permissionState) {
        this.permissionState = permissionState;
    }

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setIsGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }

    public void setIsUnixPermissionGranted(boolean isUnixPermissionGranted) {
        this.isUnixPermissionGranted = isUnixPermissionGranted;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void isGranted() {
        this.isGranted = isGranted;
    }
}
