import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HoroscopeConverter {

    private String addYearToDate (String dateString) {
        return dateString + ".1904";
    }

    private LocalDate parseStringToDate (String date) {
        String fullDateString = addYearToDate(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.getDefault());
        return LocalDate.parse(fullDateString, formatter);
    }

    public String getStarSign (String date) {
        LocalDate parsedDate = parseStringToDate(date);
        if (parsedDate.isAfter(LocalDate.of(1904, 3, 20)) && parsedDate.isBefore(LocalDate.of(1904, 4, 20))) {
            return "Aries";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 4, 19)) && parsedDate.isBefore(LocalDate.of(1904, 5, 21))) {
            return "Taurus";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 5, 20)) && parsedDate.isBefore(LocalDate.of(1904, 6, 21))) {
            return "Gemini";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 6, 20)) && parsedDate.isBefore(LocalDate.of(1904, 7, 23))) {
            return "Cancer";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 7, 22)) && parsedDate.isBefore(LocalDate.of(1904, 8, 23))) {
            return "Leo";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 8, 22)) && parsedDate.isBefore(LocalDate.of(1904, 9, 23))) {
            return "Virgo";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 9, 22)) && parsedDate.isBefore(LocalDate.of(1904, 10, 23))) {
            return "Libra";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 10, 22)) && parsedDate.isBefore(LocalDate.of(1904, 11, 22))) {
            return "Scorpio";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 11, 21)) && parsedDate.isBefore(LocalDate.of(1904, 12, 22))) {
            return "Sagittarius";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 12, 21)) && parsedDate.isBefore(LocalDate.of(1904, 1, 20))) {
            return "Capricorn";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 1, 19)) && parsedDate.isBefore(LocalDate.of(1904, 2, 19))) {
            return "Aquarius";
        } else if (parsedDate.isAfter(LocalDate.of(1904, 2, 18)) && parsedDate.isBefore(LocalDate.of(1904, 3, 21))) {
            return "Pisces";
        } else {
            return "Invalid star sign";
        }
    }
}

//        Aries—March 21-April 19.
//        Taurus—April 20-May 20.
//        Gemini—May 21-June 20.
//        Cancer—June 21-July 22.
//        Leo—July 23-August 22.
//        Virgo—August 23-September 22.
//        Libra—September 23-October 22.
//        Scorpio—October 23-November 21.
//        Sagittarius—November 22-December 21
//        Capricorn—December 22-January 19
//        Aquarius—Jan 20-Feb 18
//        Pisces—Feb 19-March 20
