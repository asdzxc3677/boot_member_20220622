package com.its.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter,setter 만들어줌
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든매게변수가 잇는 모든생성자
public class MemberDTO {
    private Long id;
    private String memberEmail; //아이디 id대신에 Email로 대체
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberPhone;
}
