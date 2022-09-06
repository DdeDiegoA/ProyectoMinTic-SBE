package com.example.sbemintic.db.entities;

import com.example.sbemintic.enums.Method;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {
    @Id
    private String _id;
    private String url;
    private Method method;
}
