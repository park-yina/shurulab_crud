package com.example.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private String username;
    private String password;
    private String nickname;
    private String email;
    
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] profile; // 프로필 사진은 일단 이렇게 바이트로 한다는데 맞나prSTR
}
