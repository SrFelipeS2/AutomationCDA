lista_carros = [4, 5]
tupla = (1, 2)
carro = { "color":"rojo", "marca":"kia", "modelo":"2000", "placa": "AAA111" }


print(lista_carros[0])
print(tupla[0])
print(carro["color"])

"""
#obtener
print(carro["color"])
print(carro.get("marca"))

#Recorrer un diccionario
for elemento in carro:
    print(elemento, ":", carro[elemento])

#modificar
color = input("Digite el color del vehiculo")
marca = input("Digite la marca del vehiculo")
modelo = input("Digite el modelo del vehiculo")

carro["color"] = color
carro["marca"] = marca
carro["modelo"] = modelo

#agregar
carro["soat"] = True
carro.update({ "tecno": False, "alto": "S", "modelo":"1997", "placa": "AAA111" })

#eliminar una propiedad
carro.pop("alto")

#keys, values
print(carro.keys())
print(carro.values())
"""
#imprimir
print(carro)

carro_audi = { "color":"negro", "marca":"audi", "modelo":"2022", "soat": True, "placa": "BBB111" }

print(carro_audi)

lista_carros.append(carro)
lista_carros.append(carro_audi)

print(lista_carros)

def buscarVehiculo(placa, lista):

    #buscar en la lista
    encontroVehiculo = False
    for indice, dic_carro in enumerate(lista):
        print(indice)
        if dic_carro["placa"] == placa:
            encontroVehiculo = True
    
    return encontroVehiculo

encontroVehiculo = buscarVehiculo("AAA112", lista_carros)

if encontroVehiculo :
    print("Ya la placa ya existe y no se puede registrar")
else:
    print("Se puede registrar su vehiculo")

exit()
print(lista_carros)

exit()

persona = { "nombre":"Juan Carlos", "apellido":"Zambrano" }
print(persona)
print(persona["nombre"])
print(persona.get("nombre"))

print(persona.keys())

persona["nombre"] = "1110123456"
print(persona)

persona["edad"] = 17
print(persona)

lista_personas = [ persona ]
print(lista_personas)
lista_personas = []
lista_personas.append(persona)
print(lista_personas)

print(lista_personas[0]["nombre"])