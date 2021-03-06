/**@autor AonoZan Dejan Petrovic 2016 �
 */
package zadaci_03_08_2016;

public class Zadatak_02 {
	/**
	 * Method that reads only double or int values values from console.
	 * If something else is entered an exception is raised.
	 * @param number this is needed to tell Java that we need double value from user
	 * @return double value
	 * @throws Exception This is raised if user enters string or character
	 */
	public static double readFromConsole(double number) throws Exception{
		// gather input
		String consoleInput = zadaci_01_08_2016.Zadatak_02.userInput.nextLine().trim();
		// if only whitespaces are entered raise exception
		if (consoleInput.length() < 1) throw new Exception("Empty input.(whitespace)");
		// try to parse double from first word (splited string)
		try {
			number = Double.valueOf(consoleInput.split(" ")[0]);
		// if error occurs throw specific exception to tell what happened
		} catch (Exception e) {
			throw new Exception("Input is not a decimal number.");
		}
		return number;
	}
	/**
	 * Method to make easy entering lots of decimal values from console.
	 * Pass list of any size and list will be updated with new values.
	 * Method asks user for values unil it update every value in list.
	 * @param list to be filled with values
	 * @return list that has user entered values
	 */
	public static double[] fillListFromConsoleInput(double[] list) {
		// chack if passed list has value
		if (list == null) {
			System.out.println("Cant fill list that has no values or is null.(null is returned)");
			return null;
		}
		// set default values
		double inputNumber = 1;
		// loop trough whole list
		System.out.printf("Enter %d decimal value%s:\n", list.length, list.length > 1 ? "'s" : "" );
		for (int i = 0; i < list.length; i++) {
			// try to get right value from user
			try {
				System.out.printf("Enter %d value: ", (i + 1));
				inputNumber = readFromConsole(inputNumber);
				list[i] = inputNumber;
			// if error occurs print message
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// return cleaned list from zeroes(empty values)
		return list;
	}
	/**
	 * Method for printing list of elements. Useful for debug.
	 * @param list of elements
	 */
	public static void printList(double[] list){
		// make sure list is not null
		if (list != null) {
			// print all elements except last one with comma separated
			for (int i = 0; i < list.length-1; i++) {
				System.out.printf("%.2f, ", list[i]);
			}
			// print last element, add dot sign and switch to new line
			System.out.printf("%.2f.", list[list.length-1]);
		// if it is throw exception with message
		} else {
			System.out.println("Cant print list that has null value.");
		}
	}
	/**
	 * Method for finding lowest value in list.
	 * Whole list is searched and last value that is lowest or equal to every other lowest is returned.
	 * @param array list of double values
	 * @return 0 if list is empty or null, lower value if list contains values
	 */
	public static double min(double[] array) {
		// check if list contains anything and return 0 if it doesn't
		if (array == null) {
			System.out.println("List is empty or null.(0 is returned)");
			return 0;
		// if list contains only one item return it immediately
		} else if (array.length == 1) return array[0];
		// set possible minimal value to first one in the list
		double min = array[0];
		// loop trough every item and update min if necessary
		for (double d : array) {
			if (min > d) min = d;
		}
		return min;
	}
	/**
	 * Main method that creates list of decimal values and fills it with values from console until 0 is inserted.
	 * And then prints lowest decimal value in the list.
	 * @param args
	 */
	public static void main(String[] args) {
		// create list and fill it with values that user provides
		double[] userNumbers = fillListFromConsoleInput(new double[10]);
//		// try to print list
//		printList(userNumbers);
		// print lowest decimal in list
		System.out.printf("Lowest value taken from console is %.2f.", min(userNumbers));
		// close Scanner
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
