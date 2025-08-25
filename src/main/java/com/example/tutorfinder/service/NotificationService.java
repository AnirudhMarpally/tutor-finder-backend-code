package com.example.tutorfinder.service;

import com.example.tutorfinder.entity.Notification;
import com.example.tutorfinder.entity.Tutor;
import com.example.tutorfinder.entity.User;
import com.example.tutorfinder.repository.NotificationRepository;
import com.example.tutorfinder.repository.TutorRepository;
import com.example.tutorfinder.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository, TutorRepository tutorRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
    }

    @Transactional
    public Notification send(Long studentId, Long tutorId, String message){
        User student = userRepository.findById(studentId).orElseThrow();
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow();
        Notification n = new Notification();
        n.setStudent(student);
        n.setTutor(tutor);
        n.setMessage(message);
        n.setStatus("PENDING");
        return notificationRepository.save(n);
    }

    public List<Notification> receivedByTutor(Long tutorId){
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow();
        return notificationRepository.findByTutor(tutor);
    }

    @Transactional
    public Notification updateStatus(Long notificationId, String status){
        Notification n = notificationRepository.findById(notificationId).orElseThrow();
        n.setStatus(status);
        return notificationRepository.save(n);
    }

	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}
}
