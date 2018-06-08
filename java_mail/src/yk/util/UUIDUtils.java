package yk.util;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	/*public static void main(String[] args) {
		System.out.println(getUUId());
	}*/
}
