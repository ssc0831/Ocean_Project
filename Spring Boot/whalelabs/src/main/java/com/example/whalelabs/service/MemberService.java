package com.example.whalelabs.service;

import org.springframework.stereotype.Service;

import com.example.whalelabs.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	

}
