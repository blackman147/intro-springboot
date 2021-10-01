package com.springboot.springbootapidemo.service;

import com.springboot.springbootapidemo.data.Native;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NativeService {

   Native registerNative(Native newNative);
   void updateEmail(String oldEmail, String newNative);
   Native getNativeById(String id);
   List<Native> getNativesByCohort(String cohort);
   void deleteNative(String id);
   List<Native> getAllNatives();

}
