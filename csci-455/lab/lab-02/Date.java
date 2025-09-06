import java.time.LocalDate;

class Date {
  public static void main(String[] args) {
    LocalDate myDate = LocalDate.of(1995, 1, 20);

    System.out.println(myDate.getMonthValue() + "/" + myDate.getDayOfMonth() + "/" + myDate.getYear());
    myDate = myDate.plusDays(20);
    System.out.println(myDate.getMonthValue() + "/" + myDate.getDayOfMonth() + "/" + myDate.getYear());
  }
}
