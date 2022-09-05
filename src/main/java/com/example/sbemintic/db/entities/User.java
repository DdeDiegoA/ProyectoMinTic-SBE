package com.example.sbemintic.db.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String _id;
    @Field(name = "Seudonimo")
    private String seudonimo;
    private String email;
    private String password;
    @Field(name = "role_id")
    private String roleId;

}
