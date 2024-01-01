package com.app.tracker.utils;

import com.app.tracker.models.CustomerUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * For handling customer user related demo data and other helper methods
 */
public class CustomerUserUtil {


    private static Logger logger = LoggerFactory.getLogger(CustomerUserUtil.class);

    public static List<CustomerUser> getAllCustomerUsers() {
        return List.of(
                new CustomerUser(100, "demo-user-100", LocalDate.now().plusDays(100), false, LocalDateTime.now(), "VALID"),
                new CustomerUser(200, "demo-user-200", LocalDate.now().plusDays(20), false, LocalDateTime.now(), "INVALID"),
                new CustomerUser(300, "demo-user-300", LocalDate.now().plusMonths(1), true, LocalDateTime.now(), "VALID"),
                new CustomerUser(400, "demo-user-400", LocalDate.now(), false, LocalDateTime.now(), "VALID"),
                new CustomerUser(500, "demo-user-500", LocalDate.now(), false, LocalDateTime.now(), "ACTION_REQUIRED"),
                new CustomerUser(600, "demo-user-600", LocalDate.now(), false, LocalDateTime.now(), "INVALID"),
                new CustomerUser(800, "demo-user-800", null, false, LocalDateTime.now(), "ACTION_REQUIRED"),
                new CustomerUser(700, "demo-user-700", LocalDate.now(), true, LocalDateTime.now(), "ACTION_REQUIRED")
        );
    }

   public static boolean compareDate(LocalDate createdAt, LocalDate nowDate) {
        boolean isCreatedDateAfterNowDate = createdAt.isAfter(nowDate);
        // logger.info("Comparing : " + createdAt + " is after " + nowDate + " => "  + isCreatedDateAfterNowDate);
        System.out.println("Comparing : " + createdAt + " is after " + nowDate + " => "  + isCreatedDateAfterNowDate);
        return isCreatedDateAfterNowDate;
   }

    public static boolean logTheMessage(String message) {
        System.out.println("Logging ::: " + message);
        return message.length() >= 1;
    }

}
