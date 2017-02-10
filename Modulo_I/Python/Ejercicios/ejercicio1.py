
# -*- coding: utf-8 -*-
def solicitar_datos():
    subtotal = input("Subtotal: ")
    porcentaje = input("% Descuento: ")
    tasa = input("Tasa de IVA: ")

def calcular_datos():
    descuento = subtotal * porcentaje / 100.0
    total = descuento + (descuento * tasa / 100.0)

def imprimir_pantalla():
    print "=========================="
    print "Total:", total
    print "Descuento:", porcentaje
    print "IVA:", tasa

solicitar_datos()
calcular_datos()
imprimir_pantalla()