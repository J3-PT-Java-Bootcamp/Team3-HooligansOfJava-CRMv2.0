## 💫 Hooligans of Java CRM

## 👊 Integrantes del equipo
<li>🏅 Joaquim Pineda

<li>🏅 Eli Rodríguez

<li>🏅 Jose Rodríguez

<li>🏅 Ana Montero

_____

## Introducción
Para este proyecto, se va a continuar con sistema de gestión de relaciones de clientes (CRM).



_____

## 🛠️ Stack utilizado

<li>IntelliJ IDEA 2022.1.2 (Ultimate Edition)</li>
<li>Java 17</li>
<li>Maven 3.8.6</li>
<li>JUnit 5</li>
<li>Java Spring Boot</li>
<li>Java JDBC</li>
<li>Java JPA</li>
<li>Lombok</li>

----
## 👁️‍🗨️ Diagramas

![Case diagram](src/main/java/com/ironhack/img/crm_case_diagram2.png?raw=true "Case diagram")


_____

##  💻 Presentación del proyecto
El proyecto se encuentra dividido en diferentes paquetes, con idea de presentar una clara estructura.

application: desde aquí se arranca el programa.

console: aquí se delega acciones comunes derivadas del uso de la consola, como pueden ser las validaciones de ciertos campos (no se aceptan dígitos en los nombres, validación de teléfono e emails, etc.), o la muestra de mensajes acordes a la validación de los campos.

dto: contiene todas esas clases que sirven para mostrar al usuario.

enums: carpeta autodescriptiva, se meten aquí aquellas clases de tipo Enum.

menu: clase de peso principal del proyecto, pues une todas las integraciones de diferentes métodos y lógicas. Recoge el input del usuario, implementa los métodos públicos que se encargan de las acciones necesarias, y muestra el output en consola.

model: contiene las clases del proyecto con las que se va a trabajar en la aplicación.

reporting: contiene las clases que se utilizan para crear las tablas de los informes.

repository: contiene las clases que interactúan con la base de datos.

service: en este paquete se concentran todas las clases e interfaces donde se aplica toda la lógica del programa.

test: contiene las clases que brindan la testeabilidad de la aplicación.


-----

##  🚀 ¿Cómo se ejecuta?

1. La clase Application arranca el Menú del proyecto
2. Elige la opción deseada del menú, el cual acepta tanto selección por dígitos o por escritura de comando
3. Se aconseja cargar los datos para poder tener una experiencia más completa, con la opción Populate Data en la "Run configurations"
4. Otro consejo es que antes de buscar una oportunidad por nombre, te asegures de que esa compañía se ha asociado ya a una oportunidad
5. Además de los comandos básicos (New lead, Show leads, Lookup lead id, Convert id, Edit opportunity), se presentan otros de utilidad como son:
   1. Search opportunity by company name (ahórrate un par de segundos y pulsa opción 5): permite buscar oportunidades por el nombre de la empresa a la que se vincula 


-----

![Thank you!](src/main/java/com/ironhack/img/thank_you.gif?raw=true "Gracias")