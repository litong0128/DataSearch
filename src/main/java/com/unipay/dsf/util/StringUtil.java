package com.unipay.dsf.util;


/**
 * Filename:StringUtil.java
 * Description: 字符串处理
 * @author litong
 * @date 2017年3月20日 下午4:28:59
 */
public class StringUtil {

	/**
	 * 验证空对象
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str) || "null".equals(str));
	}

	public static String hideMiddle(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int length = str.length();
		if (length <= 2) {
			return str;
		} else {
			int pre = length / 3;
			if (pre > 10) {
				pre = 10;
			}
			sb.append(str.substring(0, pre));
			for (int i = 0; i < (length - 2 * pre); i++) {
				sb.append("*");
			}
			sb.append(str.substring(length - pre));
		}
		return sb.toString();
	}

	/**
	 * 将首字母转换小写
	 * @param str
	 * @return
	 */
	public static String captureName(String name) {
		// name = name.substring(0, 1).toUpperCase() + name.substring(1);
		// return name;
		char[] cs = name.toCharArray();
		cs[0] += 32;
		return String.valueOf(cs);

	}

	
	/**
	 * 将首字母转换大写
	 * @param str
	 * @return
	 */
	public static String captureNameUp(String name) {
		// name = name.substring(0, 1).toUpperCase() + name.substring(1);
		// return name;
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}
	
	public static void main(String[] args) {
		String str = "wertttdgvagargarvczdvafgadjfan39348349q";
		System.out.println(hideMiddle(str));
		
		System.out.println(captureNameUp("tTT"));
	}

}
