package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base;
import pages.Login;

public class LoginPageTestCase{
	
	@Test
	public void loginWithValidCredential()
	{
		System.out.println("starting pass test case");
		String userName = "mngr355558";
		String password = "sazypyg";
		System.out.println("1111111111");
		Assert.assertEquals(true, true);
		//Login log = new Login(driver);
		//log.login(userName, password);
		System.out.println("ending pass test case");
	}
	
	@Test
	public void resetTest()
	{
		System.out.println("starting failed test case");
		String userName = "mngr355558";
		String password = "sazypyg";
		System.out.println("22222222");
		Assert.assertEquals(true, false);
		//Login log = new Login(driver);
		//log.reset(userName, password);
		System.out.println("ending failed test case");
	}
	@Test
	public void resetTest1()
	{
		System.out.println("starting failed test case");
		String userName = "mngr355558";
		String password = "sazypyg";
		System.out.println("22222222");
		Assert.assertEquals(true, false);
		//Login log = new Login(driver);
		//log.reset(userName, password);
		System.out.println("ending failed test case");
	}

}
