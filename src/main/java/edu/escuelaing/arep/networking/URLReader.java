package edu.escuelaing.arep.networking;

import java.io.*;
import java.net.*;

public class URLReader {

    //Atributos
    private URL personalSite;

    public URLReader() throws MalformedURLException {
        personalSite = new URL("https://www.google.com.co:80/search?q=ferrari+812+jbalvin&rlz=1C1SQJL_enCO886CO886&oq=ferrari&aqs=chrome.2.69i57j35i39l2j0l5.6046j0j7&sourceid=chrome&ie=UTF-8#ferrari");
    }

    public void leerDatosDeInternet() throws MalformedURLException, IOException {
        URL google = new URL("http://www.google.com/");

        PrintWriter writer = new PrintWriter("resultado.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()));
        String inputLine = null;

        while ((inputLine = reader.readLine()) != null) {
            writer.write(inputLine);
        }
        writer.flush(); 
    }

    public static void leerUrl() {

        System.out.println("Ingrese la URL:");
        BufferedReader urlUsuario = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("la url Ingresada es: ");
        System.out.println(urlUsuario);
        PrintWriter prueba;

    }

    public String getProtocol() {
        return personalSite.getProtocol();
    }

    public String getAuthority() {
        return personalSite.getAuthority();
    }

    public String getHost() {
        return personalSite.getHost();
    }

    public int getPort() {
        return personalSite.getPort();
    }

    public String getPath() {
        return personalSite.getPath();
    }

    public String getQuery() {
        return personalSite.getQuery();
    }

    public String getFile() {
        return personalSite.getFile();
    }

    public String getRef() {
        return personalSite.getRef();
    }
}
