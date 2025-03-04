package com.seo.analyzer.service;

import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;
import org.springframework.stereotype.Service;

@Service
public class KeywordAnalyzerService implements IContentAnalyzer{
    @Override
    public SEOReport analyze(Content content, String keyword) {
        int count = (int) java.util.Arrays.stream(content.getText().toLowerCase().split("\\s+"))
                .filter(word -> word.equalsIgnoreCase(keyword))
                .count();

        SEOReport report = new SEOReport();
        report.setContent(content.getText());
        report.setKeywordCount(count);
        return report;
    }
}
