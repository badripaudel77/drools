package com.app.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author : Badri Paudel
 * @Company : Cotiviti Nepal
 * @Post : Software Engineer
 */

@SpringBootApplication
public class TrackerApplication {
    static Logger logger = LoggerFactory.getLogger(TrackerApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TrackerApplication.class, args);
        logger.info(">>> TrackerApplication is up and running at >>> " + System.currentTimeMillis());
    }


}
