package com.framework.ioc.resource;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;

public class AntPathMatcherTest {

   private PathMatcher pathMatcher = new AntPathMatcher();


   @Test
   public void testQuestionMark(){
    Assert.isTrue(pathMatcher.match("com/t?st.xml", "com/test.xml"));
   Assert.isTrue(!pathMatcher.match("config?.xml","config12.xml"));

   }

   @Test
   public void testOneAsterisk(){
     Assert.isTrue(pathMatcher.match("config*.xml","config-dao.xml"));

   }

} 
