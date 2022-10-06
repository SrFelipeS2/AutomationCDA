#Agregar a las lista de usuarios
    lista_usuarios.append(dicc_datos)
    archivo_registro_p = open(ARCHIVO_PACIENTES, 'a', encoding='utf_8')
    archivo_registro_p.write(str(dicc_datos)+ '\n')
    archivo_registro_p.close()