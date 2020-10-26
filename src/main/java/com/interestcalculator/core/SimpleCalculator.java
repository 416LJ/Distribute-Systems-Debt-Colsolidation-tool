package com.interestcalculator.core;

import java.io.Serializable;

public class SimpleCalculator implements Serializable {
  private static final long serialVersionUID = 1L;

  public static double solve (double firstOperand, String operator, double secondOperand) {
    double result;

    switch(operator) {
      case "+":
        result = firstOperand + secondOperand;
        break;

      case "-":
        result = firstOperand - secondOperand;
        break;

      case "*":
        result = firstOperand * secondOperand;
        break;

      case "/":
        result = firstOperand / secondOperand;
        break;

      // operator doesn't match any case constant (+, -, *, /)
      default:
        throw new RuntimeException("Invalid Operator: "+operator);
    }

    return result;
  }
}
