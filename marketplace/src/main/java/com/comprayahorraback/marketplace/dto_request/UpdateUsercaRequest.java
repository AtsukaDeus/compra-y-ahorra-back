package com.comprayahorraback.marketplace.dto_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUsercaRequest {
    private String run;
    private String name;
    private String email;
}
