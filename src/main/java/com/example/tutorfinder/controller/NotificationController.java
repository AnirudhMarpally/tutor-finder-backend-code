package com.example.tutorfinder.controller;

import com.example.tutorfinder.entity.Notification;
import com.example.tutorfinder.service.NotificationService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    public NotificationController(NotificationService notificationService){ this.notificationService = notificationService; }

    public static class SendRequest {
        @NotNull public Long studentId;
        @NotNull public Long tutorId;
        @NotBlank public String message;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Notification>> all() {
    	return ResponseEntity.ok(notificationService.findAll());
    }

    @PostMapping
    public ResponseEntity<Notification> send(@RequestBody SendRequest req){
        return ResponseEntity.ok(notificationService.send(req.studentId, req.tutorId, req.message));
    }

    @GetMapping("/received/{tutorId}")
    public ResponseEntity<List<Notification>> received(@PathVariable Long tutorId){
        return ResponseEntity.ok(notificationService.receivedByTutor(tutorId));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Map<String, Object>> approve(@PathVariable Long id){
        Notification n = notificationService.updateStatus(id, "APPROVED");
        return ResponseEntity.ok(Map.of("id", n.getId(), "status", n.getStatus()));
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<Map<String, Object>> reject(@PathVariable Long id){
        Notification n = notificationService.updateStatus(id, "REJECTED");
        return ResponseEntity.ok(Map.of("id", n.getId(), "status", n.getStatus()));
    }
}
