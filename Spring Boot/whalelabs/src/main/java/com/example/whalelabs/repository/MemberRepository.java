package com.example.whalelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whalelabs.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	public Member findbyTel(String tel);
	

}
