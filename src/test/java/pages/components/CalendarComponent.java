package pages.components;

import com.codeborne.selenide.Condition;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.randomDate;


public class CalendarComponent {
    public static String checkYear;
    public static String checkMonth;
    public static String checkDay;

    public void setDate() {
        // Создаем Calendar и устанавливаем его на случайную дату
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(randomDate);

        // Извлекаем значения дня, месяца и года
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        // Форматируем месяц в текстовое представление
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", new Locale("en"));
        String monthName = monthFormat.format(randomDate);

        $(".react-datepicker__year-select").selectOption("" + year);
        $(".react-datepicker__month-select").selectOption(monthName);
        // В таком виде программа проигнорирует даты соседних месяцев
        $(".react-datepicker__day--0" + String.format("%02d", day))
                .shouldNotHave(Condition.text("react-datepicker__day--outside-month"))
                .click();
        checkYear = ("" + year);
        checkMonth = monthName;
        checkDay = ("" + day);
    }
}
