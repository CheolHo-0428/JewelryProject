package com.ion.jewelry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ion.jewelry.model.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
