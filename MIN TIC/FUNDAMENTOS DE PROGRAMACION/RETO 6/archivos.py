import os

# w     write
# r     read
# a     add
# x     verify exist, write

def buscar_vehiculo(_filtro, _valor, _lista):
    resultado = []

    try:
        for vehiculo in _lista:
            if vehiculo[_filtro].lower() == _valor:
                resultado.append(vehiculo)
    except:
        return resultado

    return resultado

def ordenar_vehiculos(_orden, _lista):
    # Extraer el dato del diccionario para ordenar
    lista_placas = []
    for vehiculo in _lista:
        lista_placas.append(vehiculo[_orden])

    lista_placas.sort()    

    # Recorrer la lista ordenada
    lista_vehiculos_ordenado = []
    for placa in lista_placas:
        for vehiculo in _lista:
            if placa == vehiculo[_orden]:
                lista_vehiculos_ordenado.append(vehiculo)

    return lista_vehiculos_ordenado

"""
archivo = "archivos/vehiculos.txt"

if os.path.exists(archivo) :
    print("Existe el archivo")
else:
    print("No existe....")

exit()
for root, dirs, files in os.walk("archivos"):
    for file in files:
        if "hola.txt" == file:
            print("Si existe")

os.remove("archivos/vehiculos.txt")

exit()

x=5
#print( eval("x-5") )

try:
    print( eval("x-5") )
    vehiculo = "{'placa': 'AAA111', 'marca': 1, 'color': 'rojo'}"
    print( type(vehiculo) )
    vehiculo = eval(vehiculo)
    print( type(vehiculo) )
    print( vehiculo )
except:
    print("La evaluación no se logro realizar")

exit()
"""

nuevo_archivo = open(file="archivos/vehiculos.txt", mode="r", encoding="utf_8")

lista_vehiculos = []
for linea in nuevo_archivo:
    #diccionario = linea.replace("\n","")
    diccionario = linea.rstrip("\n")
    #print( type(diccionario) )
    diccionario = eval(diccionario)
    #print(type(diccionario))
    lista_vehiculos.append( diccionario )

color = input("Digite el color a buscar: ").lower()

lista_resultado = buscar_vehiculo("color", color, lista_vehiculos)

print(lista_resultado)

def ordenar_vehiculos_placa(_filtro, _lista):
    lista_tmp = []
    for vehiculo in _lista:
        lista_tmp.append(vehiculo[_filtro])

    #print(lista_tmp)
    lista_tmp.sort()
    #print(lista_tmp)

    lista_vehiculos_ordenada = []
    for placa in lista_tmp:
        for vehiculo in _lista:
            if placa == vehiculo[_filtro] :
                lista_vehiculos_ordenada.append(vehiculo)

    return lista_vehiculos_ordenada

lista_ordenada = ordenar_vehiculos_placa("placa", lista_resultado)
print(lista_ordenada)

_filtro = "placa"
lista_resultado.sort( key = lambda o : o[_filtro] )

print(lista_resultado)


#lista_ordenada = ordenar_vehiculos("placa", lista_resultado)
#print(lista_ordenada)

exit()

lista_placas = []
for vehiculo in lista_resultado:
    lista_placas.append(vehiculo["placa"])

print(lista_placas)
lista_placas.sort()
print(lista_placas)

# Recorrer la lista ordenada
lista_vehiculos_ordenado = []
for placa in lista_placas:
    for vehiculo in lista_resultado:
        if placa == vehiculo["placa"]:
            lista_vehiculos_ordenado.append(vehiculo)

print( lista_vehiculos_ordenado )

exit()
lista_vehiculos = []
for linea in nuevo_archivo:
    #print( type(linea.replace("\n", "")) )
    diccionario = eval( linea.replace("\n", "") )
    #print( type(diccionario) )
    lista_vehiculos.append( diccionario )

print(lista_vehiculos)
nuevo_archivo.close()

exit()


html = """
<html>
    <head>
    </head>
    <body>
        <h1>Esto es un documento html</h1>
    </body>
</html>
"""

nuevo_archivo = open( mode = "w", file = "archivos/main.html",  encoding = "utf_8")
nuevo_archivo.write(html)
nuevo_archivo.close()

nuevo_archivo = open("archivos/hola.txt", "w", encoding="utf_8")

nuevo_archivo.write("Hola soy Juank Zambrano \n")
nuevo_archivo.write("Soy el formador de fundmentos de programación \n")
nuevo_archivo.write("Mi celular es xxxxxxxx \n")

nuevo_archivo.close()

exit()

vehiculo = { "placa":"AAA111", "color":"rojo", "propietario":"José García" }

nuevo_archivo = open( file="archivos/vehiculos.csv", mode="a", encoding="utf_8")
nuevo_archivo.write( vehiculo["placa"] + "\t" + vehiculo["color"] + "\t" + vehiculo["propietario"])

nuevo_archivo.close()

exit()

vehiculo = { "placa":"AAA111", "color":"rojo", "propietario":"José García" }

nuevo_archivo = open( file="archivos/vehiculos.txt", mode="a", encoding="utf_8")
nuevo_archivo.write( str(vehiculo) + "\n")

nuevo_archivo.close()

exit()
import os

# Write (w), Read (r) and Add (a), Modify (x)
archivo = open("C:/Users/zambr/Documents/ProyectosPython/archivos/presentacion_1.txt", "w")
archivo.write("Hola soy Juank Zambrano \n")
archivo.write("Formador de fundamentos de programación \n")
archivo.write("Mi correo es: juank_zambrano@mintic.gov.co \n")
archivo.write("Ruta absoluta")
archivo.close()

"""
with open("archivos/presentacion.txt", "w") as archivo:
    archivo.write("Hola soy Juank Zambrano \n")
    archivo.write("Formador de fundamentos de programación \n")
    archivo.write("Mi correo es: juank_zambrano@mintic.gov.co \n")
    archivo.write("Ruta relativo")
"""

archivo_lectura = open("archivos/presentacion.txt", "r")

for linea in archivo_lectura:
    print(linea)

exit()

#Lista de listas, matriz
matriz = [ [3, 8, 1], [-1, 4, 7], [3, 2, 0], [9, 12, 65] ]

archivo = open("archivos/matrices.txt","a")
for fila in matriz:
    fila.reverse()
    archivo.write( str(fila) + "\n")
archivo.close()

#Leer archivo
#Eval convierte al tipo de datos que se evalua
archivoL = open("archivos/matrices.txt","r")
matrizL = []
for linea in archivoL:
    print(linea[0:-1])
    matrizL.append(eval(linea[0:-1]))
archivoL.close()
print(matrizL)

archivo = "archivos/matrices.txt"

if os.path.exists(archivo):
  os.remove(archivo)
  print("El eliminado")
else:
  print("El archivo no existe")
