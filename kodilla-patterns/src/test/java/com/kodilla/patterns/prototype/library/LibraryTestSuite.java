package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks()
                        .add(new Book("Book no. " + n,
                                "Author no. " + n,
                                LocalDate.of(1999 + n, 1 + n, 1 + n))));

        Library shallowLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
            shallowLibrary.setName("Shallow Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepLibrary = null;
        try {
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Deep Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);

        //When
        library.getBooks().add(new Book("New Book", "New Author", LocalDate.now()));
        System.out.println("-------------another print------------");
        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);

        //Then
        Assert.assertEquals(6, library.getBooks().size());
        Assert.assertEquals( 6, shallowLibrary.getBooks().size());
        Assert.assertEquals(5, deepLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), shallowLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepLibrary.getBooks());
    }
}
