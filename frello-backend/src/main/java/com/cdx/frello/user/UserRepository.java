package com.cdx.frello.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends CrudRepository<User, Long> {
    // T est l'acronyme d'un générique, ID est la clé primaire assigné á l'User

    User findByUserId(Long userId);
}
