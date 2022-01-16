package com.ziad.contacts.repository;

import com.ziad.contacts.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ContactsRepository extends JpaRepository<ContactEntity, Long> {

}
