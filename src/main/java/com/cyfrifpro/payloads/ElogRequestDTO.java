package com.cyfrifpro.payloads;

import lombok.Data;

@Data
public class ElogRequestDTO {
    private String userid;
    private String memberid;
    private String password;
    private String clientcode;
    private String holder;
    private String documenttype;
    private String intrefno;
    private String loopbackurl;
    private String allowloopbackmsg;
}
