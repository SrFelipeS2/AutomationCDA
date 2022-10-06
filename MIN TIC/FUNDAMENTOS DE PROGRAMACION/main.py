def peso_ideal(estatura, genero):
    if genero == "M" or "m":
       return( 56.2+1.41*(estatura/2.64-60))
    else:
       return( 53.1+1.36*(estatura/2.64-60))

def calorias_quemadas(tiempo, clase, peso):
    return((tiempo*clase*peso)/200)
opcion = 0
while(opcion != 0):
    print("--------------")
    print("Calculadora Saludable")
    print("--------------")
    print("peso ideal")
    print("calorias quemadas")
    print("porcentaje de grasa corporal")
    print("--------------")
    print("--------------")

    opcion=int(input("seleccione una opcion"))
    
    if opcion == 1:
        estatura = int(input("digite su estaura en cm"))
        genero = input("digite su genero M Ó F") 
        resultado = peso_ideal(estatura, genero)
        print(f'el peso ideal para la estatura es: {resultado}')
    elif opcion ==2:
        clase = int(input("que tipo de deporte va a realizar?, seleccione 1 para caminar, 2 para Tenis, 3 para bicicleta, 4 para correr, 5 para nadar"))
        tiempo = int(input("por favor digite los minutos de su activdad"))
        peso = float(input("cual es su peso"))
        if clase == 1:
            valor_clase = 2
        elif clase == 2:
            valor_clase = 5
        elif clase == 3:
            valor_clase = 14
        elif clase == 4:
            valor_clase = 6
        elif clase == 5:
            valor_clase = 9.9
        else:
            valor_clase=1
        resultado = calorias_quemadas(tiempo, valor_clase, peso)
        print(f'las calorias quemadas son: {resultado}')
    elif opcion ==3:
        print("")
    elif opcion ==4:
        print("")
    elif opcion ==5:
        print("")
    else:
        print("opcion invalida")


