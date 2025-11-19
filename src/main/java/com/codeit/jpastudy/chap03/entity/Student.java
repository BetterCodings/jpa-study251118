package com.codeit.jpastudy.chap03.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @Column(name = "stu_id")
    @GeneratedValue(strategy = GenerationType.UUID) // PK를 UUID로 생성
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;
    private String city;
    private String major;
}
