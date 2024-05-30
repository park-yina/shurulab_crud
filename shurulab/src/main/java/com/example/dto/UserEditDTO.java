package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEditDTO {
  @NotBlank(message = "닉네임은 필수 입력 값입니다.")
  private String nickname;
  private String new_nickname;
  private byte[] profile; // 프로필 사진은 일단 이렇게 바이트로 한다는데 맞나
  
  private String password;
  private String new_password;
}
