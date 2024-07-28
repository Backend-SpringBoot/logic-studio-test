# LOGIC STUDIO TEST!

Es una simple aplicación diseñada con pring framework que contiene endpoints que ayudan a la resolución de un problema de rutas usando grafos, deep first search y algoritmo de dijkstra.


# ENDPOINTS

- Inserción de data: Existe un endpoint llamado **/addGrafos** que perite la inserción de lo registros para poder crear la matriz de adyaciencia.
- Rutas:  El endpoint llamado **/routes** permite realizar el cálculo y todo el proceso necesario para que la aplicación realice la funcionalidad requerida.
- Limpiar:  El endpoint llamado **/clear** permite limpiar los registros ingresado dentro de la matriz de adyacencia y poder ingresar nuevos datos para poder realizar nuevo cálculos usando el endpoint **/routes** 

## EJECUCIÓN DEL PROYECTO

Para poder realizar la ejecución del proyecto se necesita tener instalado lo siguiente: 

- IDE:  Se requiere tener instalado un IDE. (En mi caso uso Intelli J)
- Se requiere tener instalado MAVEN
- Se requiere Java 21

Proceso
- En el modulo **logic-studio-container-service** ->**src**->**main**->**java**->**contenedor**->**LogicStudioServiceAppliction.java**
- Ejecutar el archivo **LogicStudioServiceAppliction.java**

## ARCHIVOS ADJUNTOS

para poder visualizar el proceso de análisis para el siguiente problema se adjunta un link con el documento excel de análisis y proceso que se realizó para poder solventar este problema:

[Proceso de análisis](https://docs.google.com/spreadsheets/d/1PihAjKMMGNNd07C4VjD2Sm7H2rYHuvWw/edit?usp=sharing&ouid=104395353227264353186&rtpof=true&sd=true)

También se adjunta la colección de postman que se usó para poder realizar las pruebas.

[Postman collection](https://drive.google.com/file/d/1owYCklzNNDhtvHRCUJTRf1eEYzWjdJhE/view?usp=sharing)


## RESULTADOS
> **Note:** Los resultados se muestran en la consola de la aplicación.

```text
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

Expected Output:

Output #1: 9

Output #2: 5

Output #3: 13

Output #4: 22

Output #5: NO SUCH ROUTE

Output #6: 2

Output #7: 3

Output #8: 9

Output #9:0

Output #10: 7
```

