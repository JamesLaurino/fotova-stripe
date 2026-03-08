package com.fotova.service.html;

public interface StripeHtmlService {
    public String buildSuccessHtml();
    public String buildFailureHtml();
    public String buildCancelHtml();
}
