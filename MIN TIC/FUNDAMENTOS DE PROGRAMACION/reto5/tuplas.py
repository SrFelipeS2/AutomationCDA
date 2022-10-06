from collections import namedtuple

lista_elementos = [1, 2, 3, 4, "l", True]
tupla_elementos = (1, 2, 3, 4, "l", True)
print(tupla_elementos)
lista_elementos[5] = False
#tupla_elementos[5] = False
print(tupla_elementos[0])
print(lista_elementos[0])

for i in tupla_elementos:
    print(i)

#Tipo de elemento
print(type(lista_elementos))

#No es posible asignar ya que es inmutable
#elementos[0] = 5

#Tupla nombrada
Circle = namedtuple ( "Circulo" , "x y radio color")
#Circulo = namedtuple ( "Circulo" , ["x", "y", "radio", "color"])
pt1 = Circle (3, 2, 2, "Cian")
pt2 = Circle (4, 6, 1, "Blue")
resultado = (pt1.x + pt2.x, pt1.y + pt2.y, pt1.radio/pt2.radio)
print(resultado)
print ("x: ", pt1.x)
print ("y: ", pt1.y)
print ("radio: ", pt1.radio)
print ("color: ", pt1.color)
print(pt1)
print(type(Circle))
print(type(pt1))

#asignación multiple
x, y, radio, color = pt1
print (x)
print (y)
print (radio)
print (color)

#funcion de retorno multiple
def operacionesBasicas(numero1, numero2):
    suma = numero1 + numero2
    resta = numero1 - numero2
    multiplicacion = numero1 * numero2
    division = numero1 / numero2
    error = "No hay error"
    
    return [suma, resta, multiplicacion, division, error]

#r1, *resultado = operacionesBasicas(4, 2)
r1, r2, r3, r4, error = operacionesBasicas(4, 2)
print("clase" , type(r1))
print(resultado)
print(r1)
exit()
print(r1)
print(r2)
print(r3)
print(r4)
print(error)