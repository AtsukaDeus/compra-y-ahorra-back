package com.comprayahorraback.marketplace.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.dto_request.UpdatePasswordRequest;
import com.comprayahorraback.marketplace.dto_request.UpdateUsercaRequest;
import com.comprayahorraback.marketplace.service.UsercaService;

@RestController
@RequestMapping("/userca")
public class UsercaController {
        
    @Autowired
    private UsercaService usercaService;


    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateUserca(@RequestBody UpdateUsercaRequest updateUsercaRequest, @PathVariable Long id){
        try{

            boolean isUsercaUpdate = usercaService.updateUserca(id, updateUsercaRequest);
            
            if (isUsercaUpdate){
                return new ResponseEntity<>("¡User update!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User no exists", HttpStatus.NOT_FOUND);
            }

        } catch (ConstraintViolationException e){
            return new ResponseEntity<>("Validation Error", HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/password/{id}")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, @PathVariable Long id) {
        try {

            boolean isPasswordUpdated = usercaService.updatePassword(updatePasswordRequest, id);
            if(isPasswordUpdated){
                return ResponseEntity.ok("Password updated!");
            
            } else{
                return new ResponseEntity<>("Error: Invalid password!", HttpStatus.BAD_REQUEST);
            
            }

        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error de validación: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }


}
