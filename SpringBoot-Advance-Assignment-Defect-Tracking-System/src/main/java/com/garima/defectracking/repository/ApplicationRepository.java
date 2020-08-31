package com.garima.defectracking.repository;

import com.garima.defectracking.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a from Application a where a.appName =:appName")
    Application checkAppName(String appName);

//    @Query("SELECT t from Ticket t, Application a where a.appId = t.appId")

}
