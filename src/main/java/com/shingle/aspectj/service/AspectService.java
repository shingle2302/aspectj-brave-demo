package com.shingle.aspectj.service;

import brave.Span;
import brave.Tracer;
import brave.Tracing;
import org.springframework.stereotype.Service;

@Service
public class AspectService {



    public String publicMethod() {
        Tracer tracer = Tracing.currentTracer();
        Span span = tracer.nextSpan().name("publicMethod");
        span.start();
        try {
            privateMethod();
            return "publicMethod";
        } finally {
            span.finish();

        }
    }

    private String privateMethod() {
        Tracer tracer = Tracing.currentTracer();

        Span span = tracer.nextSpan().name("publicMethod");
        span.start();
        try {
            return "privateMethod";
        } finally {
            span.finish();

        }
    }
}
