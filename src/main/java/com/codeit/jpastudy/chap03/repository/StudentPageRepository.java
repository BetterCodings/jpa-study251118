package com.codeit.jpastudy.chap03.repository;

import com.codeit.jpastudy.chap03.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPageRepository extends JpaRepository<Student, String> {

    // 학생의 이름에 특정 단어가 포함된 걸 조회 + 페이징 정보
    // 커스텀 메서드를 만들 때 페이지 정보를 얻고 싶다면 Pageable을 매개값으로 받으세요.
    // 그리고 리턴은 Page로 리턴하세요.
    Page<Student> findByNameContaining(String name, Pageable pageable);

    //////////////////////////////////////////////////////////

    // JPA의 정렬은 JPQL에다가 ORDER BY를 작성하셔도 정렬은 가능합니다만,
    // 쿼리 메서드 정렬과 매개값을 통한 정렬을 소개합니다.
    List<Student> findByNameContainingOrderByMajorDesc(String name);


    List<Student> findByNameContaining(String name, Sort sort);

}
