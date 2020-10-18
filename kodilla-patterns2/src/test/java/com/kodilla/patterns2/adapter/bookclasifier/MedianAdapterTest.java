package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTest {

    private final Set<Book> bookSet = new HashSet<>();
    private final MedianAdapter medianAdapter = new MedianAdapter();
    @Test
    public void publicationYearMedianTest() throws EmptyBookSetException {
        //Given
        createTestData();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2017, median);
    }

    private void createTestData() {
        bookSet.add(new Book("Adam Mickiewicz", "Harry Potter w Zamku Książ",
                1998, "DKL584652"));
        bookSet.add(new Book("Papcio Chmiel", "Przygody Tytusa, Romka i Atomka w czasach Covid",
                2020, "COVID-19"));
        bookSet.add(new Book("Adam Slodowy", "Zrob to sam", 1974, "OBITAKTOROBI"));
        bookSet.add(new Book("Jessica Kowalska", "Przewodnik po marketach polskich",
                2017, "KRDA#345"));
        bookSet.add(new Book("Zbigniew Stonoga", "Jak rozpetalem XX wojne swiatowa",
                2019, "SIGN0"));
        bookSet.add(new Book("Tomasz Gollob", "Historia Speedwaya", 2016, "SIGN1"));

    }
}