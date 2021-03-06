package com.m1.s2.tmeCORBA.exo2.serveur;


/**
* ServeurHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mardi 24 mars 2015 12 h 27 CET
*/

abstract public class ServeurHelper
{
  private static String  _id = "IDL:Serveur:1.0";

  public static void insert (org.omg.CORBA.Any a, Serveur that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Serveur extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ServeurHelper.id (), "Serveur");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Serveur read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ServeurStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Serveur value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Serveur narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Serveur)
      return (Serveur)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _ServeurStub stub = new _ServeurStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Serveur unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Serveur)
      return (Serveur)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _ServeurStub stub = new _ServeurStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
