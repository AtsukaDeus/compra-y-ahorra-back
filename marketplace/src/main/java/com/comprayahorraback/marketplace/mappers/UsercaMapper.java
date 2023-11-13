package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_response.UsercaResponse;
import com.comprayahorraback.marketplace.entity.Userca;

public class UsercaMapper {
    
    
    public UsercaResponse usercaEntityToResponse(Userca userca){

        return UsercaResponse.builder()
                            .id(userca.getId())
                            .run(userca.getRun())
                            .name(userca.getName())
                            .email(userca.getEmail())
                            .build();                        
    }


}
