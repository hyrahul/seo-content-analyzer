package com.seo.analyzer.strategy;

import org.springframework.stereotype.Component;

@Component
public class ReadabilityScoreAnalysis implements ISEOAnalysisStrategy{

    @Override
    public String analyze(String content) {
        int wordCount = content.split(" ").length;
        return "Readability Score: " + (100 - wordCount);
    }

}
