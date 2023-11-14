package com.comprayahorraback.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.entity.Userca;
import com.comprayahorraback.marketplace.repository.UsercaRepository;



@Service
public class AdminService {

    @Autowired
    private UsercaRepository usercaRepository;
    

    // Method to lock an user client
    public boolean lockUser(Long userId) {
        boolean isUserLocked = false;
        
        if(usercaRepository.existsById(userId)){

            Userca userca = usercaRepository.findById(userId).orElse(null);
            userca.setLocked(true);
            usercaRepository.save(userca);
            isUserLocked = true;
        }

        return isUserLocked;
    }


    // Method to unlock an user client
    public boolean unlockUser(Long userId){
        boolean isUserUnlocked = false;
        
        if(usercaRepository.existsById(userId)){

            Userca userca = usercaRepository.findById(userId).orElse(null);
            userca.setLocked(false);
            usercaRepository.save(userca);
            isUserUnlocked = true;
        }

        return isUserUnlocked;
    }


}
