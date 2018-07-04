package com.baizhi.cmfz.util;

import java.util.Random;

public class EncryptionUtils {
	public static String getRandomSalt(int len){
		char[] chs = "abcdefg1234567ABCDEFG".toCharArray();
		
		Random random = new Random();
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0 ; i < len ; i++){
			 builder.append(chs[random.nextInt(chs.length)]);
		}
		
		return builder.toString();
	}

}
