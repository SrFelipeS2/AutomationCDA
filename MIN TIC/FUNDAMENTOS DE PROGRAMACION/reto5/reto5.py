import re

#   Correo      ^[(a-z0-9\_\-\.)]{3,10}@[(a-z0-9\_\-)]{3,}\.[(a-z)]{2,3}

def validar_color(parametro_color):
    if parametro_color.__len__() > 10:
        return (False, "El color excede los 10 caracteres")
    else:
        if bool( re.search("[0-9]", parametro_color) ) == True:
            return (False, "El color no puede llevar números")
        else:
            return (True, "")

def buscar_vehiculo(busqueda, lista):
    _existeVehiculo = False
    for vehiculo in lista:
        if vehiculo['placa'] == busqueda :
            _existeVehiculo = True
            break
    return _existeVehiculo

lista_vehiculos = []
lista_soat = []

opcion = 0
while opcion != 4 :

    print("""
        1. Ingresar Vehiculo
        2. Visualizar listado de vehiculos
        3. Validación de soat
        4. Salir        
    """)

    opcion = int( input("Seleccione una opción: ") )

    if opcion == 1:
        #Capturar los datos del vehiculo
        vehiculo = {}

        #V 2.0
        # Validar que el color no tenga mas de 10 caracteres, que no tenga numeros
        validacion_color = False
        while validacion_color == False:
            _color = input("Digite el color de carro: ")
            #Validar el dato del usuario
            retorno, mensaje = validacion_color(_color)
            if retorno == False:
                print(mensaje)
            else:
                validacion_color = True
        
        # Validar que el color no tenga mas de 10 caracteres, que no tenga numeros
        validacion_color = False
        _color = None
        while validacion_color == False:
            _color = input("Digite el color de carro: ")
            if _color.__len__() > 10:
                print("El color no puede superar los 10 caracteres")
            else:
                if bool( re.search("\d", _color) ) :
                    print("No deben existir números en el color")
                else:
                    validacion_color = True

        _marca = 0
        while _marca != 1 and _marca != 2:
            _marca = int( input("Digite la marca del carro, seleccione 1 = KIA, 2 = CHEVROLET: ") )

        _placa = input("Digite la placa del vehiculo: ")

        #Asignar valores a diccionario
        vehiculo["color"] = _color
        vehiculo["marca"] = _marca
        vehiculo["placa"] = _placa

        lista_vehiculos.append(vehiculo)

    elif opcion == 2:
        """
        print("Visualizar listado de vehiculos")
        #print(lista_vehiculos)
        print("---------------------------------------------")
        print("Placa \t\t Color \t\t Marca")
        print("---------------------------------------------")
        for vehiculo in lista_vehiculos:
            print(f"{vehiculo['placa']} \t\t {vehiculo['color']} \t\t {vehiculo['marca']}") 
        exit()
        """
        print(f"-------------------------------------------------------------------------------")
        print(f"Placa \t\t Color \t\t Marca \t\t Estado Soat")
        print(f"-------------------------------------------------------------------------------")
        for vehiculo in lista_vehiculos:
            _estado_soat = ""
            for soat in lista_soat:
                if soat[0] == vehiculo["placa"]:
                    _estado_soat = soat[1]
                    break

            print(f"{vehiculo['placa']} \t\t {vehiculo['color']} \t\t {vehiculo['marca']} \t\t {_estado_soat}")

        print(f"-------------------------------------------------------------------------------")
        
    elif opcion == 3:
        #Capturar la placa del vehiculo, estado soat
        _placa = input("Digite la placa del vehiculo: ")

        #Ya se realizó la validación de datos
        _existeVehiculo = buscar_vehiculo(_placa, lista_vehiculos)

        if _existeVehiculo :
            _estado_soat = input("Digite el estado del soat del vehiculo, A = Activo, I = Inactivo: ")
            soat_vehiculo = (_placa, _estado_soat)
            lista_soat.append(soat_vehiculo)
        else:
            print("El vehiculo no existe en la base de datos")

    elif opcion == 4:
        print("Saliendo de la aplicación....")
    else:
        print("Opción no valida")