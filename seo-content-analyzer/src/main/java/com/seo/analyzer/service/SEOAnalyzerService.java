package com.seo.analyzer.service;

import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;
import com.seo.analyzer.repository.SEOReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SEOAnalyzerService {
    private final List<IContentAnalyzer> analyzers;
    private final SEOReportRepository reportRepository;

    public SEOAnalyzerService(List<IContentAnalyzer> analyzers, SEOReportRepository reportRepository) {
        this.analyzers = analyzers;
        this.reportRepository = reportRepository;
    }

    public SEOReport analyzeContent(Content content, String keyword) {
        SEOReport report = new SEOReport();
        for (IContentAnalyzer analyzer : analyzers) {
            SEOReport partialReport = analyzer.analyze(content, keyword);
            if (partialReport.getKeywordCount() != 0) {
                report.setKeywordCount(partialReport.getKeywordCount());
            }
            if (partialReport.getReadabilityScore() != 0) {
                report.setReadabilityScore(partialReport.getReadabilityScore());
            }
        }
        report.setContent(content.getText());
        return reportRepository.save(report);
    }

}
