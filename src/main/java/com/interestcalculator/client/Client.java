package com.interestcalculator.client;

import com.interestcalculator.core.PaymentPlan;
import com.interestcalculator.service.InterestCalculatorService;
import com.interestcalculator.shared.*;

import java.rmi.Naming;

public class Client {
  private InterestCalculatorService service;
  private void logStart () {
    System.out.println("Connecting to remote service.");
  }

  public Client () {
    try {
      this.logStart();
      this.service = (InterestCalculatorService) Naming.lookup(InterestCalculatorService.SERVICE_NAME);
    } catch (Exception e) {
      Utils.fatalError("Failed to connect to remote service.");
    }
  }

  public PaymentPlan getPaymentPlan (double annualInterestRate, int numberOfYears, double loanAmount) {
    try {
      return this.service.getPaymentPlan(annualInterestRate, numberOfYears, loanAmount);
    } catch (Exception e) {
      e.printStackTrace();
      Utils.fatalError("Failed to get payment plan.");
    }
    return null;
  }

  public boolean isSocialInsuranceNumberValid (int value) {
    try {
      return this.service.isSocialInsuranceNumberValid(value);
    } catch (Exception e) {
      e.printStackTrace();
      Utils.fatalError("Failed to validate social insurance number");
    }
    return false;
  }

  public double solveSimpleOperation (double firstOperand, String operator, double secondOperand) {
    try {
      return this.service.solveSimpleOperation(firstOperand, operator, secondOperand);
    } catch (Exception e) {
      e.printStackTrace();
      Utils.fatalError("Failed to solve simple operation");
    }
    return 0;
  }
}
