# Servlet & Ehcache
Se utiliza un *Servlet* para realizar peticiones, las cuales retornaran la información de personas que se encuentra almacenada en un *cache* el cual simula una BD. 

## Servicios
### POST

    /servlet-cache-webapp/person

    {
     "id":"1", 
     "name":"Diego"
    }

###  GET

    /servlet-cache-webapp/person?id=1

## Avance del proyecto

    50%

## Tecnologías utilizadas

- **Servidor de aplicaciones**
    wildfly-16.0.0.Final

- **Cache**
    Ehcache

- **JEE**
    Java 8
    Servlert 3.1
