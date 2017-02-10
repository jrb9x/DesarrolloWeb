
# -*- coding: utf-8 -*-
edad_perro = input("Introduce edad Perro: ")

if edad_perro == 1:
    edad_humano = 14
elif edad_perro == 2:
    edad_humano = 22
else:
    edad_humano = 22 + (edad_perro - 2) * 5

print edad_humano
