package com.example.demo.api;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactService contactService;

//    @RequestMapping(value = "/contact/", method = RequestMethod.GET)
    @GetMapping("/contact/")
    public ResponseEntity<Contact> listAllContact(){
        Contact contact= contactService.findContactById(2);

        if(contact == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(contact,HttpStatus.OK);
    }


}
