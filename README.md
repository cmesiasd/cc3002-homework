# CC3002 - Pokemon TCG: Elementos básicos

Tarea sobre la implementación del juego Pokemon TCG utilizando 
las metodologías aprendidas en el curso CC3002 - Metodologías de Diseño y Programación.

## Antes de empezar

Esta tarea fue realizada en su totalidad en el software IntelliJ IDEA, utilizando Java 1.8 SDK. 
Se incluye toda la la parte lógica solicitada. En la siguiente imagen se puede apreciar el 
diagrama UML que representa al desarrollo realizado.

![Alt text](Tarea1.png "UML")


## Descripción 

Para la realización de esta tarea, se utilizan principalmente patrones de diseño tales como Visitor, Double Dispatch y Observer. 
Esto permite generar un gran manejo de la Herencia y POO que nos facilita Java.

## Diseño

### Trainer 
Clase que hace ...

### ICard
Interfaz que describe el comportamiento de todas las cartas que participan en el juego, tales como:
 
 * Pokemon
 * Energias
 * Cartas de Entrenador
 
#### IPokemon

#### IEnergy

#### ITrainerCard

### IAbility

Interfaz que describe el comportamiento de la habilidades que poseen las cartas de tipo **Pokemon**. 

#### Attack
Un tipo en particular de habilidad son los ataques, estos poseen un daño a diferencia de las habilidades en general.

### IVisitor
Intefaz para utilizar el patrón de diseño Visitor 

#### PlayCardVisitor
Clase que ....
## Test

El testing fue realizado con el framework **JUnit 4**. Se realiza un testing unitario para cada método, 
buscando minimizar posibles bugs que pueda poseer el proyecto.
Para ejecutar los test basta con verificar que el directorio `test`
se encuentre marcado como _Test Root_.


## Autor

* **Cristóbal Mesías** - [Github](https://github.com/cmesiasd)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

