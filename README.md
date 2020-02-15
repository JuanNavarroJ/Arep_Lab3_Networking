# Taller Clientes y Servicios

## Link aplicación web

[Aplicación en Heroku]()

---

### Ejercicio #1

En el ejercicio #1 se busca hacer un programa que dado una URL nos de la siguiente información sobre la URL:
-	Protocolo
-	Host
-	Puerto
-	Carpeta
-	Búsqueda
-	Archivo
-	Referencia
-	Autoridad

Lo realizaremos con la siguiente prueba:

  ```java
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
  ```
Para verificar el funcionamiento basta con ejecutar el comando **$mvn test**
Que nos da como resultado:

![ej1-1](https://user-images.githubusercontent.com/44879884/74596407-c43f2380-501c-11ea-8a34-0ad6a4f0fbd7.PNG)


### Ejercicio #2

En este ejercicio se busca crear una aplicación browser que dada una URL lea los datos de la dirección y los almacene en un archivo .html.

Realizamos la siguiente implementación:

```java
    public static void leerDatosDeInternet(URL page) throws MalformedURLException, IOException {
        PrintWriter writer = new PrintWriter("resultado.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(page.openStream()));
        String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
            writer.write(inputLine);
        }
        writer.flush();
    }
```

Y la siguiente prueba para verificar su funcionamiento:

```java
    @Test
    public void deberiaLeerDatosDeInternetEjercicio2() throws MalformedURLException, IOException{
        URLReader net = new URLReader();
        URL google = new URL("http://www.google.com/");
        net.leerDatosDeInternet(google);
    }
```

Y la pagina generada es:

![ej2-1](https://user-images.githubusercontent.com/44879884/74596605-a1fad500-501f-11ea-92f4-3e8a11a8f023.PNG)


### Ejercicio #3



### Reto #1

### Reto #2


---

### Prerequisites

Debemos tener los siguientes programas instalados:
```
- Maven 
- Git
- Navegador web
```

## ¿Como instalar y probar?


## Despliegue continuo



## Desarrollo


Construido con:

-   [Maven](https://maven.apache.org/)  - Control de dependencias

-	 [CircleCI](https://circleci.com/)  - Despliegue continuo

-	 [Heroku](https://dashboard.heroku.com/apps) - Plataforma Web



## Autor

-   **Juan David Navarro Jimenez**    -  [JuanNavarroJ](https://github.com/JuanNavarroJ)


## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](https://github.com/JuanNavarroJ/ProyectoPSP0/blob/master/LICENSE.txt) file for details.
