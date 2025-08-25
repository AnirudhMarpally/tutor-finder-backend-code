package com.example.tutorfinder.repository;

import com.example.tutorfinder.entity.Notification;
import com.example.tutorfinder.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByTutor(Tutor tutor);
}
