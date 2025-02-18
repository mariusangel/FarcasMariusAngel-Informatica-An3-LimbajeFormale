import java.util.Set;

public class StringOperations {
    private static final Set<Character> A = Set.of('a', 'b', 'c');
    private static final Set<Character> B = Set.of('x', 'y', 'z');
    private static final Set<Character> C = Set.of('1', '2', '3');

    private static char getAlphabet(String s) {
        if (s.chars().allMatch(c -> A.contains((char) c))) return 'A';
        if (s.chars().allMatch(c -> B.contains((char) c))) return 'B';
        if (s.chars().allMatch(c -> C.contains((char) c))) return 'C';
        return 'N';
    }

    public static String concatenate(String s1, String s2) {
        char a1 = getAlphabet(s1), a2 = getAlphabet(s2);
        if (a1 == 'N' || a2 == 'N' || a1 == a2) throw new IllegalArgumentException("Șiruri nevalide.");
        return s1 + s2;
    }

    public static String invers(String s) {
        if (getAlphabet(s) == 'N') throw new IllegalArgumentException("Șir nevalid.");
        return new StringBuilder(s).reverse().toString();
    }

    public static String substituie(String s, char a, char b) {
        if (getAlphabet(Character.toString(a)) == getAlphabet(Character.toString(b)))
            throw new IllegalArgumentException("Simboluri din același alfabet.");
        return s.replace(a, b);
    }

    public static int lungime(String s) {
        if (getAlphabet(s) == 'N') throw new IllegalArgumentException("Șir nevalid.");
        return s.length();
    }
}
