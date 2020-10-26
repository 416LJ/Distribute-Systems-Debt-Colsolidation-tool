package com.interestcalculator.server;

import com.interestcalculator.service.InterestCalculatorService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
  static final int PORT = 1099;

  private void logStart () {
    System.out.println("RMI registry is running on port "+PORT);
  }

  public void start () {
    try {
      Registry registry = LocateRegistry.createRegistry(PORT);
      this.logStart();

      // Bind service to Registry
      InterestCalculatorService service = new InterestCalculatorServiceImpl();
      registry.bind(InterestCalculatorService.SERVICE_NAME, service);
    } catch (Exception e) {
      System.out.println("Failed to start server");
      e.printStackTrace();
    }
  }
}
