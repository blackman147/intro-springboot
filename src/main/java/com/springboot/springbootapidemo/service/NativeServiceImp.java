package com.springboot.springbootapidemo.service;

import com.springboot.springbootapidemo.data.Native;
import com.springboot.springbootapidemo.repository.NativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class NativeServiceImp implements NativeService{

    @Autowired
    private NativeRepository nativeRepository;

    @Override
    public Native registerNative(Native newNative) {
        Native foundNative = nativeRepository.findByEmail(newNative.getEmail());
        if (foundNative != null){
            throw new IllegalStateException("Email address already exists");
        }
        return nativeRepository.save(newNative);
    }

    @Override
    public void updateEmail(String oldEmail, String newEmail) {
       Native foundNative =  nativeRepository.findByEmail(oldEmail);
       if (foundNative == null){
           throw new IllegalStateException("Invalid emali address");
       }
       foundNative.setEmail(newEmail);
       nativeRepository.save(foundNative);

    }

    @Override
    public Native getNativeById(String id) {
        Optional<Native> optionalNative = nativeRepository.findById(id);
        Native foundNative;
        if (optionalNative.isPresent()){
            foundNative = optionalNative.get();
        }else {
            throw new IllegalStateException("Invalid native id");
        }
        return foundNative;
    }

    @Override
    public List<Native> getNativesByCohort(String cohort) {
        return nativeRepository.findNativeByCohort(cohort);
    }

    @Override
    public void deleteNative(String id) {
        Native foundNative = getNativeById(id);
        nativeRepository.delete(foundNative);
    }

    @Override
    public List<Native> getAllNatives() {
        return nativeRepository.findAll();
    }
}
