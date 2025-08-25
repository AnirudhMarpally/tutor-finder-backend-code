package com.example.tutorfinder.controller;

import com.example.tutorfinder.entity.Tutor;
import com.example.tutorfinder.service.TutorService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {
    private final TutorService tutorService;
    public TutorController(TutorService tutorService){ this.tutorService = tutorService; }

    @GetMapping
    public List<Tutor> search(@RequestParam(required=false) String location,
                              @RequestParam(required=false) String subject,
                              @RequestParam(required=false) BigDecimal maxFees){
        return tutorService.search(location, subject, maxFees);
    }
    
    @GetMapping("/all")
    public List<Tutor> all(){ return tutorService.findAll(); }
}
