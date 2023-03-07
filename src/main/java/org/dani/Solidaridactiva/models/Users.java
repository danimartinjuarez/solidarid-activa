package org.dani.Solidaridactiva.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String whatLike;
    private String whatOffer;
    private String location;
    private String activityType;
    private String contact;
    private String photo;
    private String title;


}
