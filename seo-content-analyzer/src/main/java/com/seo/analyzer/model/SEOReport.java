package com.seo.analyzer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seo_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SEOReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int keywordCount;
    private double readabilityScore;
}
