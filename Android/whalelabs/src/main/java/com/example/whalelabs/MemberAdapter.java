package com.example.whalelabs;

import java.util.List;

public class MemberAdapter {

    private List<Member> memberList;
    public MemberAdapter(List<Member> memberList) {this.memberList = memberList; }
    public void signUp(Member member) { memberList.add(member); }

    public void updateMember(Member member){
        Member m = new Member(member.getName(), member.getTel(), member.getEmail(),
                member.getPassword(), member.getProfileImg());
        m.setName(member.getName());
        m.setTel(member.getTel());
        m.setEmail(m.getEmail());
        m.setPassword(m.getPassword());
        m.setProfileImg(m.getProfileImg());
    }
    public void findAll(List<Member> memberList){
        this.memberList = memberList;
    }

}
