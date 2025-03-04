package com.seo.analyzer.strategy;

import org.springframework.stereotype.Component;

@Component
public class KeywordDensityAnalysis implements ISEOAnalysisStrategy{
    @Override
    public String analyze(String content) {
        long keywordCount = content.toLowerCase().split("seo").length - 1;
        return "Keyword 'SEO' found " + keywordCount + " times";
    }
}
