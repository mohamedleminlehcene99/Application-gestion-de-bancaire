package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.ContactDto;
import com.lehcene.app_bancaire.services.impl.ContactServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Tag(name = "Contact")
public class ContactRestController {

    private final ContactServiceImpl contactService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.save(contactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{contact_id}")
    public ResponseEntity<ContactDto> findContactById(@PathVariable("contact_id") Integer contact_id){
        return ResponseEntity.ok(contactService.findById(contact_id));
    }

    @DeleteMapping("/{contact_id}")
    public ResponseEntity<Void> delete(@PathVariable("contact_id") Integer contact_id){
        contactService.delete(contact_id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<ContactDto>> findAllContactsByUserId(@PathVariable("user_id") Integer user_id){
        return ResponseEntity.ok(contactService.getAllContactsByUserId(user_id));
    }

}
