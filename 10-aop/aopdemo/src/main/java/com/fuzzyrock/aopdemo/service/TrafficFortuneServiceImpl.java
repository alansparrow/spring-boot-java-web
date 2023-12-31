package com.fuzzyrock.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
  @Override
  public String getFortune() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return "Expect heavy traffic!";
  }

  @Override
  public String getFortune(boolean tripWire) {
    if (tripWire) {
      throw new RuntimeException("Major accident! Highway is closed!");
    }

    return getFortune();
  }
}
