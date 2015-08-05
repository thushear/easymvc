package com.framework.ioc.di;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/8/5.
 */
public class SingletonClassLoader  extends  ClassLoader{


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Assert.hasText(name , "name must not be null");
        if(!name.startsWith("com.framework")){
            return super.loadClass(name);
        }

        String clazzName = name.replace(".","/") + ".class";
        try {
            InputStream inputStream = new ClassPathResource(clazzName).getInputStream();
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes,0,available);
            return defineClass(name,bytes,0,available);
        } catch (IOException e) {
            e.printStackTrace();
            return super.loadClass(name);
        }

    }
}
