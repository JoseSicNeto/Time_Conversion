import java.util.InputMismatchException;
import java.util.Scanner;

																//A Specific Class About Entering Values.
class UserInput{
	Scanner scan = new Scanner(System.in);
	
	public int enterOption1() {
																//Method that Asks to Enter a Initial Measurement.
		int option1;
		do{
			while(true) {	//Loop Until You Enter a Valid Option.
				try {
					System.out.println("\nFrom which Measure of Time: ");
					System.out.println("1 - Day --- 2 - Hour --- 3 - Minute --- 4 - Second");
					System.out.print("Enter your Choice: ");
					option1 = scan.nextInt();
					break;															
				}catch(InputMismatchException e) {
					System.out.println("\nThe Value Entered is not a Number \n");
					scan.next();
				}
			}
		}while(option1 < 1 || option1 > 4);
		
		return option1;
	}	
	
	public int enterOption2() {
																//Method that Asks to Enter a Final Measure.
		int option2;
		do {	
			while(true) {	//Loop Until You Enter a Valid Option.
				try {
					System.out.println("\nTo which Measure of Time: ");
					System.out.println("1 - Day --- 2 - Hour --- 3 - Minute --- 4 - Second");
					System.out.print("Enter your Choice: ");
					option2 = scan.nextInt();
					break;
				}catch(InputMismatchException e) {									//If Enter a Non-Numeric Value.
					System.out.println("\nThe Value Entered is not a Number \n");
					scan.next();
				}
			}
		}while(option2 < 1 || option2 > 4);
		
		return option2;
	}
																//Method that Asks to Enter a Numeric Value.
	public double enterValueTime() {
		
		double valueTime;
		do {
			while(true) {	//Loop Until You Enter a Positive Value.
				try{
					System.out.println("\nEnter your Value to Transform it");
					System.out.print("Enter your Value: ");
					valueTime = scan.nextDouble();
					break;
				}catch(InputMismatchException e) {									//If Enter a Non-Numeric Value.
					System.out.println("\nThe Value Entered is not a Number \n");
					scan.next();
				}
			}
		}while(valueTime < 0);
		
		return valueTime;
	}
																//Unique Method to Close the Scanner.
	public void closeScan() {
		scan.close();    
	}
}

																//A Specific Class that Performs the Calculations.
class TimeConversion{
	double number;
											//Method that Gets the Typed Value.
	public void setTime(double _number) {
		System.out.println();
		this.number = _number;
	}
	double conversionResult;
	static final int hours_in_a_Day = 24;							//Create Constants to Improve Code Readability.
	static final int minutes_in_a_Hour = 60;
	static final int seconds_in_a_Minute = 60;
	
																//Conversion Calculations Method.
																//Day Converter.
	public void dayToHour() {
		conversionResult = number * hours_in_a_Day;
		System.out.println("You Typed " + number + " Days and It Turned into " + conversionResult + " Hours.");
	}
	
	public void dayToMinute() {
		conversionResult = (number * hours_in_a_Day) * minutes_in_a_Hour;
		System.out.println("You Typed " + number + " Days and It Turned into " + conversionResult + " Minutes.");
	}
	
	public void dayToSecond() {
		conversionResult = ((number * hours_in_a_Day) * minutes_in_a_Hour) * seconds_in_a_Minute;
		System.out.println("You Typed " + number + " Days and It Turned into " + conversionResult + " Seconds.");
	}
																//Conversion Calculations Method.
																//Hour Converter.
	public void hourToDay() {
		conversionResult = number / hours_in_a_Day;
		System.out.println("You Typed " + number + " Hours and It Turned into " + conversionResult + " Days.");
	}
	
	public void hourToMinute() {
		conversionResult = number * minutes_in_a_Hour;
		System.out.println("You Typed " + number + " Hours and It Turned into " + conversionResult + " Minutes.");
	}
	
	public void hourToSecond() {
		conversionResult = (number * minutes_in_a_Hour) * seconds_in_a_Minute;
		System.out.println("You Typed " + number + " Hours and It Turned into " + conversionResult + " Seconds.");
	}	
																//Conversion Calculations Method.
																//Minute Converter.
	public void minuteToDay() {
		conversionResult = (number / minutes_in_a_Hour) / hours_in_a_Day;
		System.out.println("You Typed " + number + " Minutes and It Turned into " + conversionResult + " Days.");
	}

	public void minuteToHour() {
		conversionResult = number / minutes_in_a_Hour;
		System.out.println("You Typed " + number + " Minutes and It Turned into " + conversionResult + " Hours.");
	}

	public void minuteToSecond() {
		conversionResult = number * seconds_in_a_Minute;
		System.out.println("You Typed " + number + " Minutes and It Turned into " + conversionResult + " Seconds.");
	}
																//Conversion Calculations Method.
																//Seconds Converter.
	public void secondToDay() {
		conversionResult = ((number / seconds_in_a_Minute) / minutes_in_a_Hour) / hours_in_a_Day;
		System.out.println("You Typed " + number + " Seconds and It Turned into " + conversionResult + " Days.");
	}

	public void secondToHour() {
		conversionResult = (number / seconds_in_a_Minute) / minutes_in_a_Hour;
		System.out.println("You Typed " + number + " Seconds and It Turned into " + conversionResult + " Houra.");
	}

	public void secondToMinute() {
		conversionResult = number / seconds_in_a_Minute;
		System.out.println("You Typed " + number + " Seconds and It Turned into " + conversionResult + " Minutes.");
	}

}

																//A Specific Class that Performs the Actions.
class Options{
	
	public void perfomaceConversion(int option1, int option2, TimeConversion converter) {	//Get the Typed Values.
	 
		if (option1 == option2) {
            System.out.println("Your Value Remains The Same.");
        } else {
            switch (option1) {
                case 1:
                    switch (option2) {
                        case 2:
                            converter.dayToHour();
                            break;
                        case 3:
                            converter.dayToMinute();
                            break;
                        case 4:
                            converter.dayToSecond();
                            break;
                    }
                    break;
                case 2:
                    switch (option2) {
                        case 1:
                            converter.hourToDay();
                            break;
                        case 3:
                            converter.hourToMinute();
                            break;
                        case 4:
                            converter.hourToSecond();
                            break;
                    }
                    break;
                case 3:
                    switch (option2) {
                        case 1:
                            converter.minuteToDay();
                            break;
                        case 2:
                            converter.minuteToHour();
                            break;
                        case 4:
                            converter.minuteToSecond();
                            break;
                    }
                    break;
                case 4:
                    switch (option2) {
                        case 1:
                            converter.secondToDay();
                            break;
                        case 2:
                            converter.secondToHour();
                            break;
                        case 3:
                            converter.secondToMinute();
                            break;
                    }
                    break;
            }
        }
	}
}

																//Run the Program.
public class TimeControl {
    public static void main(String[] args) {
    	startProgram();
    }
    
    public static void startProgram() {
    	UserInput useful = new UserInput();
    	
    	TimeConversion converter = new TimeConversion();
    	Options opts = new Options();
    															//Call the Methods of the Classes.
    	Scanner scan = new Scanner(System.in);
    	
        boolean wantToClose = false;
    	
        while (!wantToClose) {														//Create a Continuous Loop.
            System.out.println("Perform your Time Conversion:");
            
            int option1 = useful.enterOption1();
        	int option2 = useful.enterOption2();
        	
        	double numb = useful.enterValueTime();
        	
        	converter.setTime(numb);
        	opts.perfomaceConversion(option1, option2, converter);
        	
            boolean validOption = false;
            
            while (!validOption) {
                System.out.println("\nDo you want to close the program? (yes/no)");
                System.out.print("Enter your choice: ");
                String input = scan.nextLine().toLowerCase();
                																	//Closes the Loop Created or Continues it.
                if (input.equals("yes")) {
                    System.out.println("\nClosing the program...\n");
                    validOption = true;
                    wantToClose = true;
                } else if (input.equals("no")) {
                    System.out.println("\nContinue...\n");
                    validOption = true;
                } else {
                    System.out.println("\nInvalid option.\n");
                }
            }
        }

        useful.closeScan();										//Close the Scanner After Closing Loop.
        scan.close();
        System.out.println("Close the program.");
    }
}