/*
 * Lab5 When given the number to shift each character, propery shift each character according to the ascii alphabet and
 return the encrypted message to be displayed later.
 * COSC 236 Section 102
 * Program #6/Lab Assignment #4 Ceaser Cipher
 *
 *
 * @author Ronnie Huggins & Gradieu Kisala
*/
// prompt user for the key
//prompt the user for the clear text

// when line consists of only a single period . terminate
// 65-90 Cap, 
import java.util.*;


class cipher{
    /**
     * The main java method responsible for calling the encrypt function
     * 
     * @param args -  string of arguments to pass to the function.
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String cipherText;
        String clearText = "";

        System.out.print("Please enter your key: ");
        int key = in.nextInt();
        in.nextLine();

        System.out.print("Start typing your message, when you are finished typing your message type (.):");
        String userInput = (in.nextLine()).toUpperCase();

        while(!userInput.contains(".")){
        
        
            clearText = clearText + userInput;
            userInput = in.nextLine().toUpperCase();
        }
        
        cipherText = Encrypt(key, clearText);
        System.out.println(cipherText);

    }
    /**
     * Encrypt method which is responsible for the actual encryption of the phrase entered in with the key
     * following it.
     * 
     * @param key - the number of letters to shift.
     * @param text - the text to be shifted.
     */

    public static String Encrypt(int key, String text){
        char[] encrypted_text = new char[100];
        int ascii_char;
        for(int i=0; i < text.length() ; i++){
            encrypted_text[i] = text.charAt(i);
            ascii_char = encrypted_text[i];
            if (ascii_char > 87){
                ascii_char = ascii_char - 26;
            }
            ascii_char = ascii_char + key;
            encrypted_text[i] = ((char)ascii_char);
        
        }
        System.out.println();

        String cipherText = new String(encrypted_text).replace('#', ' ');

        return cipherText;
    }

}