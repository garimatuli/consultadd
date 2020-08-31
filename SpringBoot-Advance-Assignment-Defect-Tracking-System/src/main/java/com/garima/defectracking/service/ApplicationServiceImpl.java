package com.garima.defectracking.service;

import com.garima.defectracking.common.AppException;
import com.garima.defectracking.common.ResourceNotFound;
import com.garima.defectracking.entity.Application;
import com.garima.defectracking.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> getApplicationById(long id) {
        Optional<Application> application = applicationRepository.findById(id);
        if (!application.isPresent()) {
            throw new ResourceNotFound("Application",id);
//            throw new AppException("No application exists with id "+id);
        }
        return application;
    }

    @Override
    public void postApplication(Application application) throws AppException {
        Application app = applicationRepository.checkAppName(application.getAppName());
        if ( app == null) {
            Date date = new Date();
            application.setCreationDate(date);
            application.setLastModifiedDate(date);
            applicationRepository.save(application);
        }
        else
            throw new AppException("Application Name '"+app.getAppName()+"' already Exists");
    }

    @Override
    public void updateApplication(long id, Application application) throws AppException {
        Optional<Application> app = applicationRepository.findById(id);
        Date date = new Date();
        if (app.isPresent()) {
            Application foundApp = app.get();
            foundApp.setAppName(application.getAppName());
            foundApp.setAppDescription(application.getAppDescription());
            foundApp.setAppOwner(application.getAppOwner());
            foundApp.setLastModifiedDate(date);
            applicationRepository.save(foundApp);
        } else {
//            throw new ResourceNotFound("Application",id);
            throw new AppException("No application exists with id "+id);
        }

    }

    public void deleteApplicationById(long id) throws AppException {
        Optional<Application> app = applicationRepository.findById(id);
        if (app.isPresent()) {
            Application foundApp = app.get();
            applicationRepository.delete(foundApp);
        }else{
//            throw new ResourceNotFound("Application",id);
            throw new AppException("No application exists with id "+id);
        }
    }

}
