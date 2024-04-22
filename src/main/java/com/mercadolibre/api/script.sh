#!/bin/bash

# Leer la lista de palabras desde un archivo
lista_archivo="lista.txt"

# Verificar si el archivo existe
if [ ! -f "$lista_archivo" ]; then
    echo "El archivo de lista '$lista_archivo' no existe."
    exit 1
fi

# Leer cada palabra del archivo y crear la carpeta y los archivos
while IFS= read -r palabra; do
    # Convertir snake_case a snakecase
    carpeta=$(echo "$palabra" | sed 's/_//g')
    
    # Convertir snake_case a PascalCase
    archivo_pascal=$(echo "$palabra" | sed -r 's/(^|_)([a-z])/\U\2/g')
    
    # Crear la carpeta con el nombre de la palabra en formato snakecase
    mkdir -p "$carpeta"
    
    # Crear los 4 archivos con el nombre de la palabra en formato PascalCase y una palabra fija
    touch "$carpeta/${archivo_pascal}.java"
    touch "$carpeta/${archivo_pascal}Controller.java"
    touch "$carpeta/${archivo_pascal}Repository.java"
    touch "$carpeta/${archivo_pascal}Service.java"
    
    echo "Carpeta '$carpeta' creada con éxito y 4 archivos generados."
done < "$lista_archivo"
