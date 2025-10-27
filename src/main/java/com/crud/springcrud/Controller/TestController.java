package com.crud.springcrud.Controller;

import com.crud.springcrud.Entity.Test;
import com.crud.springcrud.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    private TestRepo repo;

    @GetMapping("/welcome")
    public String getName(){
        return "Spring Crud";
    }

    @PostMapping("/createData")
    public ResponseEntity<String>  saveData(@RequestBody Test test){
        repo.save(test);
        return ResponseEntity.ok("Data Saved");
    }

    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Test> getData(@PathVariable Long id){
        Optional<Test> byId = repo.findById(id);
       if(byId.isPresent()){
            return ResponseEntity.ok(byId.get());
       }else {
           return ResponseEntity.notFound().build();
       }
    }

}
