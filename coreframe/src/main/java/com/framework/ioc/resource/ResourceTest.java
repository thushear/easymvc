package com.framework.ioc.resource;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
