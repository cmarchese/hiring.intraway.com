

package com.raulgpena.application.controller;


import com.raulgpena.application.model.Address;
import com.raulgpena.application.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;


import static org.apache.commons.lang3.StringUtils.isEmpty;


@RestController
@RequestMapping ("students")
public class StudentController {



    private List<Student> list = Arrays.asList (

            new Student ("Raul Pena"),
            new Student ("Lucas Munoz"),
            new Student ("Hugo Orlando"),
            new Student ("Javier")
    );


    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<?> get () {

        return ResponseEntity.ok (this.list);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get (@PathVariable Integer id) {

        Student s = this.list.get (id);

        s.setAddress (new Address ("Cordoba", 1173));

        return ResponseEntity.ok (this.list.get (id));
    }

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody @Validated Student student) {


        return ResponseEntity.noContent().build();
    }
}