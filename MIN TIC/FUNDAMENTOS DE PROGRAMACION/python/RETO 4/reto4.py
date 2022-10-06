def muro(fila, columna, ancho, alto):
    coordenadas = []
    for i in range(0, alto):
        #print("fila: ", i)
        for j in range(0, ancho):
            #print("columnas: ", j)
            coordenadas.append(str(fila+i) + ":" + str(columna+j))

    return coordenadas

#Recorrer una lista de acuerdo a sus indices
def recorrer_listas(lista_fila, lista_columna, lista_ancho, lista_alto):

    posicion = 0
    coordenadas = []
    while posicion < lista_fila.__len__() :
        print(posicion)
        fila    = lista_fila[posicion]
        columna = lista_columna[posicion]
        ancho   = lista_ancho[posicion]
        alto    = lista_alto[posicion]

        print(f"posicion {posicion}, fila: {fila}, columna: {columna}, ancho: {ancho}, alto: {alto} ")

        posicion = posicion + 1
        
        #Se pasas estos valores a las validaciones

        #Pasar los valores a el muro para obtener las coordenas
        lista_temp = muro(fila, columna, ancho, alto)
        coordenadas.extend(lista_temp)

    return coordenadas


   