package com.bookland.bookland.service;

import com.bookland.bookland.model.LibraryUser;
import com.bookland.bookland.repository.LibraryUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserService {

    private static final Logger logger = LogManager.getLogger(LibraryUserService.class);

    @Autowired
    private LibraryUserRepository libraryUserRepository;

    public LibraryUser getLibraryUser(Long id) { return libraryUserRepository.findById(id).orElse(null); }

}
