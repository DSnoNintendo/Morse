/** Morse code translator
 *
 * Program takes user input, translates it to Morse Code, and gives the option to play it as audio
 *  By Daryl Stronge
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class MorseGit {

    public static void main(String[] args) {
        // Call Audio objects
        //dit is the equivalent of '.' in Morse code
        //dah is the equivalent of '-' in Morse code
        Audio dit = new Audio();
        Audio dah = new Audio();
        
        //stores path to audio files in Audio objects
        dit.path = "dit.wav";
        dah.path = "dah.wav";
        
        //open file paths as audio
        dit.open();
        dah.open();
        
        //runs while loop in case user wants to quit
        while(true) {
            //Array where translated characters will be stored
            List morseList = new ArrayList();
            //morse code message will eventually be stored here
            String morseMessage;

            //user input
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a message.");
            String message = in.nextLine();

            //iterate user message's characters and translates them to morse code characters
            for (int i = 0; i < message.length(); i++ ) 
            {
                //if unknown character is recognized
                if(Translate(message.charAt(i)) == "[UNKNOWN CHARACTER]") {
                    System.out.println("An unknown character was recognized. Unable to translate message");
                    morseList.add(Translate(message.charAt(i)));
                    break;
                }
                
                else {
                    //call Translate method. The argument used is the character of the user message.
                    //translated character is added to morse text message Array
                    morseList.add(Translate(message.charAt(i)));
                }
            };
            
            if (morseList.contains("[UNKNOWN CHARACTER]")) {
                //if unknown character
                System.out.println("Would you like to translate another message?");

                //if yesOrNo method returns a "Y" or yes
                if(yesOrNo(in).equals("N")) 
                { //ends program
                    break;
                }
            }
            
            else {
                //if message is translated successfully
                //merge morse code Array to make translated message a String
                morseMessage = String.join("", morseList);

                System.out.println("Your translated message is:");
                System.out.println(morseMessage);

                System.out.println("Would you like to play your message as audio?");
                //if yesOrNo method returns a "Y" or yes
                if(yesOrNo(in).equals("Y")) 
                {
                    //call play method. arguments are translated message String and the audio objects
                    playMessageAudio(morseMessage, dit, dah);
                }

                System.out.println("Would you like to translate another message?");

                //if yesOrNo method returns a "N" or no
                if(yesOrNo(in).equals("N")) 
                { //ends program
                    break;
                }
            }
        }
    }
        //translate charracter to morse code
    public static String Translate(char ch) {
        //start of switch statement; makes characters uppercase in case user doesn't enter capital letters
        switch(Character.toUpperCase(ch)) {
            //Handling for character
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
        //returns if switch statement doesn't recognize character
        return("[UNKNOWN CHARACTER]");        
    }
    
    //converts user input to yes or no and returns it as a string
    public static String yesOrNo(Scanner in) {
        //runs while loop in case user doesn't enter "Y" or "N"
        while(true) {
            System.out.println("Type Y or N");
            //toUpperCase used in case user enters lowercase letter
            String answer = in.nextLine().toUpperCase();
            
            //if no
            if(answer.equals("N")) 
            {
                return(answer);
            }
            //if yes
            else if(answer.equals("Y")) 
            {
                return(answer);
            }
        }
    }
    
    //method to stop running of code
    public static void sleep(int milliseconds) {
        //stop program to play audio in concise manner
        //from https://stackoverflow.com/a/24104332
        try
            {
                //pause code running for inputed milliseconds
                Thread.sleep(milliseconds); 
            }
        catch(InterruptedException ex)
            { //interrupt to make sure code keeps running if exception occurs
                Thread.currentThread().interrupt();
            }
    }
    
    //play morse code text as audio
    public static void playMessageAudio(String morseText, Audio dit,Audio dah) {
        //Iterate morse text message
        for (int i = 0;i < morseText.length(); i++) 
        {
            //Handling for single character in message
            if (morseText.charAt(i) == '.')
                //if char is a dit
            {
                //play is a method of Audio type
                dit.start();
                //calls sleep method. Stops code running for .2 seconds to make sure audio messages play in full
                sleep(200);
                //ends play method
                dit.stop();
            } 
            
            else if (morseText.charAt(i) == '-') 
                //if char is a dah
            {
                dah.start();
                //calls sleep method for .3 seconds because dah is a longer audio clip
                sleep(300);
                dah.stop();
            } 
            
            else if (morseText.charAt(i) == ' ') 
                //if char is a space. Used to separate words
            {
                sleep(300);
            }
            
            else if (morseText.charAt(i) == '/') 
                //if char is a space. Used to separate words
            {
                sleep(100);
            }
        }
    }
    
}

  
  
