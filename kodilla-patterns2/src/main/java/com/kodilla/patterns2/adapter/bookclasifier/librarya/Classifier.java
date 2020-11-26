package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import com.kodilla.patterns2.adapter.bookclasifier.EmptyBookSetException;

import java.util.Set;

public interface Classifier {
    int publicationYearMedian(Set<Book> bookSet) throws EmptyBookSetException;
}
