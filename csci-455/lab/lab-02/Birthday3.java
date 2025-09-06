import java.time.LocalDate;
import java.util.Scanner;

class Birthday3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your birth month [1..12]: ");
        int month = sc.nextInt();

        System.out.print("Enter your birth day of month: ");
        int day = sc.nextInt();

        System.out.print("Enter your birth year [4-digit year]: ");
        int year = sc.nextInt();

        // System.out.println(month + "/" + day + "/" + year);

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        // System.out.println(birthday);

        if (birthday.getYear() > currentDate.getYear()) {
            System.out.println("Your birthday has not yet happened this year.");
        } else if (birthday.getMonthValue() == currentDate.getMonthValue() &&
                birthday.getDayOfMonth() > currentDate.getDayOfMonth()) {
            System.out.println("Your birthday has not yet happened this year.");
        } else if (birthday.getMonthValue() < currentDate.getMonthValue()) {
            System.out.println("Your birthday has already happened this year.");
        } else {
            System.out.println("Your birthday has already happened this year.");
        }
    }
}
