
package team.t.course.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the team.t.course.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ModifyUserInfoResponse_QNAME = new QName("pers.liam.countManager.MyService", "modify_userInfoResponse");
    private final static QName _VerifyUserInfo_QNAME = new QName("pers.liam.countManager.MyService", "verify_userInfo");
    private final static QName _AddUser_QNAME = new QName("pers.liam.countManager.MyService", "addUser");
    private final static QName _GetUserInfoResponse_QNAME = new QName("pers.liam.countManager.MyService", "get_userInfoResponse");
    private final static QName _GetUserInfo_QNAME = new QName("pers.liam.countManager.MyService", "get_userInfo");
    private final static QName _ModifyUserInfo_QNAME = new QName("pers.liam.countManager.MyService", "modify_userInfo");
    private final static QName _AddUserResponse_QNAME = new QName("pers.liam.countManager.MyService", "addUserResponse");
    private final static QName _VerifyUserInfoResponse_QNAME = new QName("pers.liam.countManager.MyService", "verify_userInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: team.t.course.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifyUserInfoResponse }
     * 
     */
    public ModifyUserInfoResponse createModifyUserInfoResponse() {
        return new ModifyUserInfoResponse();
    }

    /**
     * Create an instance of {@link VerifyUserInfo }
     * 
     */
    public VerifyUserInfo createVerifyUserInfo() {
        return new VerifyUserInfo();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetUserInfoResponse }
     * 
     */
    public GetUserInfoResponse createGetUserInfoResponse() {
        return new GetUserInfoResponse();
    }

    /**
     * Create an instance of {@link GetUserInfo }
     * 
     */
    public GetUserInfo createGetUserInfo() {
        return new GetUserInfo();
    }

    /**
     * Create an instance of {@link ModifyUserInfo }
     * 
     */
    public ModifyUserInfo createModifyUserInfo() {
        return new ModifyUserInfo();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link VerifyUserInfoResponse }
     * 
     */
    public VerifyUserInfoResponse createVerifyUserInfoResponse() {
        return new VerifyUserInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "modify_userInfoResponse")
    public JAXBElement<ModifyUserInfoResponse> createModifyUserInfoResponse(ModifyUserInfoResponse value) {
        return new JAXBElement<ModifyUserInfoResponse>(_ModifyUserInfoResponse_QNAME, ModifyUserInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "verify_userInfo")
    public JAXBElement<VerifyUserInfo> createVerifyUserInfo(VerifyUserInfo value) {
        return new JAXBElement<VerifyUserInfo>(_VerifyUserInfo_QNAME, VerifyUserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "get_userInfoResponse")
    public JAXBElement<GetUserInfoResponse> createGetUserInfoResponse(GetUserInfoResponse value) {
        return new JAXBElement<GetUserInfoResponse>(_GetUserInfoResponse_QNAME, GetUserInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "get_userInfo")
    public JAXBElement<GetUserInfo> createGetUserInfo(GetUserInfo value) {
        return new JAXBElement<GetUserInfo>(_GetUserInfo_QNAME, GetUserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "modify_userInfo")
    public JAXBElement<ModifyUserInfo> createModifyUserInfo(ModifyUserInfo value) {
        return new JAXBElement<ModifyUserInfo>(_ModifyUserInfo_QNAME, ModifyUserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "pers.liam.countManager.MyService", name = "verify_userInfoResponse")
    public JAXBElement<VerifyUserInfoResponse> createVerifyUserInfoResponse(VerifyUserInfoResponse value) {
        return new JAXBElement<VerifyUserInfoResponse>(_VerifyUserInfoResponse_QNAME, VerifyUserInfoResponse.class, null, value);
    }

}
