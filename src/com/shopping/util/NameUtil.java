package com.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NameUtil {
	public static String createSalesOrderId() {
		StringBuffer string = new StringBuffer();
		String time = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
		string.append(time);
		for (int i = 0; i < 4; i++) {
			int x = new Random().nextInt(10);
			string.append(x);
		}
		return string.toString();
	}
}
