package com.m1.s2.EJB.tp1;

import javax.ejb.Remote;

@Remote
public interface CalcItf {

  public double add(double d1, double d2);

  public double sub(double d1, double d2);

  public double mult(double d1, double d2);

  public double div(double d1, double d2) throws DivByZeroException;

}