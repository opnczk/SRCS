package com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage;


/**
* DistantHashTablePackage/valueHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mardi 24 mars 2015 12 h 40 CET
*/

abstract public class valueHelper
{
  private static String  _id = "IDL:DistantHashTable/value:1.0";

  public static void insert (org.omg.CORBA.Any a, String that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static String extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_string_tc (888);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage.valueHelper.id (), "value", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static String read (org.omg.CORBA.portable.InputStream istream)
  {
    String value = null;
    value = istream.read_string ();
    if (value.length () > (888))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, String value)
  {
    if (value.length () > (888))      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    ostream.write_string (value);
  }

}
