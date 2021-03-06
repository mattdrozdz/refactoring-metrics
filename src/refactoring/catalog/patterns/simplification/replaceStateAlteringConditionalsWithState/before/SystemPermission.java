package refactoring.catalog.patterns.simplification.replaceStateAlteringConditionalsWithState.before;

/**
 * @author mdrozdz
 */
public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private boolean isGranted;
    private boolean isUnixPermissionGranted;
    private String state;

    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
    public final static String UNIX_CLAIMED = "UNIX_CLAIMED";

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = REQUESTED;
        isGranted = false;
        notifyAdminOfPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        if (!state.equals(REQUESTED) && !state.equals(UNIX_REQUESTED))
            return;
        willBeHandledBy(admin);
        if (state.equals(REQUESTED))
            state = CLAIMED;
        else if (state.equals(UNIX_REQUESTED))
            state = UNIX_CLAIMED;
    }

    public void deniedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        isGranted = false;
        isUnixPermissionGranted = false;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;

        if (profile.isUnixPermissionRequired() && state.equals(UNIX_CLAIMED))
            isUnixPermissionGranted = true;
        else if (profile.isUnixPermissionRequired() &&
                !isUnixPermissionGranted()) {
            state = UNIX_REQUESTED;
            notifyUnixAdminsOfPermissionRequest();
            return;
        }
        state = GRANTED;
        isGranted = true;
        notifyUserOfPermissionRequestResult();
    }

    private void notifyAdminOfPermissionRequest() {
    }

    private void willBeHandledBy(SystemAdmin admin) {
    }

    private void notifyUserOfPermissionRequestResult() {
    }

    private void notifyUnixAdminsOfPermissionRequest() {
    }


    public boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }
}
