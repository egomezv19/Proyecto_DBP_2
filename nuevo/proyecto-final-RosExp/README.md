


- **Nombre del Proyecto:** RosExp

![Empresa](image/empresaRosExp.jpg)


- **Introducción:** 
Para el año 2026, la empresa aeroespacial peruana RosExp iniciará un proyecto llamado Mars2030, el cual tiene como objetivo llevar a los humanos al planeta Marte. Cada vez, la tecnología avanza a pasos muy acelerados. La probabilidad de extinguirnos nosotros mismos cuando ocurra una tercera guerra mundial con bombas nucleares es muy alta. La reciente guerra entre Rusia y Ucrania nos muestra cómo es que se podrían producir estos enfrentamientos. Por otro lado, está el crecimiento poblacional mundial que crece a una tasa acelerada en comparación a siglos anteriores. Las **Naciones Unidas** nos muestra que la población mundial es más de tres veces mayor que a mediados del siglo XX. Esto nos indica que en un futuro, la Tierra será un lugar muy codiciado y podríamos volver al primer problema de desatar una guerra por tierra y agua. 

## Modelo Entidad Relación
![Imagen Entidad Relación](image/modeoER.png)
### Paso 00: Definición del recurso

* Implementaremos una API para una empresa aereoespacial. Tendremos 4 recursos: Cohete, Mision, Planeta y Trabajador que puede ser Astronauta, Director de Vuelo y Ingeniero de Vuelo.

#### [Cohete]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado| 
|nombreCohete|String|Nombre Cohete| 
|empujeCohete|Double|Cantidad en toneladas del empuje del cohete|
|longitudCohete|Double|El tamaño por largo del cohete en metros|
|pesoDespegue|Double|El peso en toneladas con el cual el cohete despegua de la la superficie de la Tierra en|
|motor|String|El motros del cohete|
|diametro|Double|Es el diametro del cohete(ancho del cohete) en metros (m)|
|velocidadMaxima|Double|Rapidez máxima del cohete en kilometros por hora (km/h)| 
|cantidadEtapa|Integer|Nos da información de la cantidad de etapas que tiene el cohete|
|propulsor|Boolean|Nos informa si el cohete tiene o no propulsores.|
|aleta|Boolean|Nos da información si el cohete tiene o no aletas.|


#### [Misión]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|identificadorMision|Long|Identificador único autogenerado para una misión|
|disponible|Boolea|Indica si la misión está disponible o no|
|cantidadPresupuesto|Double|La cantidad de presupuesto que ha tenido la misión|
|nombreMision|String|El nombre de la misión|
|inicioMision|Date|Fecha de inicio de la misión|
|finMisión|Date|Fecha fin de la misión|
|tiempoDuracion|Integer|Cantidad de días que duró la misión. Es un atributo derivado que se calcula de inicioMision y FinMision|


#### [Planeta]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado|
|nombrePlaneta|String|Nombre del planeta|
|gravedadPlaneta|Double|Muestra la gravedad asociada al planeta|
|cantidadDia|Integer|Muestra la cantidad de días que dura un año en el planeta|
|distancia|Double|Muestra la cantidad de distancia desde la Tierrra al plantena en kilómetros (Km)|
|habitado|Boolean|Es verdadero o falso e indica si está o no habitado el planeta|

#### [Trabajador]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado|
|dni|String|Identificador único del trabajor|
|apellido_paterno|String|Apellido paterno|
|apellido_materno|String|Apellido materno|
|nombre_pila|String|Nombre de pila|
|imagen|String|URL o ruta de la imagen de la persona|
|genero|String|Genero del trabajador|
|fecha_nacimiento|Date|Fecha de nacimiento|
|edad|Integer|Edad actual, atributo derivado de fecha_nacimiento|

##### [Astronauta]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado|
|dni|String|Identificador único del trabajor|
|apellidoPaterno|String|Apellido paterno|
|apellidoMaterno|String|Apellido materno|
|nombrePila|String|Nombre de pila|
|imagen|String|URL o ruta de la imagen de la persona|
|genero|String|Genero del trabajador|
|fechaNacimiento|Date|Fecha de nacimiento|
|edad|Integer|Edad actual, atributo derivado de fecha_nacimiento|
|cargo|String|Nos da información sobre el cargo que desempeña el astronauta en una misión|

##### [DirectorVuelo]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado|
|dni|String|Identificador único del trabajor|
|apellido_paterno|String|Apellido paterno|
|apellido_materno|String|Apellido materno|
|nombre_pila|String|Nombre de pila|
|imagen|String|URL o ruta de la imagen de la persona|
|genero|String|Genero del trabajador|
|fecha_nacimiento|Date|Fecha de nacimiento|
|edad|Integer|Edad actual, atributo derivado de fecha_nacimiento|


##### [IngenieroVuelo]

|Atributo|Tipo de dato|Descripción|
|---------|----|-----------|
|id|Long|Identificador único autogenerado|
|dni|String|Identificador único del trabajor|
|apellido_paterno|String|Apellido paterno|
|apellido_materno|String|Apellido materno|
|nombre_pila|String|Nombre de pila|
|imagen|String|URL o ruta de la imagen de la persona|
|genero|String|Genero del trabajador|
|fecha_nacimiento|Date|Fecha de nacimiento|
|edad|Integer|Edad actual, atributo derivado de fecha_nacimiento|
|campoTrabajo|String|Indica el campo al cual se dedica el ingeniero de vuelo cuando se realiza el despegue del cohete|




- **Demostración en Vivo:** [Descripción de la demostración en vivo de las principales funcionalidades de la aplicación]
- **Explicación del Diseño:** [Explicación del diseño general de la solución y resalte de las partes más importantes del código implementado]
- **Conclusiones y Aprendizajes:** [Enumeración de las conclusiones más importantes y su relación con los conceptos del curso]
- **Preguntas:** [Respuestas a las posibles preguntas del jurado sobre el proyecto y su desarrollo]


## Mision 

---
{
    "nombreMision" : "RosExp 2032",
    "inicioMision" : "2032-10-28T00:00:00.000+00:00",
    "finMision" : "2035-10-28T00:00:00.000+00:00",
    "disponible" : true,
    "cantidadPresupuesto": 1500000000,
    "tiempoDuracion": 730

}

{
    "nombreMision" : "Mars 2030",
    "inicioMision" : "2033-03-27T00:00:00.000+00:00",
    "finMision" : "2038-03-27T00:00:00.000+00:00",
    "disponible" : true,
    "cantidadPresupuesto": 1500000000,
    "tiempoDuracion": 1825

}
---

## Astronautas
---
{
    "dni": "21005918",
    "apellidoPaterno" : "Alvarez",
    "apellidoMaterno" : "Caisahuana",
    "nombrePila": "Rosa",
    "imagen" : "https://facebook/user/21005918",
    "genero": "Femenino",
    "fechaNacimiento":"1971-08-28T00:00:00.000+00:00",
    "edad":52,
    "cargo" : "Mecanica de los cohetes"
}

{
    "dni": "74410344",
    "apellidoPaterno" : "Arteaga",
    "apellidoMaterno" : "Alvarez",
    "nombrePila": "Gian Marco",
    "imagen" : "https://facebook/user/74410344",
    "genero": "Masculino",
    "fechaNacimiento":"2002-03-27T00:00:00.000+00:00",
    "edad":21,
    "cargo" : "Comandante"
}

---

## IngenieroVuelo
---

{
    "dni": "74410342",
    "apellidoPaterno" : "Hinostroza",
    "apellidoMaterno" : "Alvarez",
    "nombrePila": "Angela",
    "imagen" : "https://facebook/user/74410342",
    "genero": "Femenino",
    "fechaNacimiento":"1998-08-13T00:00:00.000+00:00",
    "edad":25,
    "campoTrabajo" : "Biologia"
}

{
    "dni": "74410343",
    "apellidoPaterno" : "Hinostroza",
    "apellidoMaterno" : "Alvarez",
    "nombrePila": "Pamela",
    "imagen" : "https://facebook/user/74410343",
    "genero": "Femenino",
    "fechaNacimiento":"1998-08-13T00:00:00.000+00:00",
    "edad":25,
    "campoTrabajo" : "Igeniera Agronoma"
}

---
## DirectorVuelo
---
{
    "dni": "42343243",
    "apellidoPaterno" : "Cristobal",
    "apellidoMaterno" : "Alvarez",
    "nombrePila": "Jimi Maicol",
    "imagen" : "https://facebook/user/42343243",
    "genero": "Masculino",
    "fechaNacimiento":"2000-05-04T00:00:00.000+00:00",
    "edad":23
}

---

## Cohete

---
{
	"nombreCohete" : "Starship",
	"empujeCohete" : 7500,
	"longitudCohete" : 120,
	"pesoDespegue" : 4000,
	"motor" : "Raptor",
	"diametro" : 9,
	"velocidadMaxima" :1000,
	"cantidadEtapa" : 3,
	"propulsor" : true,
	"aleta" : false

}


{
	"nombreCohete" : "Dragon",
	"empujeCohete" : 8500,
	"longitudCohete" : 100,
	"pesoDespegue" : 1000,
	"motor" : "Raptor",
	"diametro" : 9,
	"velocidadMaxima" :44256,
	"cantidadEtapa" : 3,
	"propulsor" : true,
	"aleta" : true

}

{
	"nombreCohete" : "Falcon",
	"empujeCohete" : 9500,
	"longitudCohete" : 98,
	"pesoDespegue" : 2000,
	"motor" : "RosExp",
	"diametro" : 9,
	"velocidadMaxima" :55000,
	"cantidadEtapa" : 2,
	"propulsor" : true,
	"aleta" : true

}
---

