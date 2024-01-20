package com.app.tracker.utils;

import com.app.tracker.models.Company;
import com.app.tracker.models.CompanySize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * For handling customer user related demo data and other helper methods
 */
public class CompanyUtil {

    private static Logger logger = LoggerFactory.getLogger(CompanyUtil.class);

    public static List<Company> getAllCompany() {
        return List.of(
                new Company(200, "INFINITE", CompanySize.EXTRA_LARGE,17_000),
                new Company(300, "GOOGLE", CompanySize.EXTRA_LARGE,10_000),
                new Company(400, "MICROSOFT", CompanySize.EXTRA_LARGE,12_000),
                new Company(100, "COTIVITI NEPAL", CompanySize.MEDIUM,600),
                new Company(100, "ESEWA", CompanySize.SMALL,200)
        );
    }
}
