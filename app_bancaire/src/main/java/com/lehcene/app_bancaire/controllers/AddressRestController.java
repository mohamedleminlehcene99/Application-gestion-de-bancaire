package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.AddressDto;
import com.lehcene.app_bancaire.services.impl.AddressServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
@Tag(name = "Address")
public class AddressRestController {

    private final AddressServiceImpl addressService;

    //save

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.save(addressDto));
    }

    //findAll

    @GetMapping("/")
    public ResponseEntity<List<AddressDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    //findById

    @GetMapping("/{address_id}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable("address_id") Integer address_id){
        return ResponseEntity.ok(addressService.findById(address_id));
    }

    //delete

    @DeleteMapping("/{address_id}")
    public ResponseEntity<Void> delete(@PathVariable("address_id") Integer address_id){
        addressService.delete(address_id);
        return ResponseEntity.accepted().build();
    }
}

