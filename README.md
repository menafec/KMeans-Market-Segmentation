# Proyecto K-Means: Segmentación de Mercado
**Autor:** Ximena Carolina Fernandez Cardenas  
**Materia:** Machine Learning  
**Fecha:** Octubre 2024  

## Descripción
Este proyecto implementa el algoritmo de K-Means para clasificar datos relacionados con la satisfacción y lealtad de los clientes. Utiliza un conjunto de datos que incluye niveles de satisfacción y lealtad para identificar grupos (clusters) de clientes con características similares.

## Contexto del Conjunto de Datos
**Contexto:**  
Este archivo CSV contiene niveles de satisfacción y lealtad de los clientes.

**Contenido:**  
Basado en los niveles de satisfacción y lealtad de los clientes, se debe encontrar en qué segmento caerán. Estos datos pueden ser utilizados para K-Means Clustering, donde el segmento se puede encontrar utilizando el método del codo.

**Fuente del Dataset:**  
[Dataset de Segmentación de Mercado en Kaggle](https://www.kaggle.com/datasets/smritisingh1997/market-segmentationcsv)

## Objetivos
- Implementar el algoritmo K-Means para la clasificación de datos.
- Leer un conjunto de datos de un archivo CSV.
- Agrupar puntos en clusters y calcular los centroides de cada cluster.
- Proporcionar una salida que indique el número de puntos en cada cluster y sus centroides.

## Requisitos
- **Java 8 o superior:** Asegúrate de tener instalado Java en tu máquina.
- **Editor de texto o IDE:** Puedes usar cualquier editor de texto o un IDE como IntelliJ IDEA o Eclipse.

## Estructura del Proyecto
El proyecto está organizado en los siguientes archivos:

- `Main.java`: Clase principal que contiene el punto de entrada del programa y maneja la lectura de datos desde un archivo CSV.
- `KMeans.java`: Implementación del algoritmo K-Means.
- `Point.java`: Clase que representa un punto en el espacio multidimensional, con atributos de satisfacción y lealtad.
- `Cluster.java`: Clase que representa un cluster y su centroide.
Resultados

## El programa leerá los datos del archivo y mostrará:

	•	El número total de puntos cargados.
	•	El número de clusters creados.
	•	Detalles de cada cluster, incluyendo la cantidad de puntos y sus centroides.
