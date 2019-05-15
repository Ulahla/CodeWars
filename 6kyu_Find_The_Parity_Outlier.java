//  You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array 
//  is either entirely comprised of odd integers or entirely comprised of even integers except for a single 
//  integer N. Write a method that takes the array as an argument and returns this "outlier" N.
//  Examples
//  
//  [2, 4, 0, 100, 4, 11, 2602, 36]
//  Should return: 11 (the only odd number)
//
//  [160, 3, 1719, 19, 11, 13, -21]
//  Should return: 160 (the only even number)

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;


public class FindOutlier {
  static int find(int[] integers) {
    if(integers.length < 3) {
      return -1;
    }
    
    List<Integer> list = Arrays.stream(integers)
                               .boxed()
//                               .parallel()                  //I don't think the array will be large enough to use parallel
                               .filter(x -> x % 2 == 0)
                               .limit(3)
                               .collect(Collectors.toList());
    
    if (list.size() <= 1) {
      return list.get(0).intValue();
    }
    else {
      return Arrays.stream(integers)
//                   .parallel()                  //I don't think the array will be large enough to use parallel                  
                   .filter(x -> x % 2 != 0)
                   .findFirst()
                   .getAsInt();
    }
  }
}

// FIRST SOLUTION
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import java.util.*;
//
//  public class FindOutlier {
//    static int find(int[] integers) {
//      List<Integer> list = Arrays.stream(integers).boxed().filter(x -> x % 2 == 0).collect(Collectors.toList());
//
//      if (list.size() == 1) {
//        return list.get(0).intValue();
//      }
//      else {
//        return Arrays.stream(integers).filter(x -> x % 2 != 0).findAny().getAsInt();
//      }
//    }
//  }
