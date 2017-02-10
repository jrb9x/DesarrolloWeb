
# -*- coding: utf-8 -*-

def validar_nombre():

    correcto = False

    while correcto == False:
        nombre = raw_input("Introduce tu nombre: ")
        for carac in nombre:
            if carac.isspace():
                correcto = False
            elif carac == "":
                correcto = False
            else:
                correcto = True

    return nombre


print "Adivina el numero de 0 a 100, SUERTE!"
nombre = validar_nombre()

num_jugador = input("Introduce numero: ")
cont_intentos = 1

import random
num_aleatorio = random.randint(0, 100)

while num_aleatorio != num_jugador:

    if num_jugador < num_aleatorio:
        print "Sorry {}, tu elección de {} fue muy BAJA.".format(nombre, num_jugador)
        num_jugador = input("Introduce numero: ")
        cont_intentos = cont_intentos + 1
    else:
        print "Sorry {}, tu elección de {} fue muy ALTA.".format(nombre, num_jugador)
        num_jugador = input("Introduce numero: ")
        cont_intentos = cont_intentos + 1


print "Excelente trabajo {}, Tú ganas con {} intentos, el numero aleatorio era {}!".format(nombre, cont_intentos, num_aleatorio)
