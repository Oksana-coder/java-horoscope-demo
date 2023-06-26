import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AppMenu appMenu = new AppMenu();
        appMenu.greetUser();

        String dateOfBirth = appMenu.getBirthdayDate();
        HoroscopeConverter horoscopeConverter = new HoroscopeConverter();
        String starSign = horoscopeConverter.getStarSign(dateOfBirth);
        System.out.println("So, " + appMenu.userName + ", your date of birth is " + dateOfBirth + ". It means that you were born under the sign of " + starSign);

        String dayForHoroscope = appMenu.getDayForHoroscope();
        HoroscopeClient horoscopeClient = new HoroscopeClient();
        HoroscopeResponse horoscopeResponse = horoscopeClient.getData(starSign, dayForHoroscope);
        appMenu.printHoroscope(dayForHoroscope, horoscopeResponse);

        String anotherDayForHoroscope = appMenu.getAnotherDayForHoroscope(dayForHoroscope);
        String oneMoreHoroscope = appMenu.askToContinue(anotherDayForHoroscope);

        if (oneMoreHoroscope.equals("yes")) {
            HoroscopeResponse horoscopeResponseTwo = horoscopeClient.getData(starSign, anotherDayForHoroscope);
            appMenu.printHoroscope(anotherDayForHoroscope, horoscopeResponseTwo);
       }

        appMenu.sayGoodbye();
    }
}
