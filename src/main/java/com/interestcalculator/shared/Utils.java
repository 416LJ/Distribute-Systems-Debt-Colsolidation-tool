package com.interestcalculator.shared;

public class Utils {
  public static void fatalError (String message) {
    System.err.println(message);
    System.exit(1);
  }

  public static void exit () {
    System.exit(0);
  }
}
