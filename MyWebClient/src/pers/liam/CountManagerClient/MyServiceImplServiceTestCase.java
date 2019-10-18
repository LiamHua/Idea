/**
 * MyServiceImplServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pers.liam.CountManagerClient;

public class MyServiceImplServiceTestCase extends junit.framework.TestCase {
    public MyServiceImplServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testMyServiceImplPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getMyServiceImplPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1MyServiceImplPortAddUser() throws Exception {
        pers.liam.CountManagerClient.MyServiceImplPortBindingStub binding;
        try {
            binding = (pers.liam.CountManagerClient.MyServiceImplPortBindingStub)
                          new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getMyServiceImplPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.addUser(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test2MyServiceImplPortModify_userInfo() throws Exception {
        pers.liam.CountManagerClient.MyServiceImplPortBindingStub binding;
        try {
            binding = (pers.liam.CountManagerClient.MyServiceImplPortBindingStub)
                          new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getMyServiceImplPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.modify_userInfo();
        // TBD - validate results
    }

    public void test3MyServiceImplPortGet_userInfo() throws Exception {
        pers.liam.CountManagerClient.MyServiceImplPortBindingStub binding;
        try {
            binding = (pers.liam.CountManagerClient.MyServiceImplPortBindingStub)
                          new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getMyServiceImplPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.get_userInfo(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test4MyServiceImplPortVerify_userInfo() throws Exception {
        pers.liam.CountManagerClient.MyServiceImplPortBindingStub binding;
        try {
            binding = (pers.liam.CountManagerClient.MyServiceImplPortBindingStub)
                          new pers.liam.CountManagerClient.MyServiceImplServiceLocator().getMyServiceImplPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.verify_userInfo(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

}
