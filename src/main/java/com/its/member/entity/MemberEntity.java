package com.its.member.entity;

import com.its.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // DTO같은 역할을 하는데 스트링부트에서 데이터베이스에 저장할때 쓰는 타입
@Getter @Setter
@Table(name = "member_table") //테이블 이름 변경하고 싶을때
public class MemberEntity {
    @Id //pk역할
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 자동 번호 설정
    @Column(name = "member_id") // 컬럼 이름 지정
    private Long id; // @Id, @GeneratedValue, @Column(name = "id") 한셋트

    @Column(length = 50, unique = true) //컬럼역할 length = 50 <-- 이렇게도 설정가능
    // unique = true 중복 방지
    private String memberEmail; //컬럼

    @Column(length = 20)
    private String memberPassword; //컬럼

    @Column(length = 20)
    private String memberName; //컬럼

    @Column
    private int memberAge; //컬럼

    @Column(length = 30)
    private String memberMobile; //컬럼

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        // static 키워드를 사용한 변수는 클래스가 메모리에 올라갈 때 자동으로 생성이 된다. 즉, 인스턴스(객체) 생성 없이 바로 사용가능 하다.
        // toEntity는 DTO를 Entity로 바꾸는 메소드
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        return memberEntity;
    }

    public static MemberEntity toUpdateEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        return memberEntity;
    }
}
