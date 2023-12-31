// For a given word entered from standard input, print it reversed. 
//On input in the first line, the number of words that will be entered is given.
//In the following lines, the words are entered.//

 // (Input: 
//3//
//one//
//two
//three)//
//(Output: //
//eno//
//owt//
//eerht ) //

import java.util.Scanner;
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numberOfWords; i++) { 
        String word = scanner.nextLine();
        String reversedWord = reverseWord(word);
        System.out.println(reversedWord);
        }
    }
       private static String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }
}
