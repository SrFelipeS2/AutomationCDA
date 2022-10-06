import utilidades as util
from datetime import datetime
from time import sleep
import os

lista_usuarios = []
lista_citas = []
RUTA_PACIENTES = 'archivos/pacientes.txt'
RUTA_CITAS = 'archivos/citas.txt'

menu = 0

while (menu != 6):
  print("""
----------------------------------------------------------------------
  Bienvenido al sistema de agendamiento de citas
----------------------------------------------------------------------
        1. Registrar persona
        2. Visualizar listado de las personas
        3. Asignar una cita
        4. Cargar archivos
        5. Búsqueda pacientes
        6. Salir de la aplicación
  """)
 
  menu = util.convertir_entero(input("Seleccione una opción: "))
 
  util.clear()

  if (menu == 1):
    #Capturar los datos validados con diccionario
    dicc_datos = {"tipo_documento":"", "numero_documento":"", "nombre":"", "apellido":"", "fecha_nacimiento":"", "rh_grupo":"", "email":"", "telefono":"", "cita":"Sin cita"}
 
    validar_tipo_documento = False
    while (validar_tipo_documento == False):
      tipo = input("Ingrese el tipo de documento, solo se acepta: CC, CE, TI, PA: ").upper()
      validar_tipo_documento = util.validar_tipo_documento(tipo)
 
    validar_documento = False
    while ( validar_documento == False):
      documento = input("Ingrese el número de documento: ")
      validar_documento = util.validar_numero_documento(documento)    
      usuario_existe = util.buscar_documento(tipo, documento, lista_usuarios )
      if usuario_existe == True:
          print("El documento que digito ya existe existe")
          validar_documento = False
   
    validar_nombre = False
    while ( validar_nombre == False):
      nombre = input("Ingrese su nombre: ")
      validar_nombre = util.validar_nombre(nombre)
   
    validar_apellido = False
    while ( validar_apellido == False):
      apellido = input("Ingrese su apellido: ")
      validar_apellido = util.validar_nombre(apellido)
   
    validar_fecha = False
    while (validar_fecha == False):
      fecha_temp = input("Ingrese la fecha de nacimiento: con el formato AAAA-MM-DD: ")
      validar_fecha = util.validar_fecha(fecha_temp, '%Y-%m-%d')
   
    validar_rh = False
    while ( validar_rh == False):
      rh = input("Ingrese el grupo sanguineo, primer carácter solo permite O, A, B, el segundo carácter solo permite (+) o (-) : ").upper()
      validar_rh = util.validar_rh(rh)
   
    validar_correo = False
    while ( validar_correo == False):
      correo = input("Ingrese el correo electrónico: ").lower()
      validar_correo = util.validar_correo(correo)

    validar_telefono = False
    while( validar_telefono == False):
      telefono = input("Ingrese el número telefónico: ")
      validar_telefono = util.validar_telefono(telefono)
   
    #Creación de diccionario de registro    
    dicc_datos["tipo_documento"] = tipo
    dicc_datos["numero_documento"] = documento
    dicc_datos["nombre"] = nombre
    dicc_datos["apellido"] = apellido
    dicc_datos["fecha_nacimiento"] = fecha_temp
    dicc_datos["rh_grupo"] = rh
    dicc_datos["email"] = correo
    dicc_datos["telefono"] = telefono

    #Agregar a las lista de usuarios
    lista_usuarios.append(dicc_datos)
    archivo_registro_p = open(RUTA_PACIENTES, 'a', encoding='utf_8')
    archivo_registro_p.write(str(dicc_datos)+ '\n')
    archivo_registro_p.close()


    print("\nUsuario registrado con exito")
   
  elif (menu == 2):
    print("""
----------------------------------------------------------------------
                  Visualización listado de personas:
----------------------------------------------------------------------
""" )
    titulo = f"Posicion \t Tipo documento \t\t Número documento \t\t Nombres y apellidos \t\t Edad \t\t Fecha/hora Cita"
    print(titulo)
   
    for posicion, usuario in enumerate(lista_usuarios):
      #Calcular edad
      fecha_nacimiento = datetime.strptime(usuario['fecha_nacimiento'],'%Y-%m-%d')
      edad = datetime.now().year - fecha_nacimiento.year
     
      #Buscar si tiene citas asociadas
      fecha_cita = ""
      for cita in lista_citas:
        if cita[0] == usuario['numero_documento']:
          fecha_cita = cita[1]

      registro = f"{posicion+1} \t\t {usuario['tipo_documento']} \t\t {usuario['numero_documento']} \t\t {usuario['nombre']} {usuario['apellido']} \t\t {edad} años \t\t {fecha_cita}"
      print(registro)

      input("\nOprima tecla enter para continuar...")

  elif (menu == 3):

    validar_tipo_documento = False
    while (validar_tipo_documento == False):
      tipo = input("Ingrese el tipo de documento, solo se acepta: CC, CE, TI, PA: ").upper()
      validar_tipo_documento = util.validar_tipo_documento(tipo)
 
    validar_documento = False
    while ( validar_documento == False):
      documento = input("Ingrese el número de documento: ")
      validar_documento = util.validar_numero_documento(documento)    
   
    #Buscar el usuario
    usuario_existe = util.buscar_documento(tipo, documento, lista_usuarios )
    if usuario_existe == True:
      validar_fecha = False
      while (validar_fecha == False):
        fecha_temp = input("Ingrese la fecha/hora de la cita: con el formato AAAA-MM-DD HH:MM :")
        validar_fecha = util.validar_fecha(fecha_temp, '%Y-%m-%d %H:%M')      
        #Validar fecha de cita
        if validar_fecha :
          if datetime.strptime(fecha_temp, '%Y-%m-%d %H:%M') <= datetime.now():
            print("No es posible asignar la cita en la fecha indicada")
            validar_fecha = False
          else:
            validar_fecha = True
     
      fecha_cita = datetime.strptime(fecha_temp, '%Y-%m-%d %H:%M')
      tupla_cita = (tipo, documento, fecha_temp)
      lista_citas.append(tupla_cita)

      #Aquí agrego la lista de pacientes para asignar la cita en el archivo
      archivo_registro_p = open(RUTA_CITAS, 'a', encoding='utf_8')
      archivo_registro_p.write(str(tupla_cita)+ '\n')
      archivo_registro_p.close()

      # Buscar usuario para extraer datos
      usuario = util.buscar_usuario(tipo, documento, lista_usuarios)
      print("\nEstimado {0} {1} su cita fue asignada correctamente para el día, {2}, a las {3} horas.".format(usuario["nombre"], usuario["apellido"], fecha_cita.strftime("%Y-%m-%d"), fecha_cita.strftime("%H:%M")))
    else:
      print("El usuario no esta registrado...")

  elif (menu == 4):
    if os.path.exists(RUTA_PACIENTES):
      nuevo_archivo = open(RUTA_PACIENTES, 'r', encoding="utf_8")

      for linea in nuevo_archivo:
        diccionario = eval(linea.replace("\n", ""))
        lista_usuarios.append(diccionario)

      nuevo_archivo.close()

      print("El archivo se cargó exitosamente!")

    else:
      print("No existe el archivo a cargar.")

    if os.path.exists(RUTA_CITAS):
      nuevo_archivo = open(RUTA_CITAS, 'r', encoding="utf_8")

      for linea in nuevo_archivo:
        diccionario = eval(linea.replace("\n", ""))
        lista_citas.append(diccionario)

      nuevo_archivo.close()

      print("El archivo se cargó exitosamente!")

    else:
      print("No existe el archivo a cargar.")


  elif (menu == 5):
 
    op = 0
    while(op !=7):

      print("""
      ----------------------------------------------------------------------
                                BUSQUEDA
      ----------------------------------------------------------------------
          1. Buscar por nombre
          2. Buscar por apellido
          3. Buscar por RH
          4. Buscar por documento
          5. Buscar por correo
          6. Buscar por teléfono
          7. Salir
      """)

      lista_resultado = []
      op = int(input("Seleccione una opción numérica: "))
      #util.clear()
      if op == 1:
        nom = input("Escriba el nombre: ")
        lista_resultado = util.buscar_datos(lista_usuarios, "nombre",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 2:
        nom = input("Escriba su apellido: ")
        lista_resultado = util.buscar_datos(lista_usuarios, "apellido",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 3:
        nom = input("Escriba su RH: ").upper()
        lista_resultado = util.buscar_datos(lista_usuarios, "rh_grupo",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 4:
        nom = input("Escriba su documento: ")
        lista_resultado = util.buscar_datos(lista_usuarios, "numero_documento",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 5:
        nom = input("Escriba su correo electrónico: ")
        lista_resultado = util.buscar_datos(lista_usuarios, "email",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 6:
        nom = input("Escriba su telefono: ")
        lista_resultado = util.buscar_datos(lista_usuarios, "telefono",nom)
        lista_resultado.sort(key= lambda ordenar_busqueda: ordenar_busqueda['apellido'])
        print(lista_resultado)

      elif op == 7:
        print("Cerrando menú Búsqueda.")

      else:
        print("Opción no válida.")

      print("""
  ---------------------------------------------------------------------------------------------------------------------------------------------------------
                                                      Visualización ORDENADA del listado de personas:
  ----------------------------------------------------------------------------------------------------------------------------------------------------------
  """ )
      titulo = f"Tipo documento \t\t Número documento \t\t Nombres y apellidos \t\t RH \t\t Correo electrónico \t\t Teléfono"
      print(titulo)
     
      for datos in (lista_resultado):
       
        tabla_ordenada = f"{datos['tipo_documento']} \t\t\t {datos['numero_documento']} \t\t\t {datos['nombre']} {datos['apellido']} \t\t\t {datos['rh_grupo']} \t\t {datos['email']} \t\t {datos['telefono']}"
        print(tabla_ordenada)


  elif (menu == 6):
    print("Saliendo de la aplicación")
  else:
    print("Opción no válida")
 
  sleep(2)
  util.clear()