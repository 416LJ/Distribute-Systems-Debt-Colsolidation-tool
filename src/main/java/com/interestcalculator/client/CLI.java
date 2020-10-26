package com.interestcalculator.client;

import com.interestcalculator.core.PaymentPlan;
import com.interestcalculator.shared.Utils;

public class CLI {
  private final Client client;

  public CLI (Client client) {
    this.client = client;
  }

  private void print (String text) {
    System.out.println(text);
  }

  private void divider () {
    print("\n============================================\n");
  }

  private void title () {
    print("Interest Calculator v1");
  }

  private void mainMenu () {
    divider();
    String text = new StringBuilder()
        .append("Main Menu:\n")
        .append("Enter the number associated to the option:\n")
        .append("1. Calculate Interest\n")
        .append("2. Validate Social Insurance Number\n")
        .append("3. Perform Simple Calculation\n")
        .append("0. Exit\n")
        .toString();

    Prompt prompt = new Prompt(text);
    int optionCode = prompt.getInt();

    // Invalid input, reprompt
    if (optionCode == -1) mainMenu();

    menuOption(optionCode);
  }

  private void menuOption (int optionCode) {
    switch (optionCode) {
      case 0:
        exit();
        break;
      case 1:
        paymentForm();
        break;
      case 2:
        validateSINForm();
        break;
      case 3:
        calculatorForm();
        break;
      default:
        System.out.println("Invalid option: "+optionCode);
        mainMenu();
    }
  }

  private void exit () {
    print("\n\nBye!");
    Utils.exit();
  }

  private void calculatorForm () {
    divider();
    print("\n\nPayment Form:");

    Prompt firstOperandPrompt = new Prompt("First Operand", true, true);
    Prompt operatorPrompt = new Prompt("Operator",true, true);
    Prompt secondOperandPrompt = new Prompt("Second Operand", true, true);

    double firstOperand = firstOperandPrompt.getDouble();
    String operator = operatorPrompt.getString();
    double secondOperand = secondOperandPrompt.getDouble();

    calculatorResult(firstOperand, operator, secondOperand);
  }

  private void calculatorResult (
    double firstOperand,
    String operator,
    double secondOperand
  ) {
    divider();
    double result = client.solveSimpleOperation(firstOperand, operator, secondOperand);
    print(firstOperand+" "+operator+" "+secondOperand+" = "+result);
    mainMenu();
  }

  private void paymentForm () {
    divider();
    print("\n\nPayment Form:");

    Prompt annualInterestRatePrompt = new Prompt("Annual interest rate", true, true);
    Prompt numberOfYearsPrompt = new Prompt("Number of years", true, true);
    Prompt loanAmountPrompt = new Prompt("Loan amount",true, true);

    double annualInterestRate = annualInterestRatePrompt.getDouble();
    int numberOfYears = numberOfYearsPrompt.getInt();
    double loanAmount = loanAmountPrompt.getDouble();

    PaymentPlan paymentPlan = client.getPaymentPlan(annualInterestRate, numberOfYears, loanAmount);
    paymentPlan(paymentPlan);
  }

  private void validateSINForm () {
    divider();
    print("\n\nSIN Validation:");

    Prompt sinPrompt = new Prompt("Social Insurance Number", true, true);
    int sin = sinPrompt.getInt();

    boolean isSocialInsuranceNumberValid = client.isSocialInsuranceNumberValid(sin);
    sinValidationResult(isSocialInsuranceNumberValid);
  }

  private void sinValidationResult(boolean isSocialInsuranceNumberValid) {
    divider();
    if (isSocialInsuranceNumberValid) {
      print("Valid");
    } else {
      print("Invalid");
    }

    mainMenu();
  }

  private void paymentPlan (PaymentPlan paymentPlan) {
    divider();
    print("Payment Plan:");
    print("Monthly Payment: "+paymentPlan.monthlyPayment());
    print("Total Payment: "+paymentPlan.totalPayment());

    mainMenu();
  }

  public void run () {
    title();
    mainMenu();
  }
}
