package com.example.PracticaXml.client;

import com.example.PracticaXml.user.User;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class JavaClient {

    public static void main(String[] args ) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL( new URL("http://localhost:1200" ) );
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig( config );
        Object[] params = {"Luis Manuel", 1};
        client.execute( "Handler.createUser",  params);
    }
}
