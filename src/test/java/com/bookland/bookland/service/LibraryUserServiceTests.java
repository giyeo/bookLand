package com.bookland.bookland.service;

import com.bookland.bookland.model.LibraryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryUserServiceTests {

    @Autowired
    LibraryUserService libraryUserService;

    @Test
    public void getLibraryUserIsNonNull() {
        LibraryUser user = libraryUserService.getLibraryUser(1L);
        Assertions.assertNotNull(user);
    }

    @Test
    public void getLibraryUserIsNull() {
        LibraryUser user = libraryUserService.getLibraryUser(0L);
        Assertions.assertNull(user);
    }

}
