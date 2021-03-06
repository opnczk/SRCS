package com.m1.s2.tmeCORBA.cache;


/**
* com/m1/s2/tmeCORBA/cache/_FileSystemStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* mardi 31 mars 2015 12 h 16 CEST
*/

public class _FileSystemStub extends org.omg.CORBA.portable.ObjectImpl implements com.m1.s2.tmeCORBA.cache.FileSystem
{

  public String read (String Reference)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("read", true);
                $out.write_wstring (Reference);
                $in = _invoke ($out);
                String $result = $in.read_wstring ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return read (Reference        );
            } finally {
                _releaseReply ($in);
            }
  } // read

  public void write (String Reference, String Donnee)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("write", true);
                $out.write_wstring (Reference);
                $out.write_wstring (Donnee);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                write (Reference, Donnee        );
            } finally {
                _releaseReply ($in);
            }
  } // write

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:com/m1/s2/tmeCORBA/cache/FileSystem:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _FileSystemStub
