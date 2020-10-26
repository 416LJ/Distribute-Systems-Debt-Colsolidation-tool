package com.interestcalculator.core;

import java.io.Serializable;

public class SocialInsuranceNumber implements Serializable {
  private static final long serialVersionUID = 1L;

  public static boolean isValid(int value) {
    if (value < 0 || value < 99999999 || value > 999999998) return false;

    int checksum = 0;
    for (int i = 4; i != 0; i--) {
      checksum += value % 10;
      value /= 10;

      int addend = 2 * (value % 10);
      if (addend >= 10) addend -= 9;
      checksum += addend;
      value /= 10;
    }

    return (checksum + value) % 10 == 0;
  }
}
