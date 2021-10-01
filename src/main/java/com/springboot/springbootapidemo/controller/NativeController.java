package com.springboot.springbootapidemo.controller;

import com.springboot.springbootapidemo.data.Native;
import com.springboot.springbootapidemo.service.NativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NativeController {

    @Autowired
    private NativeService nativeService;

    @PostMapping("/register")
    public Native registerNative(@RequestBody Native newNative){
        return nativeService.registerNative(newNative);
    }

    @PutMapping("/update")
    public void updateEmail(@RequestParam String oldEmail,
                            @RequestParam String newEmail){
        nativeService.updateEmail(oldEmail, newEmail);
    }

    @GetMapping("/natives/{id}")
    public Native getNative(@PathVariable("id") String id){
        return nativeService.getNativeById(id);
    }

    @GetMapping("/cohort/{name}")
    public List<Native> getNativesByCohort(@PathVariable("name") String name){
        return nativeService.getNativesByCohort(name);
    }

    @DeleteMapping("/natives/{id")
    public void deleteNative(@PathVariable("id") String id){
        nativeService.deleteNative(id);
    }

    @GetMapping( "/natives/")
    public List<Native> getAllNatives(){
        return nativeService.getAllNatives();
    }
}
