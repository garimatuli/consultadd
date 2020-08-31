package com.garima.defectracking.service;

import com.garima.defectracking.common.AppException;
import com.garima.defectracking.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<Application> getApplications();
    Optional<Application> getApplicationById(long id) ;
    void postApplication(Application application) throws AppException;
    void updateApplication(long id, Application application) throws AppException;
    void deleteApplicationById(long id) throws AppException;
}
