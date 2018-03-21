package com.gordianyuan.simplecrashserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @Autowired
  private Environment environment;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/ping")
  public String ping() {
    String localServerPort = environment.getProperty("local.server.port");
    if (localServerPort.equals("3200")) {
      try {
        // simulation crash
        Thread.sleep(3000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return "pong";
  }

}
