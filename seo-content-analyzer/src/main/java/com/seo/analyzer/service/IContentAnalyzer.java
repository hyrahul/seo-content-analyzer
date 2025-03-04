package com.seo.analyzer.service;

import com.seo.analyzer.model.Content;
import com.seo.analyzer.model.SEOReport;

public interface IContentAnalyzer {
    SEOReport analyze(Content content, String keyword);
}
