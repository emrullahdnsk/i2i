package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug(LocalDateTime.now().format(timeFormatter));
            }
        }, 0, 1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info(LocalDateTime.now().withSecond(0).format(timeFormatter));
            }
        }, 0, 60000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error(LocalDateTime.now().withMinute(0).withSecond(0).format(timeFormatter));
            }
        }, 0, 3600000);
    }
}