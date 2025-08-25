package com.example.tutorfinder.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @Column(nullable=false)
    private String message;

    @Column(nullable=false)
    private String status; // PENDING / APPROVED / REJECTED

    @Column(name="created_at", nullable=false)
    private Instant createdAt = Instant.now();

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public User getStudent(){ return student; }
    public void setStudent(User student){ this.student = student; }
    public Tutor getTutor(){ return tutor; }
    public void setTutor(Tutor tutor){ this.tutor = tutor; }
    public String getMessage(){ return message; }
    public void setMessage(String message){ this.message = message; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
    public Instant getCreatedAt(){ return createdAt; }
    public void setCreatedAt(Instant createdAt){ this.createdAt = createdAt; }
}
