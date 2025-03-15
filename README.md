# Alarm Connect - Aplicación Móvil

## Integrantes

- **Santiago Alvarez**
- **Orlando Solarte**

## Funcionalidad y Pantallas
La aplicación  permite realizar el flujo completo de la funcionalidad Crear Alarma

### Santiago Alvarez 
- **Pantalla 1**: Lista de Alarmas y Layout Principal
- **Pantalla 2**: Nueva Alarma - Selección de Tipo
- **Pantalla 3**: Formulario Crear Alarma
- **Pantalla 4**: Grabar Nota de Voz

### Orlando Solarte
- **Pantalla 1**: Seleccionar Contacto de Confianza
- **Pantalla 2**: Configuración de Volumen y Grabación
- **Pantalla 3**: Configuración de Repetición
- **Pantalla 4**: Mi Circulo de Confianza

## Tecnologías

- **Lenguaje:** Kotlin
- **Interfaz de Usuario:** Material Design
- **IDE recomendado:** Android Studio
- **Plataforma:** Android

## Instalación para Desarrolladores

Para configurar el proyecto y ejecutarlo en Android Studio, sigue estos pasos:

### 1. Clonar el Repositorio

```sh
# Clona el repositorio desde GitHub
 git clone https://github.com/santi8194/MISW4302-AlarmConnect-Movil.git

# Accede al directorio del proyecto
cd MISW4302-AlarmConnect-Movil
```

### 2. Abrir el Proyecto en Android Studio

1. Abre **Android Studio**.
2. Selecciona **"Open an Existing Project"**.
3. Navega hasta la carpeta del repositorio clonado `alarm-connect-mobile` y selecciónala.
4. Espera a que Android Studio sincronice el proyecto y descargue las dependencias necesarias.

### 3. Instalar Dependencias

- Asegúrate de tener instalados los siguientes componentes en Android Studio:
  - **SDK de Android** (versión compatible con el proyecto)
  - **Gradle** actualizado
  - **Kotlin Plugin**

Si Android Studio detecta que faltan dependencias, ejecuta:
```sh
./gradlew build
```
Esto descargará todas las dependencias necesarias.

### 4. Ejecutar la Aplicación

Para probar la aplicación en un emulador o dispositivo físico:

1. Conecta un dispositivo Android con depuración USB activada **o** inicia un emulador en Android Studio.
2. En Android Studio, selecciona el dispositivo de destino.
3. Presiona el botón **Run** o ejecuta el siguiente comando en la terminal:

```sh
./gradlew installDebug
```

Esto compilará y desplegará la aplicación en el dispositivo seleccionado.






