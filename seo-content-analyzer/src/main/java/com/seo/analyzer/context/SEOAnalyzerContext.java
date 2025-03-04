package com.seo.analyzer.context;

import com.seo.analyzer.factory.SEOAnalysisFactory;
import com.seo.analyzer.strategy.ISEOAnalysisStrategy;
import org.springframework.stereotype.Component;

@Component
public class SEOAnalyzerContext {
    private final SEOAnalysisFactory seoAnalysisFactory;
    public SEOAnalyzerContext(SEOAnalysisFactory seoAnalysisFactory) {
        this.seoAnalysisFactory = seoAnalysisFactory;
    }

    public String analyze(String strategyName, String content) {
        ISEOAnalysisStrategy strategy = seoAnalysisFactory.getStrategy(strategyName);
        return strategy.analyze(content);
    }
}
