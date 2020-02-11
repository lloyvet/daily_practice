package A;

import java.time.Year;
import java.util.Calendar;

public class _01世纪末的星期 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int year = 1999; year < 100000000 ; year+=100) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,11);
            calendar.set(Calendar.DAY_OF_MONTH,31);
            System.out.println(year+" "+calendar.get(Calendar.DAY_OF_WEEK));
            if(calendar.get(Calendar.DAY_OF_WEEK)==1){
                System.out.println(year);
                break;
            }
        }
    }
}
