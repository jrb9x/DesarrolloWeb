
class ColeccionNumeros():

	lista = []
    
	def __init__(self, lista):
        self.lista = lista

    def max(self):
        max = 0
		
        for n in self.lista:
            if (n > max):
                max = n
				
        print "El mayor es {}.".format(max)

    def sumatorio(self):
        suma = 0
		
        for n in self.lista:
            suma += n
			
        print "El sumatorio es {}.".format(suma)

    def promedio(self):
	
        suma = self.sumatorio()
        promedio = suma / len(self.lista)
		
        print "El promedio es {}.".format(promedio)


n = 0
lista = []

while n != -1:
    n = input("Ingrese el numero (-1 salir): ")
    if n != -1:
        lista.append(n)

clase = ColeccionNumeros(lista)

clase.max()
clase.sumatorio()
clase.promedio()
    
