package com.app.tracker.utils;

import com.app.tracker.models.Disease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * For handling customer user related demo data and other helper methods
 */
public class DiseasesUtil {

    private static Logger logger = LoggerFactory.getLogger(DiseasesUtil.class);

    public static List<Disease> getAllDiseases() {
        return List.of(
                new Disease(100, "Diabetes", true, StatusEnum.SEVERE),
                new Disease(200, "Fever", false, StatusEnum.NORMAL),
                new Disease(300, "Dengue", false, StatusEnum.NORMAL),
                new Disease(300, "Hypothyroidism", true, StatusEnum.SEVERE)
        );
    }
}
