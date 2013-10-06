package test;

import org.junit.Test;

import util.JdbcUtil;


public class test {
	@Test
	public void jdbctest(){
		JdbcUtil ju=new JdbcUtil();
		ju.getConn();
	}
}
