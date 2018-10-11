package hu.martinfejes.api.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to validate {@link Email} addresses.
 *
 * @author Martin Fejes
 */
public class EmailValidator {
	
	private static String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	
	/**
	 * Checks if the input parameter matches the regex pattern.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validate(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
	}
}
