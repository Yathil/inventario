# Mi Proyecto Inventario

Este proyecto es una aplicación de inventario que permite gestionar dispositivos. Los dispositivos pueden ser de varios tipos como Ordenador, Pantalla, Impresora, Proyector, Portátil, Router, etc.

## Clases

El proyecto consta de dos clases principales:

- `Dispositivo`: Esta clase representa un dispositivo con atributos como Identificador, FechaCompra, Precio, Tipo Atributo, Marca, Modelo. También tiene métodos para dar de alta, baja y modificar un dispositivo.

- `Inventario`: Esta clase representa un inventario que contiene una lista de dispositivos. Tiene métodos para mostrar los dispositivos, ordenarlos por fecha y imprimir los detalles de los dispositivos.

## Cómo ejecutar

Para ejecutar este proyecto, sigue estos pasos:

1. Clona el repositorio a tu máquina local.
2. Navega hasta el directorio del proyecto.
3. Ejecuta el comando `mvn clean install` para construir el proyecto.
4. Ejecuta el comando `java -cp target/mi-proyecto-inventario-1.0-SNAPSHOT.jar com.miempresa.Main` para iniciar la aplicación.

## Pruebas

Este proyecto incluye pruebas unitarias para las clases `Dispositivo` e `Inventario`. Para ejecutar las pruebas, usa el comando `mvn test`.

## Documentación

La documentación del código se genera con JavaDoc. Para generar la documentación, ejecuta el comando `mvn javadoc:javadoc`.

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir lo que te gustaría cambiar o envía un pull request.

## Licencia

Este proyecto está bajo la licencia MIT.
