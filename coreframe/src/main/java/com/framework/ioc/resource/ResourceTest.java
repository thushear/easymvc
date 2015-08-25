package com.framework.ioc.resource;

import org.junit.Test;
import org.springframework.core.io.*;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class ResourceTest {

	@Test
	public void testByteArrayResource() {
		Resource resource = new ByteArrayResource("hello world".getBytes());
		if (resource.exists()) {
			dumpStream(resource);
		}
		Assert.isTrue(resource.isOpen() == false);
	}


	@Test
	public void testInputStreamResouce(){
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hello world".getBytes());
		Resource resource = new InputStreamResource(byteArrayInputStream);
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getDescription());

		Assert.isTrue(resource.isOpen() == true);
	}



	@Test
	public void testFileSystemResource(){
		File file = new File("D://table.txt");
		Resource resource = new FileSystemResource(file);
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.isOpen());
	}

	@Test
	public void testClassPathResourceByDefaultClassLoader() throws IOException {
		ClassPathResource resource = new ClassPathResource("spring-config.xml");
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getFile().getAbsolutePath());
		System.out.println(resource.isOpen());
	}


	@Test
	public void testClassPathResourceByClassLoader() throws IOException {
		ClassPathResource resource = new ClassPathResource("com/framework/ioc/resource/test.properties",this.getClass().getClassLoader()	);
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getFile().getAbsolutePath());
		System.out.println(resource.isOpen());
	}




	@Test
	public void testClassPathResourceByClazz() throws IOException {
		ClassPathResource resource = new ClassPathResource("com/framework/ioc/resource/test.properties",this.getClass()	);
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getFile().getAbsolutePath());
		System.out.println(resource.isOpen());


	}


	@Test
	public void testClassPathFromJar() throws IOException {
		ClassPathResource resource = new ClassPathResource("overview.html");
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getURL());
		System.out.println(resource.isOpen());
	}


	@Test
	public void testUrlResource() throws IOException {
		Resource resource = new UrlResource("file:d:/table.txt");
		if (resource.exists()){
			dumpStream(resource);
		}
		System.out.println(resource.getURL());
		System.out.println(resource.isOpen());

		Resource resource1 = new UrlResource("http://group.jd.com/index/20000001.htm");
		if (resource1.exists()){
			dumpStream(resource1);
		}
		System.out.println(resource1.getURL());
		System.out.println(resource1.isOpen());

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
