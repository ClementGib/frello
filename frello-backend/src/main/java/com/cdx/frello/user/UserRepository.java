package com.cdx.frello.user;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserRepository
        extends CrudRepository<User, Long> { // T est l'acronyme d'un générique, ID est la clé primaire assigné á l'User
}
