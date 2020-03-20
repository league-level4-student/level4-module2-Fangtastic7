package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		if (s1.length() < s2.length()) {
			return s2;
		}
		return "equal";
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			return s.replaceAll("\\s", "_");
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))){
				int num = Integer.parseInt(s.substring(i, i + 1));
				sum = sum + num;
			} 
		}
		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int counter = 0;
		for(int i = 0;i<s.length();i++) {
			if(i<= s.length()-substring.length()) {
			if(s.substring(i, i+substring.length()).equals(substring)) {
				counter = counter + 1;
				//System.out.println(s);
			}
			}
		}
		return counter;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		
		String phrase = Utilities.encrypt(s.getBytes(), (byte) key);
		
		return phrase;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String phrase = Utilities.decrypt(s, (byte) key);
		
		return phrase;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int counter = 0;
		for(int i = 0;i <s.length();i++) {
			if(i < s.length()-substring.length()+1) {
				if(i+substring.length()+1 < s.length()) {
				if(s.substring(i, i+substring.length()).equals(substring) && s.substring(i+substring.length(), i+substring.length()+1).equals(" ")) {
					counter = counter +1;
				}
				}
				else {
					if(s.substring(i, i+substring.length()).equals(substring)) {
						counter = counter + 1;
					}
				}
			}
		}
		return counter;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int x = 0;
		int y =0;
		boolean first = false;
		for(int i = 0; i<s.length(); i++) {
			if(i<=s.length()-substring.length()) {
				if(s.substring(i, i+substring.length()).equals(substring)) {
					if(first) {
						y=i;
					}
					else {
						first = true; 
						x = i;
					}
				}
			}
		}
		return s.substring(x+substring.length(), y).length();
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		s = s.replaceAll("[^A-Za-z]+", "");
		String word = "";
		for(int i = 0 ; i <s.length(); i++) {
			word = word + s.charAt(s.length()-1-i);
		}
		if(word.equalsIgnoreCase(s)) {
			return true;
		}
		return false;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
