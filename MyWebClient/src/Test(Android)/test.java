package Test;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class test {
    public static void main(String[] args){
        SoapObject request = new SoapObject("pers.liam.countManager.MyService","addUser");
        request.addProperty("arg0","13688888888");
        request.addProperty("arg1","lzh0000000000");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.bodyOut = request;
        HttpTransportSE ht = new HttpTransportSE("http://localhost:8080/MyService?wsdl");
        try {
            ht.call(null,envelope);
            if (envelope.getResponse() != null){
                SoapObject soapObject = (SoapObject) envelope.bodyIn;
                String n = soapObject.getProperty(0).toString();
                if (n.equals("1"))
                    System.out.println("hr");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
