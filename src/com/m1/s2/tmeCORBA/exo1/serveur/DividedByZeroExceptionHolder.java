package com.m1.s2.tmeCORBA.exo1.serveur;

/**
 * DividedByZeroExceptionHolder.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from interface.idl mardi 24 mars 2015 12 h 27 CET
 */

public final class DividedByZeroExceptionHolder implements
		org.omg.CORBA.portable.Streamable {
	public DividedByZeroException value = null;

	public DividedByZeroExceptionHolder() {
	}

	public DividedByZeroExceptionHolder(DividedByZeroException initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = DividedByZeroExceptionHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		DividedByZeroExceptionHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return DividedByZeroExceptionHelper.type();
	}

}
