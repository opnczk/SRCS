package com.m1.s2.tmeCORBA.exo3;


/**
* DistantHashTablePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mardi 24 mars 2015 12 h 40 CET
*/

public abstract class DistantHashTablePOA extends org.omg.PortableServer.Servant
 implements DistantHashTableOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("containsKey", new java.lang.Integer (0));
    _methods.put ("get", new java.lang.Integer (1));
    _methods.put ("put", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // DistantHashTable/containsKey
       {
         String k = com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage.keyHelper.read (in);
         boolean $result = false;
         $result = this.containsKey (k);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // DistantHashTable/get
       {
         String k = com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage.keyHelper.read (in);
         String $result = null;
         $result = this.get (k);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // DistantHashTable/put
       {
         String k = com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage.keyHelper.read (in);
         String val = com.m1.s2.tmeCORBA.exo3.DistantHashTablePackage.valueHelper.read (in);
         this.put (k, val);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DistantHashTable:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public DistantHashTable _this() 
  {
    return DistantHashTableHelper.narrow(
    super._this_object());
  }

  public DistantHashTable _this(org.omg.CORBA.ORB orb) 
  {
    return DistantHashTableHelper.narrow(
    super._this_object(orb));
  }


} // class DistantHashTablePOA