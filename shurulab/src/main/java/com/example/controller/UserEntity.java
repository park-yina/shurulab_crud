package com.example.controller;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String username; // 이것이 실질적인 아이디의 역할을 할 것입니다.

    @Column(nullable = false)
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;

    @Column(nullable = false)
    @Size(min = 3, max = 9, message = "닉네임은 3~9자 이하로 입력해주세요.")
    @Pattern(regexp = "^[^\\{\\}\\[\\]/?.,;:|)*~`!^\\-_+<>@#$%&\\\\=('\"]*$", message = "닉네임에 특수문자를 사용할 수 없습니다.")
    private String nickname;
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(length=300000)
    private byte[] profile; // 프로필 사진은 일단 이렇게 바이트로 한다는데 맞나
}
