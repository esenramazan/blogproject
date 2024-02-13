package com.ramo.blog.domain.enums;

public enum PostSubject {
    DRAFT("Draft"),
    PUBLISHED("Published"),
    ARCHIVED("Archived");

    private final String subject;

    PostSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
