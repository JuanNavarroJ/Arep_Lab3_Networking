/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.networking;

import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Juan David
 */
public class HttpServer {

    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket serverSocket = null;
            int port = getPort();
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("GET")) {
                    String[] listaURL = inputLine.split("/");
                    String[] get = listaURL[1].split(" ");
                    if (get[0].contains(".jpg")) {
                        img("/src/main/resources/img/" + get[0], clientSocket.getOutputStream());
                    }else if(get[0].contains(".html")) {
                	html("/src/main/resources/hmtl/"+get[0],clientSocket.getOutputStream());
                    }else if(get[0].contains(".js")) {
                	js("/src/main/resources/js/"+get[0],clientSocket.getOutputStream());	
                }                   

                }
                if (!in.ready()) {
                    break;
                }
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static void img(String element, OutputStream clientOutput) throws IOException {
        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + element));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(clientOutput);
            ImageIO.write(image, "PNG", ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeimg.writeBytes("Content-Type: image/png \r\n");
            writeimg.writeBytes("\r\n");
            writeimg.write(ArrBytes.toByteArray());
        } catch (IOException e) {

        }
    }
    
    private static void html(String element,OutputStream outputStream) throws IOException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir")+element));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null){
                cont = cont + line;  
            }
            outputStream.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {   
        }
    } 
    
    private static void js(String element,OutputStream outputStream) throws IOException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir")+element));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null){
                cont = cont + line;  
            }
            outputStream.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {   
        }
    } 
}
