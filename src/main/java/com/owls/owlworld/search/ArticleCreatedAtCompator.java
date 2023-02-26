package com.owls.owlworld.search;

import java.util.Comparator;

public class ArticleCreatedAtCompator implements Comparator<ArticleDto> {

    @Override
    public int compare(ArticleDto o1, ArticleDto o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }

}
