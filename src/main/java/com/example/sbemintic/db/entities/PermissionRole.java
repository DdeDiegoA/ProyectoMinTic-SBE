package com.example.sbemintic.db.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("permission_by_role")
public class PermissionRole {
    @Id
    private String _id;
    @Field("permission_id")
    private String permissionId;
    @Field("role_id")
    private String roleId;
}
