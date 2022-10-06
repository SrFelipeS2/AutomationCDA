import datetime
#En este modulo agregar la función de validación del código CDIA

def buscar_CDIA(CDIA: str) -> bool:
	""" 
	Función encarga de validar si existe un código de CDIA registrado por un jugador

	Parameters
	-----------------
	CDIA : str
		Código de identificación ASCII

	Returns
	------------------
	existe : bool
		Retorna True si existe, de lo contrario False
	"""
	
    #Lista de usuarios CDIA
	lista = ["JUANK@vv+=","CARLO@v?+k","MARIO@kv=+"]

	if CDIA in lista:
		return True
	else:
		return False

def validar_CDIA(CDIA):
	#------------------------------------------------
	# Validaciones 
	#------------------------------------------------
	# Escribir las validaciones
	

	#------------------------------------------------
	# Buscar si el CDIA existe para otro usuario
	#------------------------------------------------
	existe = buscar_CDIA(CDIA)

	return existe
  
def calculateAge(date): 
    birthDate = datetime.datetime.strptime(date, "%Y-%m-%d").date()
    today = datetime.date.today() 
    age = today.year - birthDate.year - ((today.month, today.day) < (birthDate.month, birthDate.day)) 
	
    return age 

def asignationWorld(edad, userPastGame, levelAsignedUser):
    if(edad>12 and edad<=20 and userPastGame == 2):
        world = 1
    elif(edad>12 and edad<=20 and userPastGame == 1 and levelAsignedUser < 50 ):
        world = 2
    elif(edad>12 and edad<=20 and userPastGame == 1 and levelAsignedUser >= 50):
        world = 3
    elif(edad>20 and userPastGame == 2):
        world = 4
    elif(edad>20 and userPastGame == 1 and levelAsignedUser < 50):
        world = 5
    elif(edad>20 and userPastGame == 1 and levelAsignedUser >= 50):
        world = 6
    return world  
    
