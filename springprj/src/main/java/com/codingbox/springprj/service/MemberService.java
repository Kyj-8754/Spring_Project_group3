package com.codingbox.springprj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.springprj.domain.Member;
import com.codingbox.springprj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/*
 * @Transactional : DB와 관련된 트랜잭션이 필요한 서비스 클래스 혹은 매서드에 @Transactional 추가
 * 일련의 작업들을 묶어서 하나의 단위로 처리할 때 사용
 * 
 * 옵션중에 readOnly라는것이 있는데 boolean형태로 true,false값을 반환해온다. 읽기 전용일때 사용
 * 비용을 아껴준다.
 */
@Service @RequiredArgsConstructor
@Transactional(readOnly = true) // 클래스 위에 선언 하므로서 메서드 부분에 생략 가능
public class MemberService {

	private final MemberRepository memberRepositoty;
	
	// 보통은 읽기 전용이 아닌거에 false로 선언 하는게 기본이다. 만일 클래스로 선언할 경우 쓰기까지하기위해서 @Transactional 를 선언해준다.
	@Transactional
	public Long join(Member member) throws IllegalAccessException {
		// 중복회원 검증 로직 추가
		validationMemberCheck(member);
		memberRepositoty.save(member);
		return member.getId();
	}
	private void validationMemberCheck(Member member) throws IllegalAccessException {
		List<Member> findMembers =
		memberRepositoty.findByname(member.getName());
		if(!findMembers.isEmpty()) {
			throw new IllegalAccessException("이미 존재하는 회원입니다.");
		}
	}
	// readonly 사용하기 위해서 아래와 같이 선언.
	// @Transactional(readOnly = true)
	public List<Member> findMembers() {
		return memberRepositoty.findAll();
	}
}
