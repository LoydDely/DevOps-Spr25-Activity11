package edu.westga.comp4420.junit_sample.model;

public class TelephoneChecker {
	
	
	/** Verifies that the provided number is a valid phone number.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number is a valid phone number
	 * 			false	if number is not a valid phone number
	 */
	public boolean verifyNumber(long number) {
		if (number < 1000000L) {
			return false;
		} else if (number <= 9999999L) {
			return true;
		} else if (number < 1000000000L) {
			return false;
		} else {
			return number <= 9999999999L;
		} 
	}
	
	/** Identifies if a provided phone number is potential spam based on the area code.
	 * The following area codes should be reported as potential spam:
	 * 	999
	 * 	900
	 * 	888
	 * 	800
	 * 	911
	 * 	411
	 * 
	 * @precondition number if a valid phone number
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number matches heuristics for potential spam
	 * 			false	if number does not match heuristics for potential spam
	 */
	public boolean identifySpam(long number) {
		String numStr = String.valueOf(number);
		String areaCode = numStr.substring(0, 3);
		if (!this.verifyNumber(number)) {
			throw new IllegalArgumentException("Invalid phone number format.");
		} 
		if (number <= 9999999) {
			return false;
		} else if (areaCode.equals("999")) {
			return true;
		} else if (areaCode.equals("900")) {
			return true;
		} else if (areaCode.equals("888")) {
			return true;
		} else if (areaCode.equals("800")) {
			return true;
		} else if (areaCode.equals("911")) {
			return true;
		} else if (areaCode.equals("411")) {
			return true;
		} 
		return false;
	}
}
