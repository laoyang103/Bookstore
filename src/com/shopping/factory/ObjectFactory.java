package com.shopping.factory;

import com.shopping.util.PropUtil;

public class ObjectFactory {
	public static Object getInstance(String className) {
		Object object = null;
		className = PropUtil.getValue(className, "daoConfig.properties");
		try {
			object = Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
