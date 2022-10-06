
from fileinput import close
import utilidades 
import ast

"""  5. cargar archivos pacientes
        6. cargar archivos citas   """      
listaPersonas = []
listaCitas = []

opcion = 0

while opcion != 7 :

    print("""
        1. Cargar backup pacientes.
        2. Cargar backup citas.
        3. Ingresar Registro de Personas.
        4. Visualizar listado de Personas registradas.
        5. Asignacion de citas.
        6. Busqueda especializada.
        7. Salir.
    """)

    opcion = int( input("Seleccione una opción: ") )

    if opcion == 1:
        backup_pacientes = open("./archivos/lista_pacientes.txt", "r", encoding="utf_8")
        lista_temporal = backup_pacientes.readlines()
        listaPersonas = []
        for linea in lista_temporal:
            print(type(linea))
            diccionario = ast.literal_eval(linea)
            listaPersonas.append(diccionario)
            print(type(listaPersonas))
        backup_pacientes.close()
    elif opcion == 2:
        backup_citas = open("./archivos/tuplas_citas.txt", "r", encoding="utf_8")
        listaCitas = []
        for linea in backup_citas:
            diccionario = eval(linea)
            listaCitas.append(diccionario)
        backup_citas.close()

    elif opcion == 3:
        #Capturar los datos del las personas
        personas = {}
       
        validation = False

        while (validation==False):
            
            tipoDocumento = (input("Cual es su tipo de documento? recuerde que solo existen 4 tipos de documentos los cuales son: 'CC' 'CE' 'TI' 'PA': \n")).upper()
        
            numDocumento = (input("Digite su numero de cedula sin espacios ni signos de puntuacion: \n"))

            nombre = (input("Digite su nombre recuerde que debe contener menos de 30 caracteres: \n"))
            
            apellido = (input("Digite su apellido recuerde que debe contener menos de 30 caracteres: \n"))

            validation, message = utilidades.validar_datos_iniciales(tipoDocumento, numDocumento, nombre, apellido)
            print(message)
            
        validation2=False    
        while (validation2 == False):

            fecha_nacimiento= input("digite su fecha de nacimiento en el fomarto AAAA-MM-DD: \n")

            validation2, edad, message = utilidades.validar_fecha_edad(fecha_nacimiento)
            print(edad)
            print(message)

        validation3=False
        while (validation3== False):

            rh = input("digite el RH al que pertenece seguido del grupo sanguineo, recuerde que para nuesta EPS se establecen los siguientes 'A+', 'B+', 'O+', 'A-', 'B-', 'O-': \n").upper()

            validation3, message= utilidades.validar_sangre(rh)
            print(message)

        validation4=False

        while (validation4==False):

            correo = input("digite su correo electronico con un maximo de 50 caracteres: \n").lower()

            validation4, message = utilidades.validar_correo(correo)
            print(message)
            
        validation5 = False   
        while (validation5==False):

            telefono = input("digite su telefono con un maximo de 10 caracteres: \n")

            validation5, message = utilidades.validar_telefono(telefono)
            print(message)

            

        print("REGISTRO EXITOSO 😎")
        personas["Documento"] = numDocumento
        personas["TipoDocumento"] = tipoDocumento
        personas["Nombre"] = nombre
        personas["Apellido"] = apellido
        personas["FechaNacimiento"]=fecha_nacimiento
        personas["Edad"] = edad
        personas["grupoSanguineo"] = rh
        personas["CorreoElectronico"] = correo
        personas["Telefono"] = telefono

        listaPersonas.append(personas)

        pacientes = open("./archivos/lista_pacientes.txt", "a")
        pacientes.write(str(personas) +"\n" )
        pacientes.close()
        archivo_lectura = open("./archivos/lista_pacientes.txt", "r")
        for linea in archivo_lectura:
            print(linea)
        archivo_lectura.close()

    elif opcion == 4:
        print(utilidades.visualizar_listado(listaPersonas, listaCitas))
    
    elif opcion ==5:

        validation6=False
        while (validation6==False):
            
            validation6, message, fecha = utilidades.asignar_cita(listaPersonas,listaCitas)
            print(message, fecha)
        
    elif opcion == 6:
        while opcion != 7 :

            print("""
                1.Buscar por nombre
                2.Buscar por apellido
                3.Buscar por RH
                4.Buscar por documento
                5.Buscar por correo electrónico
                6.Buscar por teléfono
                7.Salir
            """)

            opcion1 = int( input("Seleccione una opción: ") )

            if opcion1 == 1:
                nombre = input("digite el nombre que desea buscar").lower()
                print(utilidades.busqueda_especializada(listaPersonas,nombre))
            
        
    


   
        






        
