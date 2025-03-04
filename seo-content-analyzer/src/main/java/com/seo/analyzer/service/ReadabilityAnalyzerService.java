package com.seo.analyzer.service;

import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;
import org.springframework.stereotype.Service;

@Service
public class ReadabilityAnalyzerService implements IContentAnalyzer{
    @Override
    public SEOReport analyze(Content content, String keyword) {
        String[] sentences = content.getText().split("[.!?]");
        String[] words = content.getText().split("\\s+");
        int syllables = countSyllables(words);

        double score = 206.835 - (1.015 * words.length / sentences.length) - (84.6 * syllables / words.length);

        SEOReport report = new SEOReport();
        report.setContent(content.getText());
        report.setReadabilityScore(score);
        return report;
    }

    private int countSyllables(String[] words) {
        int count = 0;
        for (String word : words) {
            count += word.replaceAll("(?i)[aeiouy]{1,2}", "a").length();
        }
        return count;
    }
}
