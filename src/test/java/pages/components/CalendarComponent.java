package pages.components;

import com.codeborne.selenide.Condition;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", new Locale("en"));
        String monthName = monthFormat.format(value);
        $(".react-datepicker__year-select").selectOption("" + year);
        $(".react-datepicker__month-select").selectOption(monthName);
        $(".react-datepicker__day--0" + String.format("%02d", day))
                .shouldNotHave(Condition.text("react-datepicker__day--outside-month"))
                .click();
    }
}
