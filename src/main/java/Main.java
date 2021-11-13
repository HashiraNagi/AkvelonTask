import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AnagramException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(Anagram.getAnagrams(str));
    }
}
