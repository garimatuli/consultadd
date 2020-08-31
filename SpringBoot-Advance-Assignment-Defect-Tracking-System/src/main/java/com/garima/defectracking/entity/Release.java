//package com.garima.defectracking.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "releases")
//public class Release {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long releaseId;
//
//    @Column(name = "description",nullable = false)
//    private String releaseDescription;
//
//    @Column(name = "release_date", nullable = false)
//    private Date releaseDate;
//
////    @ManyToOne(fetch = FetchType.LAZY, optional = false)
////    @JoinColumn(name = "ticket_id", nullable = false)
////    @OnDelete(action = OnDeleteAction.CASCADE)
////    @JsonIgnore
////    private Ticket ticket;
//
//    public Release() {
//    }
//
//    public long getReleaseId() {
//        return releaseId;
//    }
//
//    public void setReleaseId(long releaseId) {
//        this.releaseId = releaseId;
//    }
//
//    public String getReleaseDescription() {
//        return releaseDescription;
//    }
//
//    public void setReleaseDescription(String releaseDescription) {
//        this.releaseDescription = releaseDescription;
//    }
//
//    public Date getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(Date releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
////    public Ticket getTicket() {
////        return ticket;
////    }
////
////    public void setTicket(Ticket ticket) {
////        this.ticket = ticket;
////    }
//}
