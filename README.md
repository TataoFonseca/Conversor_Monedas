# Conversor_Monedas
[Oracle ONE - Grupo 6] Challenge 1: Conversor de Monedas
Este es un proyecto Java que utiliza la API de conversión de monedas para obtener tasas de cambio y realizar conversiones entre diferentes monedas.

## Requisitos

- Java JDK 11 o superior
- Biblioteca Gson 2.10.1 o superior
- IDE Java (Eclipse, IntelliJ IDEA, etc.)
- Postman (opcional, para probar las solicitudes HTTP)

## Configuración del Proyecto

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/TataoFonseca/conversor-monedas-java.git

1. **Importar el proyecto en tu IDE**
- Abre tu IDE (por ejemplo, Eclipse).
- Selecciona "Open" o "Import" y elige el directorio del proyecto clonado.

3. **Configuración de las Dependencias**
- Asegúrate de tener configurada la dependencia de Gson en tu archivo pom.xml si estás usando Maven:
"<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>"

4. **Arquitectura del Proyecto**
El proyecto sigue la arquitectura MVC (Modelo-Vista-Controlador).

**Paquetes**
- com.alura.model: Contiene la lógica del modelo, incluyendo la clase CurrencyConverter.
- com.alura.controller: Contiene la lógica del controlador, incluyendo la clase Controller.
- com.alura.view: Contiene la lógica de la vista, incluyendo la clase CurrencyConverterView.
