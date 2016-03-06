package refactoring.catalog.basic.extractClass.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Person {
    public String getName() {
        return _name;
    }
    public String getTelephoneNumber(){
        return _officeTelephone.getTelephoneNumber();
    }
    TelephoneNumber getOfficeTelephone() {
        return _officeTelephone;
    }
    private String _name;
    private TelephoneNumber _officeTelephone = new TelephoneNumber();
}
