package com.its.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // DTO같은 역할을 하는데 스트링부트에서 데이터베이스에 저장할때 쓰는 타입
@Getter @Setter
@Table(name = "member_table") //테이블 이름 변경하고 싶을때
public class MemberEntity {
    @Id //pk역할
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 자동 번호 설정
    @Column(name = "id") // 컬럼 이름 지정
    private Long id; // @Id, @GeneratedValue, @Column(name = "id") 한셋트

    @Column(name = "memberEmail", length = 50) //컬럼역할 length = 50 <-- 이렇게도 설정가능
    private String column1; //컬럼

    @Column(name = "memberPassword", length = 20) //컬럼역할 length = 20 <-- 이렇게도 설정가능
    private String column2; //컬럼

    @Column(name = "memberName", length = 20) //컬럼역할 length = 20 <-- 이렇게도 설정가능
    private String column3; //컬럼

    @Column(name = "memberAge") //컬럼역할 length = 20 <-- 이렇게도 설정가능
    private int column4; //컬럼

    @Column(name = "memberPhone", length = 20) //컬럼역할 length = 50 <-- 이렇게도 설정가능
    private String column5; //컬럼


}
