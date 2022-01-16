package com.ziad.contacts.mapper;

import com.ziad.contacts.entity.ContactEntity;
import org.openapitools.client.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactsMapper {
    public ContactEntity mapContactEntity(Contact myContact){
        ContactEntity entity = new ContactEntity();
        entity.setAddress(myContact.getAddress());
        entity.setName(myContact.getName());
        entity.setPhoneNumber(myContact.getPhone());
        entity.setEmail(myContact.getEmail());
        return entity;
    }
}
