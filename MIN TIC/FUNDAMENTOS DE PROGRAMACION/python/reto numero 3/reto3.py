from datetime import date, datetime
import utilidades as util

CDIA = "";
CDIA=(input("Como nuevo jugador en linea de WorldCraft ASCII por favor asigne su nuevo codigo de identificacion con las siguientes indicaciones:\n • Se debe verificar que el CDIA sea de tipo texto exclusivamente y sin dígitos numéricos\n • En la posición 6 de la cadena del CDIA debe ir siempre el carácter arroba (‘@’)\n • El carácter en la primera posición y el carácter en la última posición del CDIA deben ser diferentes.\n • El CDIA debe contener en cualquier posición de la cadena el carácter arroba (‘+’)\n • El código CDIA no debe contener más de 3 veces la letra ’k’\n • El CDIA debe tener al menos uno de los siguientes símbolos (‘?’,’=’,’&’)\n • Recuerde que debe contener 10 caracteres.\n en este espacio puede procede a digitar su CDIA con las indicaciones anterirormente explicadas:\n")).upper()

pd=CDIA[1]
ud=CDIA[9]
longitud=len(CDIA)
busq1=CDIA[5].find("@")
value = CDIA
[char.isdigit() for char in value]
simbolos = CDIA.find("?") != 1 or CDIA.find("&") != 1 or CDIA.find("=") != 1
if(longitud==10 and (pd!=ud) and busq1!=-1 and False in [char.isdigit() for char in value] and  CDIA.count("k") <= 3 and "+" in CDIA and simbolos == 1 and util.buscar_CDIA(CDIA)==False):

    print(CDIA)
    print("entro a la condicion")
    userdate = (input("por Favor ingrese su fecha de nacimiento en el siguiente formato aaaa/mm/dd:\n"))
    edad = util.calculateAge(userdate)
    if(util.calculateAge(userdate)>=12):
        userAlias=input("por favor ingrese un Alias para su cuenta:\n")
        if(len(userAlias)<5):
            print("el Alias de Usuario debe tener al menos 5 caracteres")
        else:
            userPastGame=int(input("usted ah jugado antes el WorldCraft ASCII digita 1 si tu respuesta es 'si'\n si tu respuesta es 'no' presiona 2\n"))
            if(userPastGame==1):
                levelPastPlayer=int(input("hasta que nivel llego en el juego anterior?, recuerde que el nivel es 1 a 1000"))
                if(util.calculateAge(userdate)<=16 and userPastGame == 2 ):
                    levelAsignedUser=2
                    print(f"su nivel actual del juego sera {levelAsignedUser}")
                    mundo = util.asignationWorld(edad, userPastGame,levelAsignedUser)
                    print(f"su mundo de reaparicion sera {mundo}")
                elif(util.calculateAge(userdate)>=16 and userPastGame == 1):
                    levelAsignedUser=levelPastPlayer+2
                    print(f"su nivel actual del juego sera {levelAsignedUser}")
                    mundo = util.asignationWorld(edad, userPastGame,levelAsignedUser)
                    print(f"su mundo de reaparicion sera {mundo}")
    
else:
    print("CIDA invalido")
    
   
  
     
                    


