package com.cyfrifpro.payloads;

import lombok.Data;

@Data
public class ElogResponseDTO {
    private String statuscode;
    private String authurl;
    private String errordesc;
    private String intrefno;
}