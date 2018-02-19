package com.team2915.SER_CHUNKY.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

  public static void logTXT(String path, String message) {
    System.out.println(message);
    try {
      FileOutputStream fos = new FileOutputStream(new File(path), true);
      PrintWriter pm = new PrintWriter(fos);
      pm.println(message + new Date().toString());
      pm.close();
    }catch (Exception e){
      System.out.println("Unable to log error, " + e.getMessage());
    }
  }

  public static void logCSV(String path, String line) throws IOException {
    FileOutputStream fos = new FileOutputStream(new File(path), true);
    PrintWriter pm = new PrintWriter(fos);
    pm.println(line);
    pm.close();
  }

}
