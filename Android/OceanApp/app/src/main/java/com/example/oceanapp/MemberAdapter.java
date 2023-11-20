package com.example.oceanapp;

import java.util.List;

public class MemberAdapter {

    private List<Member> memberList;
    public MemberAdapter(List<Member> memberList) {this.memberList = memberList; }
    public void signUp(Member member) { memberList.add(member); }

    public void updateMember(Member member){
        Member m = new Member(member.getName(), member.getTel(), member.getEmail(),
                member.getName());
    }

}
