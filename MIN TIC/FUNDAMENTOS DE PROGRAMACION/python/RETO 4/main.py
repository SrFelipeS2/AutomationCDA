import reto4 
#Captura de datos para almacenar en listas
lista_filas = []
lista_columnas = []
lista_anchos = []
lista_altos = []

#conocer la cantidad de muros
cantidad = int( input("Digite la cantidad de muros que desea, recuerde que hay un limite de muros es maximo 4: ") )
if (cantidad<=4):
    for i in range(0, cantidad):
        fila = int( input(f"Digite la fila para el muro {i+1} recuerde que el numero maximo es 31: ") )
        if (fila<=31):
            lista_filas.append(fila)
            validation=True
        else:
            validation=False

        columna = int( input(f"Digite la columna para el muro {i+1} recuerde que el numero maximo es 31: ") )
        if (columna<=31 and validation):
            lista_columnas.append(columna)
            validation1=True
        else:
            validation1=False
        if(validation1):
            if (fila==31):
                ancho=1
                lista_anchos.append(ancho)
                alto = int( input(f"Digite el alto para el muro {i+1} recuerde que el numero maximo es 31: ") )
                lista_altos.append(alto)
                validation3=True
            else:
                validarion3=False
            if (columna==31 and validation3==False):
                alto=1
                lista_altos.append(alto)
                ancho = int( input(f"Digite el ancho para el muro {i+1} recuerde que el numero maximo es 31: ") )
                lista_anchos.append(ancho)
            else:
                alto = int( input(f"Digite el alto para el muro {i+1} recuerde que el numero maximo es 31: ") )
                ancho = int( input(f"Digite el ancho para el muro {i+1} recuerde que el numero maximo es 31: ") )
                lista_altos.append(alto)
                lista_anchos.append(ancho)
        elif(validation==False or validation1==False):
            print("revise los valores ingresados eh intentelo nuevamente")



    datos= reto4.recorrer_listas(lista_filas,lista_columnas,lista_anchos,lista_altos) 
    print(datos)
else:
    print("recuerde que la cantidad maxima de muros es 4, intentelo nuevamente")