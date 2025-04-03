package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	@ParameterizedTest
	@CsvSource({"9999999, false", "9991234567, true", "9001234567, true", "8881234567, true", "8001234567, true", "9111234567, true", "4111234567, true", "7704433010, false"})
	void test(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checking if number was reported as valid");
	}
	
	@Test
    void testIdentifySpam_InvalidNumber_ThrowsException() {
        TelephoneChecker checker = new TelephoneChecker();

        long invalidNumber = 999999L; // Assuming this is an invalid format

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            checker.identifySpam(invalidNumber);
        });

        assertEquals("Invalid phone number format.", exception.getMessage());
    }
		
}
