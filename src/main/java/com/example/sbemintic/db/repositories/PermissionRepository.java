package com.example.sbemintic.db.repositories;

import com.example.sbemintic.db.entities.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRepository extends MongoRepository <Permission, String> {

        @Query("{_id: { $in: :#{#ids} }}")
        List<Permission> findAllByIds(List<String> ids);
}
