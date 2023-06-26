import java.util.Scanner;
import java.util.regex.Pattern;

public class AppMenu {

    Scanner scanner = new Scanner(System.in);
    String userName;

    public void greetUser() {
        System.out.println("Hello stranger! What's your name?");
        this.userName = scanner.nextLine();
    }

    public String getBirthdayDate () {
        System.out.println(this.userName + ", let's see what's your star sign. Please, enter your date of birth in format DD.MM");
        String dateOfBirth = scanner.nextLine();
        String regExPattern = "(3[01]|[12][0-9]|0[1-9])\\.(1[0-2]|0[1-9])";
        boolean matches = Pattern.matches(regExPattern, dateOfBirth);
        while (!matches) {
            System.out.println("Invalid date. Please try one more time.");
            dateOfBirth = scanner.nextLine();
            matches = Pattern.matches(regExPattern, dateOfBirth);
        }
        return dateOfBirth;
    }

    public String getDayForHoroscope () {
        System.out.println("Would you like to know your horoscope for today or tomorrow? Type today/tomorrow.");
        String day = scanner.nextLine().toLowerCase();
        boolean isValidDay = day.equals("today") || day.equals("tomorrow");
        while (!isValidDay) {
            System.out.println("Invalid day. Please type today/tomorrow.");
            day = scanner.nextLine().toLowerCase();
            isValidDay = day.equals("today") || day.equals("tomorrow");
        }
        return day;
    }

    public void printHoroscope (String dayForHoroscope, HoroscopeResponse horoscopeResponse) {
        System.out.println("The stars are saying that " + dayForHoroscope + ":\n" + horoscopeResponse.getDescription());
        System.out.println("Your mood " + dayForHoroscope + " is " + horoscopeResponse.getMood());
        System.out.println("Your color " + dayForHoroscope + " is " + horoscopeResponse.getColor());
        System.out.println("Your lucky number " + dayForHoroscope + " is " + horoscopeResponse.getLucky_number());
        System.out.println("Your lucky time " + dayForHoroscope + " is " + horoscopeResponse.getLucky_time());
        System.out.println(horoscopeResponse.getCompatibility() + " will understand you like nobody else " + dayForHoroscope);
    }

    public String getAnotherDayForHoroscope (String day) {
        String anotherDay;

        if (day.equals("today")) {
            anotherDay = "tomorrow";
        } else {
            anotherDay = "today";
        }
        return anotherDay;
    }

    public String askToContinue (String anotherDayForHoroscope) {
        System.out.println("\nWould you like also to take a look at " + anotherDayForHoroscope + "? Type yes/no");
        String answer = scanner.nextLine().toLowerCase();
        boolean isValidAnswer = answer.equals("yes") || answer.equals("no");
        while (!isValidAnswer) {
            System.out.println("Didn't get that. So yes/no?");
            answer = scanner.nextLine().toLowerCase();
            isValidAnswer = answer.equals("yes") || answer.equals("no");
        }
        return answer;
    }

    public void sayGoodbye () {
        System.out.println("\nIt was nice talking to you, " + this.userName + ". Enjoy every day, doesn't matter what the horoscope says! ;)");
    }
}
