package com.its.member.dto;

import com.its.member.entity.MemberEntity;
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

    public MemberDTO(String memberEmail, String memberPassword, String memberName, int memberAge, String memberPhone) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberPhone = memberPhone;
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberDTO.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberAge(memberEntity.getMemberAge());
        memberDTO.setMemberPhone(memberEntity.getMemberPhone());
        return memberDTO
;

    }
}
