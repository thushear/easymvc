 /**
 * 
 */
package com.framework.coremvc.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 
 * 
 * @author kongming
 *
 *
 */
public class ScanClassPathUtil {
	
	
	private List<String>  classFilters;

	
		
	public ScanClassPathUtil(List<String> classFilters) {
		super();
		this.classFilters = classFilters;
	}




	public Set<Class<?>> getClassesUnderPkg(String basePkg,boolean recursive){
		Set<Class<?>>  classes  = new LinkedHashSet<Class<?>>();
		String basePackageName = basePkg;
		if(basePackageName.endsWith(".")){
			basePackageName = basePackageName.substring(0, basePackageName.length() - 1);
		}
		String  package2Path = basePackageName.replace('.', '/');
		try {
			Enumeration<URL> urls =  Thread.currentThread().getContextClassLoader().getResources(package2Path);
			while(urls.hasMoreElements()){
			    URL url = urls.nextElement();
			    String protocol = url.getProtocol();
			    if("file".equals(protocol)){
			    	String filePath =  URLDecoder.decode(url.getFile(),"UTF-8");
			    	scanClassesByFile(basePkg, classes,filePath, recursive);
			    }
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
		}

	
	
	
	private void scanClassesByFile(String basePkg, Set<Class<?>> classes,
			String filePath, boolean recursive) {
		// TODO Auto-generated method stub
		File baseFile = new File(filePath);
		if(!baseFile.exists() || !baseFile.isDirectory()){
			return ;
		}
		final boolean recurflag = recursive;
		File[] files =  baseFile.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				//
 				if(pathname.isDirectory()){
					return recurflag;
				}
				String fileName = pathname.getName();
				if(fileName.indexOf("$") != -1){
					return false;
				}
				return filterClass(pathname);
			}
		});
		
		for(File file : files){
			if(file.isDirectory()){
				scanClassesByFile(basePkg + "." + file.getName(), classes, file.getAbsolutePath(), recursive);
			}else{
				String className =  file.getName();
				className = className.substring(0,className.length() - 6);
				try {
					Class<?> newclass =  Thread.currentThread().getContextClassLoader().loadClass( basePkg + "." + className );
					classes.add(newclass);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}




	protected boolean filterClass(File pathname) {
		// TODO Auto-generated method stub
		String fileName = pathname.getName();
		if(!fileName.endsWith(".class")){
			return false;
		}
		if(classFilters == null || classFilters.isEmpty()){
			return true;
		}
		
		for (String regex : classFilters) {
			String temRegx  =  "^" + regex.replaceAll("*", ".*") + "$";
			Pattern pattern = Pattern.compile(temRegx);
			if(pattern.matcher(fileName).find()){
				return true;
			}
		}
		
		return false;
	}

	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Thread.currentThread().getContextClassLoader().loadClass( "com.framework" + "." + "App" );
		ScanClassPathUtil scanClassPathUtil = new ScanClassPathUtil(null);
		Set<Class<?>> result = scanClassPathUtil.getClassesUnderPkg("com.framework", true);
		System.out.println(result);					
//			
    }		
	
	
}
