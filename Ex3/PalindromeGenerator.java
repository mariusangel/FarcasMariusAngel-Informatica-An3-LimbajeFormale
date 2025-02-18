import java.util.ArrayList;
import java.util.List;

public class PalindromeGenerator {
    public static void main(String[] args) {
        char[] alphabet = {'0', '1', '2', '3'};
        
        for (int length = 1; length <= 5; length++) {
            List<String> palindromes = new ArrayList<>();
            generatePalindromes(new char[length], 0, length - 1, alphabet, palindromes);
            
            System.out.println("Palindroame de lungime " + length + ": " + palindromes);
        }
    }
    
    private static void generatePalindromes(char[] current, int left, int right, char[] alphabet, List<String> palindromes) {
        if (left > right) {
            palindromes.add(new String(current));
            return;
        }
        
        for (char c : alphabet) {
            current[left] = c;
            current[right] = c;
            generatePalindromes(current, left + 1, right - 1, alphabet, palindromes);
        }
    }
}
