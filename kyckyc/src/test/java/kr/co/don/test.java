package kr.co.don;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class test {

	@Test
	public void test01() {
		System.out.println("잘 들어 왔을까?");
		
	}
	@Test
	public void test02() {
		System.out.println("Specialty?");
		
	}
}
