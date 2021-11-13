import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {

    static void split(String str,ArrayList<String> result) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                result.add((str.substring(i, j)));
            }
        }
    }

    static boolean compare(String first, String second){
        char[] mas1 = first.toCharArray();
        char[] mas2 = second.toCharArray();
        Arrays.sort(mas1);
        Arrays.sort(mas2);
        if(Arrays.compare(mas1,mas2) == 0){
            return true;
        }else {return false;}
    }

    static int countAll(ArrayList<String> result){
        int counter = 0;
        for(int i = 0;i<result.size()-1;){
            for (int j = i+1;j<result.size();j++){
                if(compare(result.get(i),result.get(j))){
                    counter++;
                }
            }
            result.remove(i);
        }
        return counter;
    }

    static int getAnagrams(String string) throws AnagramException{
        char[] mas = string.toCharArray();
        if(string.length()<3 || string.length()>100){
            throw new AnagramException("the input string size must be 3 ≤ | s | ≤ 100");
        }
        for (int i = 0;i<string.length()-1;i++){
            if(!(97<=mas[i] && mas[i]<=122)){
                throw new AnagramException("the input string must contain only a-z");
            }
        }
        ArrayList<String> result = new ArrayList<>();
        split(string,result);
        return countAll(result);

    }

}
class AnagramException extends Exception{
    AnagramException(String errorMessage){
        super(errorMessage);
    }
}
