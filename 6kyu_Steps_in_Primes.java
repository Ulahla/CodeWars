//  The prime numbers are not regularly spaced. For example from 2 to 3 the step is 1. From 3 to 5 the step is 2. 
//  From 7 to 11 it is 4. Between 2 and 50 we have the following pairs of 2-steps primes:
//
//      3, 5 - 5, 7, - 11, 13, - 17, 19, - 29, 31, - 41, 43
//
//  We will write a function step with parameters:
//
//  g (integer >= 2) which indicates the step we are looking for,
//
//  m (integer >= 2) which gives the start of the search (m inclusive),
//
//  n (integer >= m) which gives the end of the search (n inclusive)
//
//  In the example above step(2, 2, 50) will return [3, 5] which is the first pair between 2 and 50 with a 2-steps.
//
//      So this function should return the first pair of the two prime numbers spaced with a step of g between the limits 
//      m, n if these g-steps prime numbers exist otherwise nil or null or None or Nothing or [] or "0, 0" or {0, 0} 
//      (depending on the language).
//
//  #Examples:
//
//  step(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7} or "5 7"
//
//  step(2, 5, 5) --> nil or ... or [] in Ocaml or {0, 0} in C++
//
//  step(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}
//
//  See more examples for your language in "RUN"
//
//  Remarks:
//
//      ([193, 197] is also such a 2-steps primes between 130 and 200 but it's not the first pair).
//
//  step(6, 100, 110) --> [101, 107] though there is a prime between 101 and 107 which is 103; the pair 101-103 is a 2-step.
//
// #Notes: 
//
//  The idea of "step" is close to that of "gap" but it is not exactly the same. For those interested they can have a look
//  at http://mathworld.wolfram.com/PrimeGaps.html.
//
//  A "gap" is more restrictive: there must be no primes in between (101-107 is a "step" but not a "gap". Next kata will be
//  about "gaps":-).
//
//  For Go: nil slice is expected when there are no step between m and n. Example: step(2,4900,4919) --> nil

// This still needs improvement, but thaught me something about primes! 
// Took me some time to optimize the prime generation - it worked but was too slow. 
import java.util.*;
class StepInPrimes {
  private static List<Long> primes = new ArrayList<>();
  static {
    primes.add(2L);
    primes.add(3L);
  }
  
  public static long[] step(int g, long m, long n) {
    while (primes.get(primes.size()-1) <= m) {
      generateNextPrime();
    }
    long p1 = findFirstPrimeGreaterThan(m);
    while (p1 + g < n) {
      if(p1 + g > primes.get(primes.size() -1)) {
        generateNextPrime();
      }
      if (primes.contains(p1 + g)) {
        return new long[]{p1, p1+g};
      }
      p1 = primes.get(primes.indexOf(p1)+1);
    }
    return null;
  }
    
  private static long findFirstPrimeGreaterThan(long m) {
    for (long prime : primes) {
      if (prime >= m) return prime;
    }
    return primes.get(0);
 }
    
  private static long generateNextPrime() {
    long primeCandidate = (primes.get(primes.size()-1)) + 2;
    while (!isPrime(primeCandidate)) {
      primeCandidate +=2;
    }
    primes.add(primeCandidate);
    return primeCandidate;
 }

  private static boolean isPrime(long primeCandidate) {
    long limit = (long)Math.ceil(Math.sqrt(primeCandidate));
    for (long prime : primes) {
      if (primeCandidate % prime == 0) {
        return false;
      }
      if(prime > limit) {
        return true;
      }
    }
    return true;
  }
}
