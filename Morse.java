/**
 *
 * @author Daryl Stronge
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Morse {
    //translate charracter to morse code
    static String Translate(char ch) {
        //make characters uppercase to account for both upper and lowercase letters
        switch(Character.toUpperCase(ch)) {
            case 'A':
                return(".- ");
            case 'B':
                return("-... ");
            case 'C':
                return("-.-. ");
            case 'D':
                return("-.. ");
            case 'E':
                return(". ");
            case 'F':
                return("..-. ");
            case 'G':
                return("--. ");
            case 'H':
                return(".... ");
            case 'I':
                return(".. ");
            case 'J':
                return(".--- ");
            case 'K':
                return("-.- ");
            case 'L':
                return(".-.. ");
            case 'M':
                return("-- ");
            case 'N':
                return("-. ");
            case 'O':
                return("--- ");
            case 'P':
                return(".--. ");
            case 'Q':
                return("--.- ");
            case 'R':
                return(".-. ");
            case 'S':
                return("... ");
            case 'T':
                return("- ");
            case 'U':
                return(".-. ");
            case 'V':
                return("...- ");
            case 'W':
                return(".-- ");
            case 'X':
                return("-..- ");
            case 'Y':
                return("-.-- ");
            case 'Z':
                return("--.. ");
            case '1':
                return(".---- ");
            case '2':
                return("..--- ");
            case '3':
                return("...-- ");
            case '4':
                return("....- ");
            case '5':
                return("..... ");
            case '6':
                return("-.... ");
            case '7':
                return("--... ");
            case '8':
                return("---.. ");
            case '9':
                return("----. ");
            case '0':
                return("----- ");
            case ' ':
                return("/ ");
            case '.':
                return(".-.-.- ");
            case ',':
                return("--..-- ");
            case '?':
                return("..--.. ");
            case ':':
                return("---... ");
            case '/':
                return("-..-. ");
            case '-':
                return("-....- ");
            case '=':
                return("-...- ");
            //apostrophe
            case '\'': 
                return(".----. ");
            case '(':
                return("-.--. ");
            case ')':
                return("-.--.- ");
            case '_':
                return("..--.- ");
            case '!':
                return("-.-.-- ");
            case '&':
                return(".-... ");
            case '"':
                return(".-..-. ");
            case ';':
                return("-.-.-. ");
            case '$':
                return("...-..- ");
            case '+':
                return(".-.-.");
            case '@':
                return(".--.-.");
                        
                        
                       
        };
        return("[UNKNOWN CHARACTER]");        
    }
    
    static void sleep(int milliseconds) {
        try
            {
                Thread.sleep(milliseconds); 
            }
        catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
    }
    
    static void play(String morseText, Audio dit,Audio dah) {
        for (int i = 0;i < morseText.length(); i++) 
        {
            if (morseText.charAt(i) == '.') 
            {
                dit.play();
                sleep(200);
                dit.stop();
                
            } 
            else if (morseText.charAt(i) == '-') 
            {
                dah.play();
                sleep(300);
                dah.stop();
            } 
            else if (morseText.charAt(i) == ' ') 
            {
                sleep(300);
            }
            else if (morseText.charAt(i) == '/') 
            {
                sleep(100);
            }
            
            
        }
        
        
           
   
    }
    
    public static void main(String[] args) {
        Audio shortMorse = new Audio();
        Audio longMorse = new Audio();
        
        shortMorse.path = "short.wav";
        longMorse.path = "long.wav";
        shortMorse.open();
        longMorse.open();
        
        //where translated characters will be stored
        List morseList = new ArrayList();
        //morse code message will eventually be stored here
        String morseMessage;
        
        //user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a message.");
        String message = in.nextLine();
        
        //iterate regular text message and translate characters
        for (int i = 0; i < message.length(); i++ ) 
        {
            morseList.add(Translate(message.charAt(i)));
        };
        
        //merge morse code translated characters
        morseMessage = String.join("", morseList);
        
        System.out.println(morseMessage);
        
        play(morseMessage, shortMorse, longMorse);
        
    }
    
    
    
}

  
