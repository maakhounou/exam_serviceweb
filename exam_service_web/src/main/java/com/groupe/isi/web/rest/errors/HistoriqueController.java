package com.groupe.isi.web.rest.errors;

import com.groupe.isi.domain.Calendar;
import com.groupe.isi.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/historique")
public class HistoriqueController {
    @Autowired
    private CalendarRepository calendarRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Calendar>> getAllDates() {
        List<Calendar> calendarList = calendarRepository.findAll();
        return ResponseEntity.ok(calendarList);
    }
}
