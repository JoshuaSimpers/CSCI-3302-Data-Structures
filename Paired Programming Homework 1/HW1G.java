// CSCI 3302 - HW1G
// Luis Rangel, Joshua Simpers
// 9/15/2025
// File: HW1G.java
//
// Using recursion to solve problems

public class HW1G {

    // problem 1: Palindrome Detector
    public static void palindromeDetector(String base) {
        // keeps original string entered
        String fullPalindrome = base;
        
        // makes string lower case and removes spaces and punctuation to help search the string
        base = base.toLowerCase();
        base = base.replaceAll("[ \\+!,'@#.?<>+=()*&%$-]", "");
        
        // calls the recursive boolean method starting with the first and last index of the string
        // returns whether or not string is a palindrome
        if (palindromeDetector(base, 0, base.length() - 1) == false) {
            System.out.println(fullPalindrome + " is not a palindrome.");
        }
        else System.out.println(fullPalindrome + " is a palindrome.");
    }

    // recursive method used by the first palindromeDetector function
    private static boolean palindromeDetector(String base, int firstIndex, int lastIndex) {
        // base case that makes sure the indexes do not go out of bounds
        // and stops the method when all characters have been compared
        if (firstIndex >= lastIndex) {
            return true;
        }

        // returns false if the 2 characters being compared are not equal
        if(base.charAt(firstIndex) != base.charAt(lastIndex)) {
            return false;
        }
        // calls the method again with a new index
        else {
            return palindromeDetector(base, firstIndex + 1, lastIndex - 1);
        }
    }

    // problem 2: recursive reverse int.
    // This function simply takes in the desired user number and calls the
    // reverseNumber function with two parameters to make things easier for the user.
    public static void reverseNumber(int userNumber) {
        reverseNumber(userNumber, 0);
        System.out.println();
    }

    // function that takes the desired user number as an int and the current index of the number as a string as parameters
    private static void reverseNumber(int userNumber, int currentIndexOfString) {
        // take the user's number and turn it into a string for easy modification
        String userNumberAsString = Integer.toString(userNumber);
        // set the maximum length of the user's number in character for use in the stop case
        int numberLength = userNumberAsString.length();
        // if the current index of the string the program is modifying is equal to the length, the program has reached
        // the end of the string and should stop
        if (currentIndexOfString == numberLength) {
            return;
        }
        // otherwise, pring the next character in the number string starting from the end
        System.out.print(userNumberAsString.charAt(numberLength - currentIndexOfString - 1));
        // then increase the index of the string the program will be using for the next cycle
        currentIndexOfString++;
        // finally, call the function again, repeating the previous steps until it reaches the stop case
        reverseNumber(userNumber, currentIndexOfString);
    }

    // problem 3: non-recursive reverse int
    public static void printNumbers(int userNumber) {
        // take the user's desired number and convert it into a string numberAsString for modification
        String numberAsString = Integer.toString(userNumber);
        // starting at the beginning of the string, print the character at that index of the string with a white space
        // afterwards until you reach the end of the string
        for (int i = 0; i < numberAsString.length(); i++) {
            System.out.print(numberAsString.charAt(i) + " ");
        }
        // set the program to move the next console line when done
        System.out.println();
    }

    // problem 4: binomial co-efficient
    public static long binomialCoefficient(long n, long k) {
        // if k is 0 or equal to n, then the binomial coefficient of k and n should be 1, so simply return it as a base case
        if (k == 0 || k == n) {
            return 1;
        }
        // otherwise, return the sum of binomialCoefficient(n-1, k-1) and binomialCoefficient(n-1, k)
        // which will have multiple calls to the same function within themselves, all of which will eventually
        // reach the base case of returning 1 since n and k are smaller by 1 in each iteration,
        // with the sum of all of them being your binomial coefficient for n and k
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n -1, k);
    }

    // 5 - Would the method used in problem 4 suffer from overlapping?
    // Eventually, yes. While it is simple math, it will eventually start to slow down when given larger and larger numbers
    // as it will need time to find the result of n and k, which is almost certainly going to repeat simple calculations
    // it has already done. 

    public static void main(String[] args) {
        // test cases
        palindromeDetector("crab");
        palindromeDetector("A man, a plan, a canal -- Panama!");
        palindromeDetector("rAcE-cAr");
        reverseNumber(-681);
        reverseNumber(981464583);
        printNumbers(-681);
        printNumbers(353541);
        System.out.println(binomialCoefficient(5, 3));
        System.out.println(binomialCoefficient(100, 90));
    }
}
