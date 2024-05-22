package com.example.demo.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    // MemberRequestDto, MemberResponseDto
    // SignUpReqDto, SignUpResDto
    // LoginReqDto, LoginResDto

    private int id;

    @JsonProperty("user_id")
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, message = "최소 8자리 이상 입력해주세요.")
    private String pw;

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "연락처 형식이 올바르지 않습니다. ex. 010-0000-0000")
    @NotBlank(message = "연락처는 필수 입력 값입니다.")
    private String contact;

    public Member convertToEntity() {
        return new Member(userId, pw, name, email, contact);
    }
}
