import matplotlib.pyplot as plt
import utilidades 
import pandas as p
import numpy as np


"""  5. cargar archivos pacientes
        6. cargar archivos citas   """      
listaMeses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
listaVS1 =["","","","","","","","","","","",""]
listaVS2 =["","","","","","","","","","","",""]
listaVS3 =["","","","","","","","","","","",""]
listaGS1 =["","","","","","","","","","","",""]
listaGS2 =["","","","","","","","","","","",""]
listaGS3 =["","","","","","","","","","","",""]



opcion = 0

while opcion != 6 :

    print("""
        1. En esta opcion puede capturar las ventas mensuales por sede.
        2. En esta opcion puede capturar los gastos mensuales por sede.
        3. Esta opcion le permite visualizar los datos capturados mediante un dataFrame.
        4. Esta opcion le permite visualizar un gráfico de líneas de las ventas de las 3 sedes.
        5. Esta opcion le permite visualizar un gráfico de columnas agrupadas de las ventas y gastos de la sede 1 en el primer semestre.
        6. Salir.
    """)

    opcion = int( input("Seleccione una opción: ") )

    if opcion == 1:
        sede = 0
        while sede != 4 :
            print("""
                1. presione 1 para capturar valores de venta en la primera sede.
                2. presione 2 para capturar valores de venta en la segunda sede.
                3. presione 3 para capturar valores de venta en la tercera sede.
            """)

            sede = int(input("seleccione una opcion: ")) 
            sede = utilidades.asignacion_valores(sede, listaVS1,listaVS2,listaVS3)
            
    elif opcion == 2:
        sede = 0
        while sede != 4 :
            print("""
                1. presione 1 para capturar valores de gastos en la primera sede.
                2. presione 2 para capturar valores de gastos en la segunda sede.
                3. presione 3 para capturar valores de gastos en la tercera sede.
            """)

            sede = int(input("seleccione una opcion: ")) 
            sede = utilidades.asignacion_valores_gastos(sede, listaGS1,listaGS2,listaGS3)
            
    elif opcion == 3:
        
        datos ={
            "meses":listaMeses,
            "venta sede 1":listaVS1,
            "venta sede 2":listaVS2,
            "venta sede 3":listaVS3,
            "Gastos sede 1":listaGS1,
            "Gastos sede 2":listaGS2,
            "Gastos sede 3":listaGS3
        }
        dataframe = p.DataFrame(datos)

        print(dataframe)
    
    
   
    elif opcion == 4:
        print("recuerde que debe de tener alguna informacion registrada de lo contrario el grafico no va a tener valores")
        datos1 ={
            "meses":listaMeses,
            "venta sede 1":listaVS1,
            "venta sede 2":listaVS2,
            "venta sede 3":listaVS3,
        }
        dataframe1 = p.DataFrame(datos1)
        eje_x = listaMeses
        serieVenta1 = dataframe1["venta sede 1"]
        serieVenta2 = dataframe1["venta sede 2"]
        serieVenta3 = dataframe1["venta sede 3"]
        plt.plot(eje_x, serieVenta1,"r-",label="venta sede 1")
        plt.plot(eje_x,serieVenta2,"g-",label="venta sede 2")
        plt.plot(eje_x,serieVenta3,"b-",label="venta sede 3") 
        plt.legend() 
    
        plt.xlabel("meses del año")
        plt.ylabel("valores venta")
        plt.title("Ventas Registradas en las tres sedes ")
        
        plt.show()
        
    elif opcion == 5:
        print("recuerde que debe de tener alguna informacion registrada de lo contrario no va a mostrar ningun grafico")
        datos ={
            "meses":listaMeses,
            "venta sede 1":listaVS1,
            "Gastos sede 1":listaGS1,
        }
        dataframe = p.DataFrame(datos)
        eje_x = dataframe["meses"].iloc[0:6]
        serieVenta = dataframe["venta sede 1"].iloc[0:6]
        serieGastos = dataframe["Gastos sede 1"].iloc[0:6]
        lista_indices = np.arange(len(eje_x))
        ancho_columna = 0.35
        plt.bar(lista_indices, serieGastos, width=ancho_columna, label="Gastos", color="orange")
        plt.bar(lista_indices + ancho_columna, serieVenta, width=ancho_columna, label="Ventas", color="green")
        plt.legend(loc='best')
        
       
        plt.xticks(lista_indices, eje_x)
        plt.xlabel("meses del año")
        plt.ylabel("valores venta-gastos")
        plt.title("Ventas y Gastos Registrados en el primer semestre del año")
        plt.show()
        
    elif opcion == 6:
        print("Gracias por usar este programa, la informacion se eliminara...")
     


        

        