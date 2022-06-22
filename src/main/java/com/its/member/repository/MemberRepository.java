package com.its.member.repository;

import com.its.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 리파스토리는 인터페이스 생성 JpaRepository<TestEntity, Long> 공식선언 필수정보이다.
    //리파스토리는(Repository 는) Entity DB작업할때 어떤 Entity 다룰꺼냐 어떠한 pk를 다룰것인지 정하는것
}
