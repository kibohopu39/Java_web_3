package java_ee20200208;

import Kai_mysql.BCrypt;

public class Kai_api_20200208 {
	public static boolean chPasswd(String plainPW, String hashPW) {
		boolean isRight = false;
		System.out.println("1:"+plainPW);
		System.out.println("2:"+hashPW);
		if (hashPW.startsWith("$2a$")) {
			isRight = BCrypt.checkpw(plainPW, hashPW);
		} else {
			isRight = true;
		}
		return isRight;
	}
}
