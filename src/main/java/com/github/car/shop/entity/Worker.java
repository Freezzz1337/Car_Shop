package com.github.car.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {@Index(name = "nameIndexWorker", columnList = "name")} )
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String login;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Worker(String name, String login, Position posit) {
        this.name = name;
        this.login = login;
        this.position = posit;
    }
}

