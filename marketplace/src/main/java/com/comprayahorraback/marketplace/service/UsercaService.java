package com.comprayahorraback.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.UpdatePasswordRequest;
import com.comprayahorraback.marketplace.dto_request.UpdateUsercaRequest;
import com.comprayahorraback.marketplace.entity.Userca;
import com.comprayahorraback.marketplace.repository.UsercaRepository;

@Service
public class UsercaService {
    
    @Autowired
    private UsercaRepository usercaRepository;


    public boolean updatePassword(UpdatePasswordRequest updatePasswordRequest, Long userId){ 

        boolean userUpdated = false;

        if(usercaRepository.existsById(userId)){

            Userca userca = usercaRepository.findById(userId).orElse(null);
            if(updatePasswordRequest.getPassword().equals(userca.getPassword())){

                userca.setPassword(updatePasswordRequest.getNewPassword());
                usercaRepository.save(userca);
                userUpdated = true;
            }
            
        }
        
        return userUpdated;
    }

    public boolean updateUserca(Long id, UpdateUsercaRequest updateUsercaRequest)
    {
        boolean updateUserca = false;
        if (usercaRepository.existsById(id))
        {
            Userca userca = usercaRepository.findById(id).orElse(null);

            if (updateUsercaRequest.getRun() != null) 
            {
                userca.setRun(updateUsercaRequest.getRun());
            }

            if(updateUsercaRequest.getName() != null)
            {
                userca.setName(updateUsercaRequest.getName());
            }

            if (updateUsercaRequest.getEmail() != null) 
            {
                userca.setEmail(updateUsercaRequest.getEmail());
            }

            usercaRepository.save(userca);
            updateUserca = true;
            return updateUserca;
        } else {
            return updateUserca;
        }
    }

}
