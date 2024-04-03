package com.groupe.isi.web.rest.errors;

import com.groupe.isi.Service.CalendarService;
import jakarta.mail.internet.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.h2.util.DateTimeUtils.getDayOfWeek;

@RestController
@RequestMapping("/services/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping("/dayfinder")
    public ResponseEntity<Map<String, String>> findDayOfWeek(@RequestBody Map<String, String> dateRequest) {
        String dateStr = dateRequest.get("date");
        Map<String, String> response = new HashMap<>();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String dayOfWeekStr = "";
            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    dayOfWeekStr = "Dimanche";
                    break;
                case Calendar.MONDAY:
                    dayOfWeekStr = "Lundi";
                    break;
                case Calendar.TUESDAY:
                    dayOfWeekStr = "Mardi";
                    break;
                case Calendar.WEDNESDAY:
                    dayOfWeekStr = "Mercredi";
                    break;
                case Calendar.THURSDAY:
                    dayOfWeekStr = "Jeudi";
                    break;
                case Calendar.FRIDAY:
                    dayOfWeekStr = "Vendredi";
                    break;
                case Calendar.SATURDAY:
                    dayOfWeekStr = "Samedi";
                    break;
                default:
                    break;
            }

            CalendarService.saveDate(dateStr);

            response.put("date", dateStr);
            response.put("dayOfWeek", dayOfWeekStr);
            return ResponseEntity.ok(response);
        } catch (ParseException | java.text.ParseException e) {
            // En cas d'erreur de parsing de la date
            response.put("error", "Format de date invalide");
            return ResponseEntity.badRequest().body(response);
        }

    }
    public static void main(String[] args) {
        // Exemple d'utilisation
        String dateStr = "22-01-1945";
        Map<String, String> result = getDayOfWeek(dateStr);
        System.out.println(result);
    }
}
