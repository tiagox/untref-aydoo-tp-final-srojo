# Procesador estadístico del uso de Bicicletas

## TP Final


## Introducción

A partir de la información de los recorridos de las bicicletas de la ciudad de Buenos Aires [1], se desea construir una aplicación para obtener cierta información estadística.

## Especificación

La aplicación debe tomar archivos .zip provistos por la Ciudad de Buenos Aires [2] y procesarlos para generar información estadística.

La aplicación deberá funcionar en dos modos: daemon y on-demand.

### Modo daemon

La aplicación una vez iniciada deberá monitorear un directorio y ante cada nuevo archivo detectado deberá generar un archivo de salida. Cada archivo procesado, será movido a otro directorio. En este caso cada archivo de entrada generará un archivo de salida.

Entrada|Salida
-------|------
entrada1.zip|salida1.yml
entrada2.zip|salida2.yml
entrada3.zip|salida3.yml

### Modo on-demand

La aplicación será iniciada recibiendo como parámetro el nombre de un directorio y procesará todos los archivos del directorio especificado. En este caso se generará un solo archivo de salida como resultado de todos los archivos de entregada.

Entrada|Salida
-------|------
entrada1.zip<br>entrada2.zip<br>entrada3.zip|salida_unica.yml
entrada4.zip<br>entrada5.zip<br>entrada6.zip|salida_unica_2.yml

### Formato de salida

El resultado del procesamiento será un archivo en formato YAML [3] con la siguiente información:

* bicicleta utilizada más veces
* bicicleta utilizada menos veces
* recorrido más veces realizado (par origen-destino)
* tiempo promedio de uso

### Archivos de entrada para probar

* [Recorridos-2010.zip](https://drive.google.com/file/d/0BwxS5GYrNYTqYTRSODN5SVluQVU/edit?usp=sharing)
* [Recorridos-2012.zip](https://drive.google.com/file/d/0BwxS5GYrNYTqcXp3UWZQZHkxNEE/edit?usp=sharing)
* [Recorridos-2013.zip](https://drive.google.com/file/d/0BwxS5GYrNYTqRzJaZWp6T0dQZjA/edit?usp=sharing)

---

- [1] http://data.buenosaires.gob.ar/dataset/bicicletas-publicas
- [2] https://recursos-data.buenosaires.gob.ar/ckan2/bicicletas-publicas/bicicletas-publicas.zip
- [3] http://yaml.org
