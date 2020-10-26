package com.interestcalculator.client;

import com.interestcalculator.shared.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {
  private String text;
  private boolean inline = false;
  private boolean exitOnError = false;
  BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

  public Prompt (String text) {
    this.text = text;
  }

  public Prompt (String text, boolean inline) {
    this.text = text;
    this.inline = inline;
  }

  public Prompt (String text, boolean inline, boolean exitOnError) {
    this.text = text;
    this.inline = inline;
    this.exitOnError = exitOnError;
  }

  private void printText () {
    if (inline) {
      System.out.print(text+": ");
    } else {
      System.out.println(text);
      System.out.print("(Press enter to submit after entering option) ");
    }
  }

  private String readResponse () {
    try {
      String response = inputReader.readLine();
      return response;
    } catch (IOException e) {
      Utils.fatalError("Failed to read input "+e);
    }
    return null;
  }

  private String getResponse () {
    printText();
    return readResponse();
  }

  private void invalidResponse (String response) {
    String message = "Invalid input: " + response;
    if (exitOnError) {
      Utils.fatalError(message);
    } else {
      System.out.println(message);
    }
  }

  public int getInt () {
    String response = getResponse();
    try {
      return Integer.parseInt(response);
    } catch (NumberFormatException e) {
      invalidResponse(response);
      return -1;
    }
  }

  public double getDouble () {
    String response = getResponse();
    try {
      return Double.parseDouble(response);
    } catch (NumberFormatException e) {
      invalidResponse(response);
      return -1;
    }
  }

  public String getString () {
    return getResponse();
  }
}