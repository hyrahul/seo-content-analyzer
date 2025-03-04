package com.seo.analyzer.repository;

import com.seo.analyzer.model.SEOReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SEOReportRepository extends JpaRepository<SEOReport, Long> {
}
