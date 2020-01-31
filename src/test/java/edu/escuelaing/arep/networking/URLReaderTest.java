package edu.escuelaing.arep.networking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;

/**
 * Unit test for URLReader.
 */
public class URLReaderTest {

    @Test
    public void deberiaDarLas8SolicitudesEjercicio1() throws MalformedURLException{
        URLReader net = new URLReader();
        System.out.println(net.getProtocol() + "  Este es el protocolo");
        System.out.println(net.getAuthority() + "  Este es el Autority");
        System.out.println(net.getHost() + "  Este es el Host");
        System.out.println(net.getPort() + "  Este es el Puerto");
        System.out.println(net.getPath() + "  Este es el Path");
        System.out.println(net.getQuery() + "  Este es el Query");
        System.out.println(net.getFile() + "  Este es el Archivo");
        System.out.println(net.getRef() + "  Este es el Ref");
    }
    
    @Test
    public void deberiaLeerDatosDeInternetEjercicio2() throws MalformedURLException, IOException{
        URLReader net = new URLReader();
        URL google = new URL("http://www.google.com/");
        net.leerDatosDeInternet(google);
    }
    
}
