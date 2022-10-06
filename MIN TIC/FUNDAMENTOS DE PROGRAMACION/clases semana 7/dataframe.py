import matplotlib.pyplot as mplt
import numpy as np
import pandas as p

datos ={
    "meses":["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"],
    "ventas" : [222,2222,22222,3333,3333,33333,44444,4444,4444,5555,55555,66666],
    "gastos" : [222,2222,22222,3333,3333,33333,44444,4444,4444,5555,55555,66666],
}
dataframe = p.DataFrame(datos)

print(dataframe)