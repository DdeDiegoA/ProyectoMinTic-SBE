package com.example.sbemintic.db.repositories;

import com.example.sbemintic.db.entities.PermissionRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRoleRepository extends MongoRepository<PermissionRoleRepository, String> {
    List<PermissionRole> findAllByRoleId(String roleId);
}
