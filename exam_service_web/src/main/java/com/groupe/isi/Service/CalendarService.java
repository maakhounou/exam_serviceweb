package com.groupe.isi.Service;

import com.groupe.isi.domain.Calendar;
import com.groupe.isi.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public void saveDate(String dateStr) {
        Calendar calendar = new Calendar();
        calendar.setDate(dateStr);
        calendarRepository.save(calendar);
    }
}
