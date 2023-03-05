package com.CU.CurriculumPathTracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCatalogRepository extends JpaRepository<CourseCatalog, Long> {
    CourseCatalog findCourseCatalogByCode(String code);
    List<CourseCatalog> findAll();
}
