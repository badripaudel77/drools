package com.app.tracker.utils;

import com.app.tracker.models.TestClaim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * For handling customer user related demo data and other helper methods
 */
public class TestClaimUtil {

    private static Logger logger = LoggerFactory.getLogger(TestClaimUtil.class);

    public static List<TestClaim> getAllTestClaim() {
        return List.of(
                new TestClaim(-1, 0, "INVALID_TEST", null),
                new TestClaim(1, 100, "FINGER_SURGERY", LocalDate.now().minusMonths(3)),
                new TestClaim(2, 200, "LEG_SURGERY", LocalDate.now().minusMonths(3)),
                new TestClaim(4, 300, "ECG_TEST", LocalDate.now().minusMonths(3)),
                new TestClaim(5, 300, "ECG_TEST", LocalDate.now().plusMonths(3)),
                new TestClaim(3, 400, "BRAIN_TEST", LocalDate.now().plusMonths(2))
        );
    }
}
