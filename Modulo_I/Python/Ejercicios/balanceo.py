
# -*- coding: utf-8 -*-
def corchete(mi_lista):

    cont = 0

    for carac1 in mi_lista:
        if carac1 == "[":
            cont = cont + 1

        if carac1 == "]":
            cont = cont - 1

    if cont == 0:
        return True
    else:
        return False


def llave(mi_lista):
    cont = 0

    for carac1 in mi_lista:
        if carac1 == "{":
            cont = cont + 1

        if carac1 == "}":
            cont = cont - 1

    if cont == 0:
        return True
    else:
        return False


def parentesis(mi_lista):
    cont = 0

    for carac1 in mi_lista:
        if carac1 == "(":
            cont = cont + 1

        if carac1 == ")":
            cont = cont - 1

    if cont == 0:
        return True
    else:
        return False

def validar_cadena(cadena):

    mi_lista = []

    for cad in cadena:
        if (cad == "[" or cad == "{" or cad == "(" or cad == "]" or cad == "}" or cad == ")"):
            mi_lista.append(cad)

    corch = corchete(mi_lista)

    llav = llave(mi_lista)

    parent = parentesis(mi_lista)

    if (corch == True and llav == True and parent == True):
        print cadena, "es Valida"
    else:
        print cadena, "no es Valida"


cadena = raw_input("Introduce una cadena: ")
validar_cadena(cadena)