package io.x99.repository;

import io.x99.model.entity.TestTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTableRepository extends JpaRepository<TestTableEntity, Integer> {
}
