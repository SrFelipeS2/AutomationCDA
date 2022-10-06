from ast import Return
from random import *
import datetime 
import re

from numpy import void

 
def validar_datos_iniciales(tipo_documento, num_documento, nombre, apellido):
    if not(tipo_documento in ['CC','CE','TI','PA']):
        return(False, "Tipo de documento inválido")
    elif len(num_documento) > 12:
        return(False, "Numero de documento inválido")
    elif num_documento.count(".") > 0:
        return(False, "Numero de documento inválido Contiene signos de puntuacion")
    elif num_documento.count(",") > 0:
        return(False, "Numero de documento inválido Contiene signos de puntuacion")
    elif len(nombre) >= 30:
        return (False,  "El nombre excede el número de carácteres permitidos (30)") 
    elif len(apellido) >= 30:
        return(False, "El apellido excede el número de carácteres permitidos (30)")
    else: 
        return (True, "")

def validar_fecha_edad(fecha_nacimiento):
    if len(fecha_nacimiento) >= 10:
        fecha_nacimiento = datetime.datetime.strptime(fecha_nacimiento,'%Y-%m-%d').date()
        today = datetime.date.today() 
        age = today.year - fecha_nacimiento.year - ((today.month, today.day) < (fecha_nacimiento.month, fecha_nacimiento.day)) 
        return (True, age, "")
    else:
        age=0
        return(False, age, "Fecha incorrecta")

def validar_sangre(rh ):
    if not (rh in ['O+','A+','B+','O-','A-','B-']) :
        return(False, "Tipo de grupo sanguíneo inválido")
    else:
        return(True,"")


regex = r'^[(a-z0-9\_\-\.)]{3,10}@[(a-z0-9\_\-)]{3,}\.[(a-z)]{2,3}'
 
def validar_correo(correo): 
    if len(correo) > 50:
        return(False, "El correo excede el número de carácteres permitidos")
    if(re.fullmatch(regex, correo)):
        return(True, "")
    else:
        return(False, "Correo inválido")

def validar_telefono(telefono):
    if len(telefono) <= 10 and str.isdigit(telefono) == True:
        return (True, "")
    elif telefono.count(".") > 0:
        return(False, "Numero de telefono inválido Contiene signos de puntuacion")
    elif telefono.count(",") > 0:
        return(False, "Numero de telefono inválido Contiene signos de puntuacion")
    else:
        return(False, "el nunmero ingresado esta mal indexado, revise que no contenga espacios y letras y que cumpla con un maximo de 10 digitos")


        
def asignar_cita(lista_personas, lista_citas):
    valido = False
    cedula = str(input("Ingrese su número de documento (sin puntos ni comas): "))
    for persona in lista_personas:
        if cedula in persona.values():
            valido = True
    if valido ==  True:
        condicion = False
        while condicion ==  False:
            fecha_cita = input("Ingrese la fecha en la que quiere solicitar su cita (AAAA-MM-DD-HH:MM): ") 
            fecha_cita =  datetime.datetime.strptime(fecha_cita, "%Y-%m-%d-%H:%M")
            today = datetime.datetime.today() 
            if(fecha_cita > today):
                lista_citas.append((cedula, fecha_cita))
                condicion = True
                pacientes = open("./archivos/tuplas_citas.txt", "a")
                pacientes.write(str(lista_citas)+ "\n")
                pacientes.close()
                archivo_lectura = open("./archivos/tuplas_citas.txt", "r")
                for linea in archivo_lectura:
                    print(linea)
                archivo_lectura.close()
                return (True, "su fecha quedo asignada para la fehca:", fecha_cita)
            else: 
                print("La fecha no está disponible, ingrese otra fecha")
        
    else:
        fecha_cita = void
        return (False, "El usuario no está registrado", fecha_cita)

# fecha_cita = '22/05/2022 18:24:13'
# ahora = datetime.now().strftime("%d/%m/%Y %H:%M:%S")
# fecha_cita > ahora

def visualizar_listado(lista_personas, lista_citas):
    print(f"-------------------------------------------------------------------------------------------------------------------------------------------------")
    print(f"No. \t\t Tipo documento \t\t Documento \t\t Nombre completo \t\t Edad \t\t Fecha/hora")
    print(f"-------------------------------------------------------------------------------------------------------------------------------------------------")
    
    for i in range(0,len(lista_personas)):
        citas = 'No tiene'
        for cita in lista_citas:
            if lista_personas[i]['Documento'] in cita:
                citas = cita[1]
        print(f"{str(i+1)}  \t\t {lista_personas[i]['TipoDocumento']}  \t\t {lista_personas[i]['Documento']} \t\t {lista_personas[i]['Nombre']}  \t\t {lista_personas[i]['Apellido']} \t\t {lista_personas[i]['Edad']} \t\t {citas}")   

def busqueda_especializada(valor,lista_personas):
    for persona in lista_personas:
        if persona["Nombre"] == valor:
            return(persona)
