package com.garima.defectracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long ticketId;

    @Column(name = "title",unique = true, length = 200, nullable = false)
    private String ticketTitle;

    @NonNull
    @Column(name = "description")
    private String ticketDescription;

    @Column(name = "status")
    @NonNull
    private String ticketStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value = {"tickets", "hibernateLazyInitializer", "handler"})
    private Application application;

//    @Column(name="application_id", insertable = false, updatable = false)
//    private long appId;

//    @OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
//    private List<Release> releaseList;

    public Ticket() {
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    @NonNull
    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(@NonNull String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    @NonNull
    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(@NonNull String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

//    public List<Release> getReleaseList() {
//        return releaseList;
//    }
//
//    public void setReleaseList(List<Release> releaseList) {
//        this.releaseList = releaseList;
//    }

//    public long getAppId() {
//        return appId;
//    }
//
//    public void setAppId(long appId) {
//        this.appId = appId;
//    }
}
