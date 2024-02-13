package com.ramo.blog.domain.enums;

public enum PostStatus {
    DRAFT("Draft"),
    PUBLISHED("Published"),
    ARCHIVED("Archived");

    private final String status;

    PostStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
