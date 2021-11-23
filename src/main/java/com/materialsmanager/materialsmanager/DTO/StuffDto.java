package com.materialsmanager.materialsmanager.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StuffDto {
    private String stuffCategory;
    
    private String stuffName;

    @Builder.Default
    private int stuffCount = 0;

    @Builder.Default
    private int rentalCount = 0;

    @Builder.Default
    private int returnCount = 0;

    private String etc;

    public StuffDto() {
        stuffCount = 0;
        rentalCount = 0;
        returnCount = 0;
    }
}
