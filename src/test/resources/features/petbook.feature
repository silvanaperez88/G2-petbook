# language: es
Característica: petbook
  Como usuario web
  Quiero usar petbook
  Para visualizar la galeria de imagenes

  Escenario: Seleccionar imagen luego filtrar
    Cuando Silvana selecciona una imagen de "gato" para verla ampliada
    Y selecciona el filtro "Gato"
    Entonces en la galeria solo debe haber 2 imagenes relacionadas al filtro seleccionado

  Escenario: Filtrado de imagenes luego seleccion
    Cuando Silvana escoge el filtro "Perro", luego selecciona una imagen de "perro"
    Entonces solo se debe ver una imagen ampliada

  Escenario: Total de imagenes en galeria
    Cuando Silvana selecciona el filtro "Gato"
    Y selecciona el filtro "Perro"
    Entonces al seleccionar el filtro "All" deben estar todas las imagenes