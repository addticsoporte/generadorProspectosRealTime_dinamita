### INSTRUCCIONES GENERALES

### Configuración del tiempo.

Este programa utiliza sentencias Cron para poder programar cada cuánto se tiene que ir actualizando esta lista de prospectos. Por lo tanto se sugiere primero acceder al archivo "application.properties" y en los comentarios se señalan donde se encuentran los alias para poder modificar los tiempos de repetición. 

Por ejemplo se muestra la sentencia Cron necesaria para que se ejecute la sentencia cada 8 horas o cada 10 segundos.  Como lo muestra la imagen.

https://drive.google.com/file/d/1Etrktn52-fWaVM4A6wF7yehyP08Mtw2q/view?usp=sharing

Y se llama a este método dentro del archivo "src\main\java\com\dinamita\retargetting2\cron\Scheduler.java" como lo muestra la siguiente imagen.

https://drive.google.com/file/d/1VvyRacAmlL94jHErsZVmmq9A00WA3ch3/view?usp=sharing 

Este programa se tiene que ejecutar en el IDE de tu preferencia, este fue desarrollado en Visual Studio Code y se ejecuta colocando en la terminal el comando siguiente:

` .\mvnw spring-boot:run`

Y en la misma carpeta se van guardando los archivos .CSV que se van creando dependiendo el tiempo configurado. 

###Observaciones con respecto a la base de datos. 

Este programa necesita de conectarse con una base de datos creada en MySQL Workbench de modo local. 

### Acceso al archivo de la base de datos

El folder de la pequeña base de datos se encuentra aquí y se llama "retargettingmysql"

Sin embargo, la idea de este programa es demostrar que cada cierto tiempo esta preparado este programa para ejecutar la tarea de crear un archivo CSV.


### OJO

Se requiere de Java 8 y JDK 1.8 para funcionar de modo correcto. 