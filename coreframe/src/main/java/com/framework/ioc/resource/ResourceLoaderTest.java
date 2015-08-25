package com.framework.ioc.resource;

import org.junit.Test;
import org.springframework.core.io.*;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {


 @Test
 public void testResourceLoaderTest(){
  ResourceLoader resourceLoader = new DefaultResourceLoader();
  Resource resource1 = resourceLoader.getResource("classpath:com/framework/ioc/resource/test.properties");
  if (resource1.exists()){
   dumpStream(resource1);
  }
  System.out.println(resource1 +  " resource1 type :" + (resource1 instanceof ClassPathResource));

  Resource resource2 = resourceLoader.getResource("file:d:/table.txt");
  if (resource2.exists()){
   dumpStream(resource2);
  }
  System.out.println(resource2 +  " resource1 type :" + (resource2 instanceof UrlResource));

  Resource resource3 = resourceLoader.getResource("com/framework/ioc/resource/test.properties");
  if (resource3.exists()){
   dumpStream(resource3);
  }
  System.out.println(resource3 +  " resource1 type :" + (resource3 instanceof ClassPathResource));


 }

 private void dumpStream(Resource resource) {
  InputStream inputStream = null;
  try {
   inputStream = resource.getInputStream();
   int size = inputStream.available();
   byte[] buffer = new byte[size];
   inputStream.read(buffer);
   System.out.println(new String(buffer));
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   if (inputStream != null) {
    try {
     inputStream.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
  }

 }


} 
