package com.seo.analyzer.controller;

import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;
import com.seo.analyzer.service.SEOAnalyzerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seo")
public class SEOController {
    private final SEOAnalyzerService seoAnalyzerService;

    public SEOController(SEOAnalyzerService seoAnalyzerService) {
        this.seoAnalyzerService = seoAnalyzerService;
    }

    @PostMapping("/analyze")
    public SEOReport analyzeContent(@RequestBody Content content, @RequestParam String keyword) {
        return seoAnalyzerService.analyzeContent(content, keyword);
    }

}
