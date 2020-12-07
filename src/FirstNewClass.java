import com.mifmif.common.regex.Generex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class FirstNewClass {

    public static void main(String[] args) {
        //findPatternInSource("round", "The whells round and round");
        //findPatternInSource("lime", "The lime is so limeo");
        //findPatternInSource("lime", "The lime is so lime");
        //findPatternInSource("\\.", "125.45.56"); Two Times
        //findPatternInSource("\\.\\.\\.", "xyz xyz ... xyz xyz");
        //Found ... at index 8 in string xyz xyz ... xyz xyz
        //findPatternInSource("[41]", "new int[41]");
        /*Found [41] at index 7 in string new int[41]
                findPatternInSource("\\[41\\]", "new int[41]");
         */
        // xxx findPatternInSource("^\\lime\\$", "The lime is so limeo");
        //findPatternInSource("\\d", "3456778");
        //findPatternInSource("\\d{1,}", "3456778");
        //findPatternInSource("\\d{1,3}", "3456778 908 7656");
        //findPatternInSource("ninja", "ninja Ninja ninja");
        //findPatternInSource("[ng]inja", "ninja ginja ninja");
        //findPatternInSource("[ng]inja", "ninja ginja ninja");
        //findPatternInSource("[a-zA-Z]inja", "ninja ainja ringa Ringa Ainga");
//System.out.println(generateRegex("201[120][0-9]{8}"));
        //System.out.println(generateRegex("201[120][0-9]{8}"));
        //System.out.println(generateRegex(regexFlag.PHONE));
        //System.out.println(generateRegex(regexFlag.EMAIL));
        //findPatternInSource(".*", "ahmed wants to play football");
        //Found ahmed at index 0 in string ahmed
        //findPatternInSource("^[a-z]{5}$", "ahmed");
        //findPatternInSource("^[a-z]{5}$", "ahmed");
        //System.out.println(generateRegex());
        //findPatternInSource("Displaying \\d{1} - \\d{2} of \\d{2,}", "Displaying 1 - 10 of 268");
        extractVariableFromRegex();
    }
    static void findPatternInSource(String regex, String source)
    {
        boolean found = false;
        //Pattern pattern =Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while(matcher.find())
        {
            System.out.println("Found " + matcher.group() + " at index " + matcher.start() + " in string " + source);
            found = true;
        }
        if(!found)
        {
            System.out.println("Not Single Match like " + regex + " in the source: " + source);
        }
    }
    enum regexFlag {
        PHONE, EMAIL
    }
    //static String generateRegex(regexFlag flag)
    static String generateRegex()
    {
        //Map<Enum, String> geneicExp = new HashMap<Enum, String>();
        //regexFlag requiredRegex = flag;
        //geneicExp.put(regexFlag.PHONE, "201[120][0-9]{8}");
        //geneicExp.put(regexFlag.EMAIL, "[A-Z]{1}[a-z]{5,12}[0-9]{1,4}\\@(hot|g)mail\\.(com|org|net)");
        Generex generex = new Generex("Displaying \\d{1,5} - \\d{1,5} of \\d{1,5}");
        String randomStr = generex.random();
        return randomStr;
    }

    public static void extractVariableFromRegex() {
        String myText = "Displaying 1 - 10 of 268";
        Pattern myRegex = Pattern.compile("Displaying \\d{1} - \\d{2} of (?<need>\\d{1,})");
        Matcher myMatcher = myRegex.matcher(myText);
        while (myMatcher.find()) {
            String nd  = myMatcher.group("need");
            System.out.println(nd);
            int ndInt = Integer.parseInt(nd);
            if(ndInt > 300)
            {
                System.out.println(ndInt);
                System.out.println("My number is very big");
            }
            else{
                System.out.println(ndInt);
                System.out.println("My number is very small");            }
        }
    }
    
    public static String regexSearch(String regex, String input) {
        Matcher m = Pattern.compile(regex).matcher(input);
        if (m.find()) return m.group();
        return null;
    }

}
