/**
 * MyServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pers.liam.CountManagerClient;

public interface MyServiceImpl extends java.rmi.Remote {
    public int addUser(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean modify_userInfo() throws java.rmi.RemoteException;
    public java.lang.String get_userInfo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public int verify_userInfo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
