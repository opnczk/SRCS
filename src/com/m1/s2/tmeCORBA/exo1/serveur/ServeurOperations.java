package com.m1.s2.tmeCORBA.exo1.serveur;

/**
 * ServeurOperations.java . Generated by the IDL-to-Java compiler (portable),
 * version "3.2" from interface.idl mardi 24 mars 2015 12 h 27 CET
 */

public interface ServeurOperations {
	double add(double x, double y);

	double sub(double x, double y);

	double mult(double x, double y);

	double div(double x, double y) throws DividedByZeroException;
} // interface ServeurOperations