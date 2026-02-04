# PSPR_Unidad01_CedenoAnrdres

# Tarea 1: Comunicación entre Procesos (Padre e Hijo)

## USO DE LA IA
Para esta tarea me he basado en la IA para agilizar preguntas de errores o código que desconocía. He preguntado más que todo sobre **throws IOException** y cuáles eran las opciones que yo tenía para solucionarlos; después, por mi cuenta, fui probando cuál era la mejor opción para mi código y decidí quedarme con la que mejor se adaptaba a mi estructura de flujos. 

A su vez, no entendía muy bien dónde poner el **flush()** y la IA me ha explicado cuál era la mejor parte para poner ese código y que el programa no se quedara congelado por falta de sincronización entre el Padre y el Hijo. Como último me ha servido como guía para confirmar algunas dudas que veía en la presentaciones de clase en concreto el tema de **InputStreamReader** o **Destroy()**. Más que todo intenté que la IA me ayudará a entender este tema, ya que, más que complejo es mucha información y entre código, te puedes perder. 

# LINK: https://gemini.google.com/share/c9c43ff8a3a4


---

## PENSAMIENTO CRÍTICO

### ¿Por qué usamos flush()?
Básicamente, los **streams** usan un buffer, como una memoria temporal. Si no haces **flush()**, el mensaje se queda ahí guardado y nunca le llega al otro proceso. Sin esto, el programa entra en un bloqueo y no avanza. 



### ¿Qué he aprendido con esta actividad?
Más que todo sobre cómo hay que montar bien los **streams de entrada y salida** para que se entiendan. A pesar que es un poco confuso entendí bien cómo transformar los bytes en texto que yo pueda leer usando el anidamiento de **BufferedReader** e **InputStreamReader**.

### ¿Qué aplicaciones le ves a este tipo de programas?
Siento que es como abrir un mundo nuevo y complejizar Java a otro nivel, en el buen sentido. Lo que me ha llamado más la atención es el concepto de **streams**. En lugar de una web que lo haga todo, tienes un proceso para cobrar, otro para mandar emails y otro para generar PDFs. Se hablan entre ellos por **streams** y, si uno se satura, el resto sigue funcionando. Y me imagino que así funcionarán muchos servicios como plataformas.

### ¿Qué problemas ves en el código (rendimiento, seguridad, ética)?
Para mí el mayor fallo es que el código es un poco frágil porque todavía no está preparado para usar un **try-catch** de verdad. Al usar el **throws IOException** en el main lo que hacemos es dejárselo a Java. Si el archivo **Hijo.jar** no aparece o la conexión de los **streams** falla el programa explota y se cierra de golpe.

Esto es un peligro porque si el programa se para antes de llegar al final nunca se ejecuta el **process.destroy()**. Eso significa que el hijo se queda "volando" en el sistema como un **proceso zombie** gastando memoria RAM sin que nadie lo controle. Además ejecutar un jar externo siempre tiene su riesgo porque si alguien lo cambia por otro archivo malo el padre lo va a lanzar igual.
