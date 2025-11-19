package com.codeit.jpastudy.chap03.repository;

import com.codeit.jpastudy.chap03.entity.Student;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    // JPA 쿼리 메서드 -> 메서드 이름으로 JPA가 쿼리를 만듭니다.
    // PK 관련 메서드는 기본으로 제공되지만, 다른 컬럼을 이용하는 SQL은 직접 생성해야 합니다.
    // 메서드 이름으로 쿼리를 조합하게 작성합니다. (규칙 있어요!)
    List<Student> findByName(String name);

    List<Student> findByCityAndMajor(String sity, String major);

    // WHERE major LIKE '%major%'
    List<Student> findByMajorContaining(String major);

    // WHERE major LIKE 'major%'
    List<Student> findByMajorStartingWith(String major);

    // WHERE major LIKE '%major'
    List<Student> findByMajorEndingWith(String major);

    // WHERE age > ?
    // findNameAndMajorByAgeGreaterThan
    // WHERE age >= ?
    // findNameAndMajorByAgeGreaterThanEqual
    // WHERE age <= ?
    // lessAndEquals

    //////////////////////////////////////////////////////////////////////////////////

    // native-sql (쌩 sql) 작성법
    // 데이터베이스 테이블 기반으로 쿼리를 작성
    @Query(value = "select * from tbl_student where stu_name = :n or city = :city", nativeQuery = true)
    List<Student> getStudentByNameOrCity(@Param("n")String name, @Param("city")String city);

    // JPQL
    // 엔티티 클래스 기반으로 쿼리를 작성
    @Query("select stu from Student stu where stu.name = ?1 or stu.city = ?2")
    List<Student> getStudentByNameOrCity2(String name, String city);

    // 특정 이름이 포함된 학생 리스트 조회하기
    // 특정 컬럼만 조회한다면 Tuple, Object[]로도 받을 수 있음.
    // 쿼리 안에서 확정 짓고 싶다면
//    @Query("select s.name as name, s.city as city from Student s where s.name like CONCAT('%', ?1, '%')")
    @Query("select s.name as name, s.city as city from Student s where s.name like ?1")
    List<Tuple> searchByNameWithJPQL(String name);

    // 도시명으로 학생 1명을 단일 조회 (PK로 조회하는 걸 권장)
    @Query("select stu from Student stu where stu.city = ?1")
    Optional<Student> getByCityWithJPQL(String city);


    @Modifying // select 아니면 무조건 붙이세요! JPQL은 기본 select를 기반으로 동작합니다.
    @Query("delete from Student s where s.name = ?1 and s.city = ?2")
    void deleteByNameAndCityWithJPQL(String name, String city);
}
