package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    public int checkNumbers(String a) {
        if (a.equals("") || a.equals(" "))
            return -1;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(a);
        if (matcher.matches())
            return 0;
        else
            return -1;
    }
}
