# -*- coding: utf-8 -*-
class Numeros():

    lista = []

    def __init__(self, lista):
        self.lista = lista

    def mayor(self):
        mayor = 0
        for x in self.lista:
            if(x>mayor):
                mayor = x
        return mayor

    def sumar(self):
        suma = 0
        for x in self.lista:
            suma+=x
        return suma

    def promedio(self):
        suma = self.sumar()
        return suma/len(self.lista)

num = 0
list = []
while(True):
    while(num!=-1):
        try:
            num = input("Introduce tu numero (-1 para Salir): ")
            if (num < -1):
                print "ERROR: Debes introducir numeros positivos ó 0"
            elif (num > -1):
                list.append(float(num))
        except:
            print "ERROR: Debes introducir numeros positivos ó 0"

    clase = Numeros(list)
    print "El numero mayor es:",clase.mayor()
    print "La suma de los numeros es:",clase.sumar()
    print "La media de los numeros es:",clase.promedio()
    print
    print "=========================================================================="
    num = 0