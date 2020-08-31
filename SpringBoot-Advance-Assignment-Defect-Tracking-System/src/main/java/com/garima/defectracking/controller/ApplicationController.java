package com.garima.defectracking.controller;

import com.garima.defectracking.common.AppException;
import com.garima.defectracking.common.AppResponse;
import com.garima.defectracking.common.ResourceNotFound;
import com.garima.defectracking.entity.Application;
import com.garima.defectracking.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

@RequestMapping("/defectracking")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/getApplications")
    public ResponseEntity<List<Application>> getApplications(){
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }

    @GetMapping("/getApplicationById/{appId}")
    @ResponseBody
    public AppResponse<String, Optional<Application>> getApplicationById(@PathVariable(value = "appId") long appId)  {
        try {
            Optional<Application> application = applicationService.getApplicationById(appId);
            return new AppResponse<String, Optional<Application>>("Successfully fetched application with id "+appId, application);
        }catch (ResourceNotFound e){
            throw new ResourceNotFound("Application",appId);
//        }catch (AppException e){
//            throw new AppException(e.getMessage());
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/postApplication")
    public ResponseEntity<String> postApplication(@RequestBody Application application) throws Exception {
        try {
            applicationService.postApplication(application);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity<>("Application created successfully",HttpStatus.OK);
    }

    @PutMapping("/updateApplication/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable(value = "id") long id, @RequestBody Application application) throws Exception {
        try {
            applicationService.updateApplication(id, application);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("Application updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteApplicationById/{id}")
    public ResponseEntity<String> deleteApplicationById(@PathVariable(value = "id") long id) throws Exception {
        try {
            applicationService.deleteApplicationById(id);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("Application deleted successfully",HttpStatus.OK);
    }
}
