 
def validar_datos_iniciales( valor ):
    if str.isdigit(valor)==False:
        return(False)
    elif len(valor)<4:
        return(False)
    else:
        return(True)


def asignacion_valores(sede, listaVS1,listaVS2,listaVS3):
    replaceList=0
    if sede == 1:
        mes = 1
        while mes != 13:
            valor = (input("ingrese las ventas del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaVS1[replaceList]=valor
                replaceList = replaceList+1
                print(listaVS1)
                print("valor registrado para el mes:", mes, "\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error las ventas no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")
    elif sede == 2:
        mes = 1
        while mes != 13:
            valor = (input("ingrese las ventas del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaVS2[replaceList]=valor
                replaceList = replaceList+1
                print(listaVS2)
                print("valor registrado para el mes:", mes, "\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error las ventas no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")
    elif sede == 3:
        mes = 1
        while mes != 13:
            valor = (input("ingrese las ventas del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaVS3[replaceList]=valor
                replaceList = replaceList+1
                print(listaVS3)
                print("valor registrado para el mes:", mes, "\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error las ventas no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")



def asignacion_valores_gastos(sede, listaGS1,listaGS2,listaGS3):
    replaceList=0
    if sede == 1:
        mes = 1
        while mes != 13:
            valor = (input("ingrese los gastos del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaGS1[replaceList]=valor
                replaceList = replaceList+1
                print(listaGS1)
                print("valor registrado para el mes:", mes ,"\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error los gastos no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")
    elif sede == 2:
        mes = 1
        while mes != 13:
            valor = (input("ingrese los gastos del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaGS2[replaceList]=valor
                replaceList = replaceList+1
                print(listaGS2)
                print("valor registrado para el mes:", mes, "\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error los gastos no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")
    elif sede == 3:
        mes = 1
        while mes != 13:
            valor = (input("ingrese los gastos del mes de enero al mes de diciembre, recuerde que son solo numeros y debe se mayo a 1000 pesos: \n"))
            validation = validar_datos_iniciales(valor)
            if validation == True:
                listaGS3[replaceList]=valor
                replaceList = replaceList+1
                print(listaGS3)
                print("valor registrado para el mes:", mes, "\n")
                mes = mes + 1
                if mes == 13:
                    print("valores Registrados exitosamente en la sede numero: ", sede)
                    sede = 4
                    return(sede)
            else:
                print( "Error los gastos no pueden ser menores a mil pesos, recuerde que el producto electronico mas barto es de 10.000 pesos o utilizo valores no numericos")
