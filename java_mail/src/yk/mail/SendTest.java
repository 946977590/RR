package yk.mail;

import org.junit.Test;

public class SendTest {
	
	@Test
	public void toSendEmail(){
		try {
			Mail2.sendEmail("946977590@qq.com", "何毅");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
