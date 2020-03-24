import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//22import static com.sun.tools.doclint.Entity.and;

public class myclass {
    public static String ArabicToRome(Integer number){
        String result="";
        String minus="";
        if (number<0) {
            number=number*-1;
            minus="-";
        }
        if (number==100) result="C";
        if (number>89&number<100) result="XC"+ArabicToRome(number-90);
        if (number>49&number<90) result="L"+ArabicToRome(number-50);
        if (number>39&number<50) result="XL"+ArabicToRome(number-40);
        if (number>10&number<40) result="X"+ArabicToRome(number-10);
        if (number==10) result="X";
        if (number==9) result="IX";
        if (number<9&number>4)   result="V"+ArabicToRome(number-5);
        if (number==4) result="IV";
        if (number<4&number>1) result="I"+ArabicToRome(number-1);
        if (number==1) result="I";

        return minus+result;
    }

    public static Integer easiCalk(Integer number1, Integer number2, char operator){
        Integer result=0;
        switch (operator){
            case('+'):
                result= number1+number2;
                break;
            case('-'):
                result= number1-number2;
                break;
            case('*'):
                result= number1*number2;
                break;
            case('/'):
                result= number1/number2;
                break;   //
            }

        return result;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("input:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String calc;
        calc = reader.readLine();

        Map<String, Integer> arabic = new HashMap<>();

        arabic.put("1", 1);
        arabic.put("2", 2);
        arabic.put("3", 3);
        arabic.put("4", 4);
        arabic.put("5", 5);
        arabic.put("6", 6);
        arabic.put("8", 8);
        arabic.put("7", 7);
        arabic.put("9", 9);
        arabic.put("10", 10);

        Map<String, Integer> rome = new HashMap<>();
        rome.put("I", 1);
        rome.put("II", 2);
        rome.put("III", 3);
        rome.put("IV", 4);
        rome.put("V", 5);
        rome.put("VI", 6);
        rome.put("VIII", 8);
        rome.put("VII", 7);
        rome.put("IX", 9);
        rome.put("X", 10);

        HashSet<String> mySet = new HashSet<String>();


        mySet.add("+");
        mySet.add("-");
        mySet.add("*");
        mySet.add("/");

        calc=calc.replace(" ","");
        int pos=0;
        while ((pos<calc.length()-1) & !(mySet.contains(calc.substring(pos, pos+1))) ){
            pos++;

        }//*/

        String a=calc.substring(0,pos);
        String b=calc.substring(pos+1);

        System.out.println("Output:");
        try {
            if ((arabic.get(a) != null) & (arabic.get(b) != null) & (mySet.contains(calc.substring(pos, pos + 1))))
                System.out.println(easiCalk(arabic.get(a), arabic.get(b), calc.charAt(pos)));
            else if ((rome.get(a) != null) & (rome.get(b) != null) & (mySet.contains(calc.substring(pos, pos + 1))))
                System.out.println(a.equals(b)&(calc.charAt(pos)=='-')?"0":ArabicToRome(easiCalk(rome.get(a), rome.get(b), calc.charAt(pos))));
            else System.out.println("Введеная строка не может быть посчитана!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
