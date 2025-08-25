package com.example.tutorfinder.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tutors")
public class Tutor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable=false)
    private String subject;

    @Column(nullable=false)
    private String location;

    @Column(nullable=false)
    private BigDecimal fees;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public User getUser(){ return user; }
    public void setUser(User user){ this.user = user; }
    public String getSubject(){ return subject; }
    public void setSubject(String subject){ this.subject = subject; }
    public String getLocation(){ return location; }
    public void setLocation(String location){ this.location = location; }
    public BigDecimal getFees(){ return fees; }
    public void setFees(BigDecimal fees){ this.fees = fees; }
}
