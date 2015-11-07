package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	
	public static void main(String[] args) {
		String vin = "	0:4902014C5347\r	1:55413834423742\r2:45303733373930";
		System.out.println(hex2Char(vin));//LVSHCAME1EF705273
//		String vin = "7E810144902014C5347\r7E82155413834423742\r7E82245303733373930";
//		System.out.println(getHexContent(vin));//LSGUA84B7BE073790
	}
	/**获取：和\r中间的内容*/
	public static String getHexContent(String content){
		String[] strArr = content.split("\r");
		String hexResult = "";
		for (int i = 0; i < strArr.length; i++) {
			if(i==0){
				hexResult+=strArr[i].substring(7, strArr[i].length());
			}else{
				hexResult+=strArr[i].substring(5, strArr[i].length());
			}
		}
		hexResult = hexResult.replace("490201", "");
		int start = 0 ;
		String result = "";
		for (int end = 2; end <= hexResult.length(); ) {
			String tmpString = hexResult.substring(start,end);
			result+=asc2Char(Integer.valueOf(tmpString,16));
			start = end;
			end+=2;
		}
        return result;
    }
	
	/**16进制转字符串*/
	public static String hex2Char(String content){
		String result = "";
		String str = getVinByREG(content).replace("490201", "");
		int start = 0 ;
		for (int end = 2; end <= str.length(); ) {
			String tmpString = str.substring(start,end);
			result+=asc2Char(Integer.valueOf(tmpString,16));
			start = end;
			end+=2;
		}
		return result;
	}

	/**获取：和\r中间的内容*/
	public static String getVinByREG(String content){
		content+="\r";
		String str = "";
        Pattern pattern =Pattern.compile("(?<=\\:)(.+?)(?=\\\r)");
        Matcher matcher = pattern.matcher(content);
        while(matcher.find())
            str+=(matcher.group());
        return str;
    }
//	/**获取：和\r中间的内容*/
//	public static String getVinByREG(String content){
//		String str = "";
//        Pattern pattern =Pattern.compile("(?<=\\:)(.+?)(?=\\\r)");
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find())
//            str+=(matcher.group());
//        return str;
//    }
	/** * 字符转ASC * * @param st * @return */
	public static int char2Asc(String st) {
		byte[] gc = st.getBytes();
		int ascNum = (int) gc[0];
		return ascNum;
	}

	/** * ASC转字符 * * @param backnum * @return */
	public static char asc2Char(int backnum) {
		char strChar = (char) backnum;
		return strChar;
	}
}
