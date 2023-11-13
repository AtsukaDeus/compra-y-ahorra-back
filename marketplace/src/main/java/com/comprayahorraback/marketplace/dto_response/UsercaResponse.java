package com.comprayahorraback.marketplace.dto_response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsercaResponse {

    private Long id;
    private String run;
    private String name;
    private String email;
}
