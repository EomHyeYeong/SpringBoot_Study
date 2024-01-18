package com.example.firstproject.dto;
import com.example.firstproject.entity.Member;

public class MemberForm {
    private String email;
    private String password;

    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // form 객체를 엔티티 객체로 변환하는 역할
    public Member toEntity() {
        return new Member(null, email, password);
    }
}
