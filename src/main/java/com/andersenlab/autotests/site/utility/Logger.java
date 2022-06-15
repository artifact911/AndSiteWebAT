package com.andersenlab.autotests.site.utility;

import java.time.format.DateTimeFormatter;

public final class Logger {
    private int counter;
    private static Logger instance;

    private Logger() {
        if (instance != null) throw new RuntimeException();
    }

    public void log(String str, boolean isErr) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        final String methodName = (stack[2].getMethodName().equalsIgnoreCase("log")) ? stack[3].getMethodName() : stack[2].getMethodName();
        //final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String dateStr = java.time.LocalTime.now().format(dtf);
        dateStr = dateStr.substring(0, dateStr.indexOf(' ')) + ":" + dateStr.substring(dateStr.indexOf(' ') + 1);
        String threadName = Thread.currentThread().getName();
        if (isErr) {
            System.err.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        } else {
            System.out.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        }
    } //log (String, boolean)

    public void log(String str){
        log(str, true);
    }

    public static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) instance = new Logger();
            }
        }
        return instance;
    }//getLogger

} //class
