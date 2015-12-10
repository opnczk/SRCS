package com.m1.s2.EJB.tp1;

public class CalcTester {

	public static void main(String args[]) throws Exception{
		javax.naming.Context ic = new javax.naming.InitialContext();
		CalcItf bean = (CalcItf) ic.lookup("CalcImpl");
		double res = bean.add(2, 2);
		System.out.println(res);
	}
}
