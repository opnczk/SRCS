package com.m1.s2.tmeCORBA.cache;

/**
* com/m1/s2/tmeCORBA/cache/DoesNotExistHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* mardi 31 mars 2015 12 h 16 CEST
*/

public final class DoesNotExistHolder implements org.omg.CORBA.portable.Streamable
{
  public com.m1.s2.tmeCORBA.cache.DoesNotExist value = null;

  public DoesNotExistHolder ()
  {
  }

  public DoesNotExistHolder (com.m1.s2.tmeCORBA.cache.DoesNotExist initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.m1.s2.tmeCORBA.cache.DoesNotExistHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.m1.s2.tmeCORBA.cache.DoesNotExistHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.m1.s2.tmeCORBA.cache.DoesNotExistHelper.type ();
  }

}