import android.renderscript.ScriptGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class morse {
    public static String translate(char character) {
        switch (character) {
            case 'A':
                return (".-");
            case 'B':
                return ("-...");
            case 'C':
                return ("-.-.");
            case 'D':
                return ("-..");
            case 'E':
                return (".");
            case 'F':
                return ("..-.");
            case 'G':
                return ("--.");
            case 'H':
                return ("....");
            case 'I':
                return ("..");
            case 'J':
                return (".---");
            case 'K':
                return ("-.-");
            case 'L':
                return (".-..");
            case 'M':
                return ("--");
            case 'N':
                return ("-.");
            case 'O':
                return ("---");
            case 'P':
                return (".--.");
            case 'Q':
                return ("--.-");
            case 'R':
                return (".-.");
            case 'S':
                return ("...");
            case 'T':
                return ("-");
            case 'U':
                return ("..-");
            case 'V':
                return ("...-");
            case 'W':
                return (".--");
            case 'X':
                return ("-..-");
            case 'Y':
                return ("-.--");
            case 'Z':
                return ("--..");
            case '0':
                return ("-----");
            case '1':
                return (".----");
            case '2':
                return ("..---");
            case '3':
                return ("...--");
            case '4':
                return ("....-");
            case '5':
                return (".....");
            case '6':
                return ("-....");
            case '7':
                return ("--...");
            case '8':
                return ("---..");
            case '9':
                return ("----.");
        }
        return ("");
    }

    public static void main(String[] args) {
        List morseList = new ArrayList();
        String dayString;
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a messsge: ");
        String message = reader.next().toUpperCase();
        // switch statement with int data type

        for (int x = 0; x < message.length(); x++) {
            morseList.add(translate(message.charAt(x)));
        }
        System.out.println(morseList);


    }
}
