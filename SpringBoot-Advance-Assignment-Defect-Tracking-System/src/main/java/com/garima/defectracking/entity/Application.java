package com.garima.defectracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "application")
public class Application implements Serializable  {
    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appId;

    @Column(name = "description")
    private String appDescription;

    @Column(name = "app_name",nullable = false,unique = true)
    private String appName;

    @Column(name = "owner")
    private String appOwner;

    @OneToMany(mappedBy = "application",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInitializer", "handler"})
    private Set<Ticket> tickets = new HashSet<Ticket>();


    @Column(name = "createdAt", updatable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)    // insert date
    private Date creationDate;

    @Column (name = "updatedAt")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)       // insert  both time and date
    private Date lastModifiedDate;


    public Application() {
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
