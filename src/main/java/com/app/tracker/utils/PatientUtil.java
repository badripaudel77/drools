package com.app.tracker.utils;

import com.app.tracker.models.Address;
import com.app.tracker.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * For handling customer user related demo data and other helper methods
 */
public class PatientUtil {

    private static Logger logger = LoggerFactory.getLogger(PatientUtil.class);

    public static List<Patient> getAllPatient() {
        return List.of(
               new Patient(11, "Shyam", new Address(11, "Swachha Marga", 1100, "Nepal")),
               new Patient(21, "Hari", new Address(11, "KTM Road", 1100, "Nepal")),
               new Patient(31, "Ram", new Address(22, "Unnati Marga", 2200, "Nepal")),
               new Patient(41, "Jadeja", new Address(33, "Head Road", 3300, "India")),
               new Patient(51, "Hathy", new Address(56, "The Hybrid Road", 5600, "India"))
        );
    }

}
