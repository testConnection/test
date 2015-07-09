package asserts;

import org.junit.Test;
import org.junit.Assert;


public class JunitTest {
	
	@Test
	public void test() {
		int num1 = 1;
		int num2 = 2;
		int sum = num1 + num2;
		Assert.assertEquals(4, sum);
	}

}
