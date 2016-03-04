package com.shopping.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	public static String getValue(String key,String fileName) {
		String value = null;
		//新建Properties
		Properties prop = new Properties();
		//通过类加载器，用文件名拿到输入流
		InputStream is = PropUtil.class.getClassLoader().getResourceAsStream(fileName);
		try {
			//property载入输入流
			prop.load(is);
			//通过key拿值
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
}