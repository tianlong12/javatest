import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

class SimpleDaemons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                //logger.info("run..");
                System.out.println("run......");
            }
        } catch (InterruptedException e) {
           // logger.info("sleep() interrupted");
            System.out.println("sleep() interrupted");
        }
    }
}

public class MainThread {
    //Logger logger = LoggerFactory.getLogger(MainThread.class);


    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        //logger.info("All daemons started");
        System.out.println("All daemons started");
    }
}