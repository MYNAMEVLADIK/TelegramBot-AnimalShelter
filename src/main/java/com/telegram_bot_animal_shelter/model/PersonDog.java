package com.telegram_bot_animal_shelter.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Entity for person who wants to give a dog.
 * @author: Kucherenko V.V.
 * @version 0.0.1
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDog extends Person{

    /**
     * Autogenerated primary key id for PersonDog
     * @param id
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public PersonDog(String name, int yearOfBirth, String phone, String address, Long chatId, Status status, Dog dog) {
        super(name, yearOfBirth, phone, address, chatId, status);
        this.dog = dog;
    }

    public PersonDog(String name, int yearOfBirth, String phone, String address, Long chatId, Status status) {
        super(name, yearOfBirth, phone, address, chatId, status);
    }

    public PersonDog(String name, String phone, Long chatId) {
        super(name, phone, chatId);
    }

    /**
     * Connect to entity dog, One person can have One dog
     * @param dog
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dog_id", referencedColumnName = "id")
    private Dog dog;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Report> reports;
}
