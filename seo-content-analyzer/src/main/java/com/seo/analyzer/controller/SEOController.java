package com.seo.analyzer.controller;

import com.seo.analyzer.context.SEOAnalyzerContext;
import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;
import com.seo.analyzer.service.SEOAnalyzerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seo")
public class SEOController {
    private final SEOAnalyzerContext seoAnalyzerContext;
    private final SEOAnalyzerService seoAnalyzerService;
    public SEOController(SEOAnalyzerContext seoAnalyzerContext,SEOAnalyzerService seoAnalyzerService) {
        this.seoAnalyzerContext = seoAnalyzerContext;
        this.seoAnalyzerService = seoAnalyzerService;
    }

    @PostMapping("/analyze")
    public SEOReport analyzeContent(@RequestBody Content content, @RequestParam String keyword) {
        return seoAnalyzerService.analyzeContent(content, keyword);
    }

    @GetMapping("/analyze")
    public String analyzeContent(@RequestParam String strategy, @RequestParam String content) {
        return seoAnalyzerContext.analyze(strategy, content);
    }

}
