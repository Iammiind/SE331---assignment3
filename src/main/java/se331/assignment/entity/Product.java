package se331.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
@Entity
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NonNull long id;
//    @NonNull String name;
//    @NonNull String description;
//    @NonNull String picture;
//    @NonNull double price;
//    @NonNull int amount;
//    @NonNull double rating;
    long id;
    String name;
    String description;
    String picture;
    double price;
    int amount;
    double rating;

}
