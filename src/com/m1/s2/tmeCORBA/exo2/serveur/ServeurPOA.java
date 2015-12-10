package com.m1.s2.tmeCORBA.exo2.serveur;


/**
* ServeurPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mardi 24 mars 2015 12 h 27 CET
*/

public abstract class ServeurPOA extends org.omg.PortableServer.Servant
 implements ServeurOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("sub", new java.lang.Integer (1));
    _methods.put ("mult", new java.lang.Integer (2));
    _methods.put ("div", new java.lang.Integer (3));
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
       case 0:  // Serveur/add
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.add (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // Serveur/sub
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.sub (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // Serveur/mult
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.mult (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // Serveur/div
       {
         try {
           double x = in.read_double ();
           double y = in.read_double ();
           double $result = (double)0;
           $result = this.div (x, y);
           out = $rh.createReply();
           out.write_double ($result);
         } catch (DividedByZeroException $ex) {
           out = $rh.createExceptionReply ();
           DividedByZeroExceptionHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Serveur:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Serveur _this() 
  {
    return ServeurHelper.narrow(
    super._this_object());
  }

  public Serveur _this(org.omg.CORBA.ORB orb) 
  {
    return ServeurHelper.narrow(
    super._this_object(orb));
  }


} // class ServeurPOA
