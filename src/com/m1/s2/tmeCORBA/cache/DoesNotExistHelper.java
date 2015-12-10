package com.m1.s2.tmeCORBA.cache;


/**
* com/m1/s2/tmeCORBA/cache/DoesNotExistHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* mardi 31 mars 2015 12 h 16 CEST
*/

abstract public class DoesNotExistHelper
{
  private static String  _id = "IDL:com/m1/s2/tmeCORBA/cache/DoesNotExist:1.0";

  public static void insert (org.omg.CORBA.Any a, com.m1.s2.tmeCORBA.cache.DoesNotExist that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.m1.s2.tmeCORBA.cache.DoesNotExist extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_wstring_tc (0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (com.m1.s2.tmeCORBA.cache.ReferenceHelper.id (), "Reference", _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "r",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (com.m1.s2.tmeCORBA.cache.DoesNotExistHelper.id (), "DoesNotExist", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.m1.s2.tmeCORBA.cache.DoesNotExist read (org.omg.CORBA.portable.InputStream istream)
  {
    com.m1.s2.tmeCORBA.cache.DoesNotExist value = new com.m1.s2.tmeCORBA.cache.DoesNotExist ();
    // read and discard the repository ID
    istream.read_string ();
    value.r = istream.read_wstring ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.m1.s2.tmeCORBA.cache.DoesNotExist value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_wstring (value.r);
  }

}
