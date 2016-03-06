package refactoring.catalog.basic.extractClass.before;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Person {
    public String getName() {
        return _name;
    }
    public String getTelephoneNumber() {
        return ("(" + _officeAreaCode + ") " + _officeNumber);
    }
    String getOfficeAreaCode() {
        return _officeAreaCode;
    }
    void setOfficeAreaCode(String arg) {
        _officeAreaCode = arg;
    }
    String getOfficeNumber() {
        return _officeNumber;
    }
    void setOfficeNumber(String arg) {
        _officeNumber = arg;
    }
    private String _name;
    private String _officeAreaCode;
    private String _officeNumber;
}
