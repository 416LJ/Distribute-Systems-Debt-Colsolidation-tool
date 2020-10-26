package com.interestcalculator.server;

import com.interestcalculator.core.SimpleCalculator;
import com.interestcalculator.core.SocialInsuranceNumber;
import com.interestcalculator.service.InterestCalculatorService;
import com.interestcalculator.core.PaymentPlan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterestCalculatorServiceImpl extends UnicastRemoteObject implements InterestCalculatorService {
  private static final long serialVersionUID = 1L;

  protected InterestCalculatorServiceImpl() throws RemoteException {
    super();
  }

  @Override
  public PaymentPlan getPaymentPlan(double annualInterestRate, int numberOfYears, double loanAmount) throws RemoteException {
    return new PaymentPlan(
            annualInterestRate,
            numberOfYears,
            loanAmount
    );
  }

  @Override
  public boolean isSocialInsuranceNumberValid(int value) throws RemoteException {
    return SocialInsuranceNumber.isValid(value);
  }
  @Override
  public double solveSimpleOperation (double firstOperand, String operator, double secondOperand) throws RemoteException {
    return SimpleCalculator.solve(firstOperand, operator, secondOperand);
  };
}
