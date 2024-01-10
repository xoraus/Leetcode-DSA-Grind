import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        String[] dateParts = date.split("-");
        int Y = Integer.parseInt(dateParts[0]);
        int M = Integer.parseInt(dateParts[1]);
        int D = Integer.parseInt(dateParts[2]);

        LocalDate inputDate = LocalDate.of(Y, M, D);
        LocalDate startOfYear = LocalDate.of(Y, 1, 1);

        return (int) (inputDate.toEpochDay() - startOfYear.toEpochDay()) + 1;
    }
}