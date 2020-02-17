# Taller Clientes y Servicios

## Link aplicación web

[Aplicación en Heroku](https://arep-lab3-serverweb.herokuapp.com/P911.jpg)

Para verificar el funcionamiento tenemos diferentes recursos cargados en el servidor los cuales son:

- PrimeraWeb.html
- MG63.jpg
- BM4.jpg
- P911.jpg
- Js.js

Para probar al final de la url ponemos el nombre y extensión del recurso el cual queremos obtener.

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


### Reto #1

En este reto se busca crear un servidor web el cual sea capaz de resolver solicitudes de recursos el cual el cliente desea nuestro servidor deberá ser capaz de resolver recursos con extensión .jpg .html y .js 

Para verificar el funcionamiento ingresamos al enlace de la aplicación [desplegada en heruku](https://arep-lab3-serverweb.herokuapp.com/) y en es en esta donde vamos a realizar las solicitudes al servidor por ejemplo vamos a realizar una solicitud a una imagen que tenemos en nuestro directorio local.

Para verificar el funcionamiento tenemos diferentes recursos cargados en el servidor los cuales son:

- PrimeraWeb.html
- MG63.jpg
- BM4.jpg
- P911.jpg
- Js.js

Realizaremos la prueba con el recurso MG63.jpg para eso vamos al siguiente link: https://arep-lab3-serverweb.herokuapp.com/MG63.jpg como podemos observar solo ponemos el nombre del recurso el cual queremos obtener.

Verificamos la solicitud en el servidor.

![rt2](https://user-images.githubusercontent.com/44879884/74609380-a8d52680-50b7-11ea-895d-8424f45ff1d2.PNG)

---

### Prerequisites

Debemos tener los siguientes programas instalados:
```
- Maven 
- Git
- Navegador web
```

## ¿Como instalar y probar?

Debemos tener un editor java instalado y git, es opcional tener instalado el uso de maven que permitira un mejor control sobre el proyecto.

1. Entramos la terminal del dispositivo y accedemos a la carpeta en la cual queremos guardar el proyecto. 

![1](https://user-images.githubusercontent.com/44879884/74609595-7c220e80-50b9-11ea-97d9-3ed8e0f22110.PNG)

2. Usando los comandos de git empezamos con : **$ git clone** https://github.com/JuanNavarroJ/Arep_Lab3_Networking.git e Ingresamos a la carpeta que descargamos desde Github.

![2](https://user-images.githubusercontent.com/44879884/74609596-7c220e80-50b9-11ea-95a4-ff63908956a0.PNG)

3. Usando maven podemos en la linea de comandos compilar y ejecutar el proyecto con el codigo **$ mvn package**

![3a](https://user-images.githubusercontent.com/44879884/74609597-7cbaa500-50b9-11ea-94d3-96d03cbdcba7.PNG)
![3b](https://user-images.githubusercontent.com/44879884/74609588-7a584b00-50b9-11ea-83ba-557c8f9ed8b5.PNG)

4. Si solo deseas correr las pruebas podemos ejecutar el comando maven **$ mvn test**

![4a](https://user-images.githubusercontent.com/44879884/74609589-7af0e180-50b9-11ea-82eb-d9e987faa336.PNG)
![4b](https://user-images.githubusercontent.com/44879884/74609591-7af0e180-50b9-11ea-954d-4403158e782a.PNG)

5. Si deseas conocer a profundidad el funcionamiento del codigo, podemos abrir el proyecto en un editor java.

![5](https://user-images.githubusercontent.com/44879884/74609592-7b897800-50b9-11ea-9ed6-05c8e007c152.PNG)

6. Para generar el javadoc ejecutamos el comando **$ mvn javadoc:javadoc**

![6a](https://user-images.githubusercontent.com/44879884/74609593-7b897800-50b9-11ea-86ae-375191c1bf41.PNG)
![6b](https://user-images.githubusercontent.com/44879884/74609594-7c220e80-50b9-11ea-8d7c-2a6e39795a7b.PNG)

## Despliegue continuo

[![CircleCI](https://circleci.com/gh/JuanNavarroJ/Arep_Lab3_Networking.svg?style=svg)](https://circleci.com/gh/JuanNavarroJ/Arep_Lab3_Networking)

## Desarrollo

Construido con:

-   [Maven](https://maven.apache.org/)  - Control de dependencias

-	 [CircleCI](https://circleci.com/)  - Despliegue continuo

-	 [Heroku](https://dashboard.heroku.com/apps) - Plataforma Web

## Autor

-   **Juan David Navarro Jimenez**    -  [JuanNavarroJ](https://github.com/JuanNavarroJ)

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](https://github.com/JuanNavarroJ/Arep_Lab3_Networking/blob/master/LICENSE.txt) file for details.
