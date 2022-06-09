package org.example.jetty6973;

import ch.qos.logback.access.jetty.RequestLogImpl;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.LifeCycle;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8180);

        RequestLogImpl requestLog = new CustomRequestLog();
        requestLog.setFileName(Main.class.getClassLoader().getResource("logback-access.xml").getFile());
        server.setRequestLog(requestLog);
        server.start();

        System.out.println("=====================");
    }

    private static class CustomRequestLog extends RequestLogImpl implements LifeCycle {
        private CustomRequestLog() {
        }
    }
}
