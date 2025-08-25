package com.example.tutorfinder.service;

import com.example.tutorfinder.entity.Tutor;
import com.example.tutorfinder.repository.TutorRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;
    public TutorService(TutorRepository tutorRepository){ this.tutorRepository = tutorRepository; }

    public List<Tutor> search(String location, String subject, BigDecimal maxFees){
        Specification<Tutor> spec = Specification.where(null);
        if (location != null && !location.isBlank()) {
            spec = spec.and((root, q, cb) -> cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%"));
        }
        if (subject != null && !subject.isBlank()) {
            spec = spec.and((root, q, cb) -> cb.like(cb.lower(root.get("subject")), "%" + subject.toLowerCase() + "%"));
        }
        if (maxFees != null) {
            spec = spec.and((root, q, cb) -> cb.lessThanOrEqualTo(root.get("fees"), maxFees));
        }
        return tutorRepository.findAll(spec);
    }
    
    public List<Tutor> findAll() {
    	return tutorRepository.findAll();
    }
}
