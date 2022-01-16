package com.ziad.contacts.controller;

import com.ziad.contacts.config.H2ServerManual;
import com.ziad.contacts.entity.ContactEntity;
import com.ziad.contacts.mapper.ContactsMapper;
import com.ziad.contacts.repository.ContactsRepository;
import org.openapitools.client.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactsController {

    @Autowired
    private ContactsRepository repo;

    @Autowired
    private ContactsMapper contactMapper;

    @PostMapping("/contacts")
    public ResponseEntity<ContactEntity> createContact (@RequestBody Contact myContact){
        System.out.println(myContact.getEmail());
        repo.saveAndFlush(contactMapper.mapContactEntity(myContact));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> getContact (@PathVariable("id") Long id){
        return new ResponseEntity(repo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactEntity>> getAllContacts (){
        return new ResponseEntity(repo.findAll(), HttpStatus.OK);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> updateContact (@PathVariable("id") Long id,@RequestBody Contact myContact){

        ContactEntity newEntity = repo.findById(id).get();
        newEntity.setName(myContact.getName());
        newEntity.setAddress(myContact.getAddress());
        newEntity.setName(myContact.getName());
        newEntity.setPhoneNumber(myContact.getPhone());
        newEntity.setEmail(myContact.getEmail());
        repo.saveAndFlush(newEntity);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> deleteContact (@PathVariable("id") Long id){
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
