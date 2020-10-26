package com.interestcalculator.service;

import com.interestcalculator.core.PaymentPlan;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterestCalculatorService extends Remote {
  static final String SERVICE_NAME = "InterestCalculatorService";

  PaymentPlan getPaymentPlan (
          double annualInterestRate,
          int numberOfYears,
          double loanAmount
  ) throws RemoteException;

  boolean isSocialInsuranceNumberValid (int value) throws RemoteException;
  double solveSimpleOperation (double firstOperand, String operator, double secondOperand) throws RemoteException;
}
