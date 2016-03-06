package refactoring.catalog.basic.duplicateObservedData.after;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class IntervalWindow extends Frame implements Observer {
    private Interval _subject;

    TextField _startField;
    TextField _endField;
    TextField _lengthField;

    public IntervalWindow() throws HeadlessException {
        _subject = new Interval();
        _subject.addObserver(this);
        update(_subject, null);
    }

    @Override
    public void update(Observable observed, Object arg) {

    }


    class SymFocus extends java.awt.event.FocusAdapter
    {
        public void focusLost(java.awt.event.FocusEvent event)
        {
            Object object = event.getSource();
            if (object == _startField)
                StartField_FocusLost(event);
            else if (object == _endField)
                EndField_FocusLost(event);
            else if (object == _lengthField)
                LengthField_FocusLost(event);
        }
    }

    void StartField_FocusLost(java.awt.event.FocusEvent event) {
        if (isNotInteger(_startField.getText()))
            _startField.setText("0");
        calculateLength();
    }

    private boolean isNotInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void EndField_FocusLost(java.awt.event.FocusEvent event) {
        if (isNotInteger(_endField.getText()))
            _endField.setText("0");
        calculateLength();
    }
    void LengthField_FocusLost(java.awt.event.FocusEvent event) {
        if (isNotInteger(_lengthField.getText()))
            _lengthField.setText("0");
        calculateEnd();
    }

    void calculateLength(){
        try {
            int start = Integer.parseInt(_startField.getText());
            int end = Integer.parseInt(_endField.getText());
            int length = end - start;
            _lengthField.setText(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException ("Unexpected Number Format Error");
        }
    }
    void calculateEnd() {
        try {
            int start = Integer.parseInt(_startField.getText());
            int length = Integer.parseInt(_lengthField.getText());
            int end = start + length;
            _endField.setText(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException ("Unexpected Number Format Error");
        }
    }
}
