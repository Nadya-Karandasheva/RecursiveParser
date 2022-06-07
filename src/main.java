import java.util.Scanner;

public class main {
    static char[] symbols;
    static int indexOfChar;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String symbols = in.nextLine();
        if (check(symbols)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean check(String str) {
        symbols = str.toCharArray();
        indexOfChar = 0;
        try {
            S();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static void error() {
        throw new RuntimeException("error");
    }

    private static char getChar() {
        char c = symbols[indexOfChar];
        indexOfChar++;
        return c;
    }

    private static void S() {
        char c = getChar();
        if (c == 'c') {
            C();
            A();
        }else if (c == 'b') {
            c = getChar();
            if (c != 'b') {
                error();
            }
            C();
            A();
            B();
        }else if (c != 'a') {
            error();
        }
        if (indexOfChar != symbols.length) {
            error();
        }
    }

    private static void A() {
        char c = getChar();
        if (c == 'a') {
            A();
        } else if (c != 'c') {
            error();
        }
    }

    private static void B() {
        char c = getChar();
        if (c != 'b') {
            error();
        }
        c = getChar();
        if (c != 'b') {
            error();
        }
        c = getChar();
        if (c != 'b') {
            error();
        }
    }

    private static void D() {
        char c = getChar();
        if (c != 'c') {
            indexOfChar--;
            C();
            c = getChar();
            if (c != 'c') {
                error();
            }
            c = getChar();
            if (c != 'c') {
                error();
            }
        }
    }

    private static void C() {
        char c = getChar();
        if (c != 'c') {
            indexOfChar--;
            B();
            A();
            c = getChar();
            if (c != 'c') {
                error();
            }
        } else {
            c = getChar();
            if (c == 'c') {
                D();
            } else error();
        }
    }

}