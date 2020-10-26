package com.interestcalculator.core;

import java.io.Serializable;

public class PaymentPlan implements Serializable {
  private static final long serialVersionUID = 1L;

  private final double annualInterestRate;
  private final double monthlyInterestRate;
  private final int numberOfYears;
  private final double loanAmount;

  public PaymentPlan (
      double annualInterestRate,
      int numberOfYears,
      double loanAmount
  ) {
    this.annualInterestRate = annualInterestRate;
    this.monthlyInterestRate = annualInterestRate / 1200;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
  }

  public double monthlyPayment () {
    double payment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    return payment;
  }

  public double totalPayment () {
    return monthlyPayment() * numberOfYears * 12;
  }
}
