package com.seo.analyzer.factory;

import com.seo.analyzer.strategy.ISEOAnalysisStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SEOAnalysisFactory {

    private final Map<String, ISEOAnalysisStrategy> strategyMap;

    public SEOAnalysisFactory(List<ISEOAnalysisStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(s -> s.getClass().getSimpleName(), s -> s));
    }

    public ISEOAnalysisStrategy getStrategy(String strategyName) {
        ISEOAnalysisStrategy strategy = strategyMap.get(strategyName);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid strategy: " + strategyName);
        }
        return strategy;
    }
}
