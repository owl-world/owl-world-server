package com.owls.owlworld.search;

public class SearchRequest {

    private int size;
    private int page;
    private String keyword;

    public SearchRequest() {
    }

    public SearchRequest(int size, int page, String keyword) {
        this.size = size;
        this.page = page;
        this.keyword = keyword;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
