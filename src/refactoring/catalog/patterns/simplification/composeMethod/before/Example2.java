package refactoring.catalog.patterns.simplification.composeMethod.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdrozdz
 * Compose Method
 */
public class Example2 {

    public static List<String> wrap(String s) {
        List<String> wrapVector = new ArrayList<String>();
        String words;
        String word;
        int lastPos;
        do {
            if (s.length() > 16) {
                words="";
                word="";
                lastPos=0;
                for (int i=0;i<16;i++) {
                    if (s.charAt(i)==' ' || s.charAt(i)=='-') {
                        words+=word+s.charAt(i);
                        lastPos = i+1;
                        word="";
                    } else word+=s.charAt(i);
                }
                if (lastPos==0) {
                    // Rare case that there was no space or dash, insert one and break
                    words+=word+"-";
                    lastPos=16;
                }
                wrapVector.add(words);
                s = s.substring(lastPos, s.length());
            }
        } while (s.length() > 16);
        if (s.length()>0) wrapVector.add(s);
        return wrapVector;
    }

}
