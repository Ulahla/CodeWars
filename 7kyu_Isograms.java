//  An isogram is a word that has no repeating letters, consecutive or non-consecutive. 
//  Implement a function that determines whether a string that contains only letters is an isogram. 
//  Assume the empty string is an isogram. Ignore letter case.
//
//  isIsogram "Dermatoglyphics" == true
//  isIsogram "moose" == false
//  isIsogram "aba" == false

import java.util.*;

public class isogram {
    public static boolean isIsogram(String str) {
      return str.length() == str.toLowerCase().chars().distinct().count();
    }
}

// FIRST SOLUTION WAS:

//  public class isogram {
//    public static boolean isIsogram(String str) {
//
//      char[] strAsCharArray = str.toLowerCase().toCharArray();
//      Set<Character> chars = new HashSet<>();
//      for (int i = 0; i < strAsCharArray.length ; i++) {
//        if(chars.contains(strAsCharArray[i])) {
//          return false;
//        }
//        else {
//          chars.add(strAsCharArray[i]);
//        }
//      }
//      return true;
//    }
//  }
  
