package com.comprayahorraback.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
        
    @PutMapping("/lock_client/{id}")
    public ResponseEntity<?> lockUserClient(@PathVariable Long id){
        try {    
            boolean isUserLocked = adminService.lockUser(id);
            if(isUserLocked){
                return ResponseEntity.ok("User locked successfully!");
            
            } else{

                return new ResponseEntity<>("User not found" ,HttpStatus.NOT_FOUND);
            }

        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }
    
    @PutMapping("/unlock_client/{id}")
    public ResponseEntity<?> unlockUserClient(@PathVariable Long id){
        try {    
            boolean isUserUnlocked = adminService.unlockUser(id);
            if(isUserUnlocked){
                return ResponseEntity.ok("User unlocked successfully!");
            
            } else{

                return new ResponseEntity<>("User not found" ,HttpStatus.NOT_FOUND);
            }

        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }


}
