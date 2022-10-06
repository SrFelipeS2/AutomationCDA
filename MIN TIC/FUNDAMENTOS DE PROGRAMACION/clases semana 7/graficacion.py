""" import matplotlib.pyplot as mplt
import numpy as np

datosX = [-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10]
datosY = []

for dato in datosX:
    print(dato)
    y = (2*dato)**2
    print(y)
    datosY.append(y)

print(datosX)
print(datosY)

mplt.title("grafica para (2x)**2")
mplt.plot(datosX,datosY)
mplt.ylabel("eje Y")
mplt.xlabel("eje X")
mplt.show() """


import matplotlib.pyplot as plt
import numpy as np

plt.style.use('_mpl-gallery-nogrid')

# make a stream function:
X, Y = np.meshgrid(np.linspace(-3, 3, 256), np.linspace(-3, 3, 256))
Z = (1 - X/2 + X**5 + Y**3) * np.exp(-X**2 - Y**2)
# make U and V out of the streamfunction:
V = np.diff(Z[1:, :], axis=1)
U = -np.diff(Z[:, 1:], axis=0)

# plot:
fig, ax = plt.subplots()

ax.streamplot(X[1:, 1:], Y[1:, 1:], U, V)

plt.show()