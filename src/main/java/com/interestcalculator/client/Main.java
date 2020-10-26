package com.interestcalculator.client;

public class Main {
  public static void main(String[] args) {
    Client client = new Client();
    CLI cli = new CLI(client);
    cli.run();
  }
}
