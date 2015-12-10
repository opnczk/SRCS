package com.m1.s2.tmeCORBA.exo2.serveur;


/**
* ServeurPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mardi 24 mars 2015 12 h 27 CET
*/

public class ServeurPOATie extends ServeurPOA
{

  // Constructors

  public ServeurPOATie ( ServeurOperations delegate ) {
      this._impl = delegate;
  }
  public ServeurPOATie ( ServeurOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public ServeurOperations _delegate() {
      return this._impl;
  }
  public void _delegate (ServeurOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public double add (double x, double y)
  {
    return _impl.add(x, y);
  } // add

  public double sub (double x, double y)
  {
    return _impl.sub(x, y);
  } // sub

  public double mult (double x, double y)
  {
    return _impl.mult(x, y);
  } // mult

  public double div (double x, double y) throws DividedByZeroException
  {
    return _impl.div(x, y);
  } // div

  private ServeurOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ServeurPOATie
