package com.m1.s2.EJB.tp1;

import javax.ejb.Stateless;

@Stateless
public class CalcImpl implements CalcItf{

	@Override
	public double add(double d1, double d2) {
		return d1 + d2;
	}

	@Override
	public double sub(double d1, double d2) {
		return d1 - d2;
	}

	@Override
	public double mult(double d1, double d2) {
		return d1 * d2;
	}

	@Override
	public double div(double d1, double d2) throws DivByZeroException {
		if(d2 == 0 ) throw new DivByZeroException();
		return d1 / d2;
	}
}
