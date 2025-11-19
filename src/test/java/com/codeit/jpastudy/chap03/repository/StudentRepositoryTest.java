package com.codeit.jpastudy.chap03.repository;

import com.codeit.jpastudy.chap03.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach // 테스트 메서드 이전에 항상 자동 호출되는 메서드
    void insertData() {
        Student s1 = Student.builder()
                .name("쿠로미")
                .city("청양군")
                .major("경제학")
                .build();
        Student s2 = Student.builder()
                .name("춘식이")
                .city("서울시")
                .major("컴퓨터공학")
                .build();
        Student s3 = Student.builder()
                .name("어피치")
                .city("제주도")
                .major("화학공학")
                .build();
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }

    @Test
    @DisplayName("이름이 춘식이인 학생의 모든 정보를 조회한다.")
    void findByNameTest() {
        // given
        String name = "춘식이";

        // when
        List<Student> list = studentRepository.findByName(name);

        // then
        assertEquals(1, list.size());

        System.out.println("\n\n\n");
        System.out.println(list.get(0));
        System.out.println("\n\n\n");
    }

}