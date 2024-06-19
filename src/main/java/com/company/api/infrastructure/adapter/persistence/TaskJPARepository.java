package com.company.api.infrastructure.adapter.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJPARepository extends MongoRepository<TaskEntity, String> {
}
