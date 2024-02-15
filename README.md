# Mi Proyecto Inventario

Este proyecto es una aplicación de inventario que permite gestionar dispositivos. Los dispositivos pueden ser de varios tipos como Ordenador, Pantalla, Impresora, Proyector, Portátil, Router, etc.

## Clases

El proyecto consta de tres clases principales:

# Modelos

- `Dispositivo`: Esta clase representa un dispositivo con atributos como Identificador, FechaCompra, Precio, Tipo Atributo, Marca, Modelo. También tiene métodos para dar de alta, baja y modificar un dispositivo.

- `TipoDispositivo`: Esta clase enum representa los tipos de dispositivos que se pueden gestionar en el inventario.

- `OnCkClickListener`: Esta clase es un controlador de eventos para la vista principal de la aplicación. Permite añadir un nuevo dispositivo, eliminar un dispositivo existente y modificar un dispositivo existente.

# Controladores

- `ModificarDispositivoController`: Esta clase es el controlador para la vista de modificación de dispositivos. Permite modificar los detalles de un dispositivo existente y actualizar la tabla de dispositivos en la interfaz de usuario.

- `InventarioController`: Esta clase representa el inventario de dispositivos. Tiene métodos para añadir, eliminar y modificar dispositivos. También tiene un método para buscar un dispositivo por su identificador.

-`DispositivoController`: Esta clase es el controlador para la vista de dispositivos. Permite añadir un nuevo dispositivo, eliminar un dispositivo existente y modificar un dispositivo existente.

# Main

- `Main`: Esta clase es la clase principal de la aplicación. Inicia la aplicación y muestra la vista principal.

# Vistas

- `inventario.fxml`: Esta vista muestra una tabla con los dispositivos en el inventario. También tiene botones para añadir, eliminar y modificar dispositivos.

- `modificarDispositivo.fxml`: Esta vista muestra un formulario para modificar los detalles de un dispositivo existente.

- `add_dispositivo.fxml`: Esta vista muestra un formulario para añadir un nuevo dispositivo al inventario.

## Requisitos

Para ejecutar este proyecto, necesitarás tener instalado:

- Java 8 o superior
- Maven 3.6.3 o superior

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
