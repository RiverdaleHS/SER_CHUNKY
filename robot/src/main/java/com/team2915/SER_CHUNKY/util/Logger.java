package com.team2915.SER_CHUNKY.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

  //TODO: add scripts for pulling these off.  FILE THAT LISTS FILES FOR GRABBER TO PULL?

  public static void logTXT(String path, String message) {
    System.out.println(message);
    try {
      FileOutputStream fos = new FileOutputStream(new File(path), true);
      PrintWriter pm = new PrintWriter(fos);
      pm.println(message + new Date().toString());
      pm.close();
    } catch (Exception e) {
      System.out.println("Unable to log txt, " + e.getMessage());
    }
  }

  public static void logCSV(String path, String line) {
    System.out.print(line);
    try {
      FileOutputStream fos = new FileOutputStream(new File(path), true);
      PrintWriter pm = new PrintWriter(fos);
      pm.println(line);
      pm.close();
    } catch (Exception e) {
      System.out.println("Unable to log csv, " + e.getMessage());
    }

  }

}
