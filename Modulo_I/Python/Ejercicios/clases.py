# -*- coding: utf-8 -*-
class Dog():
    __name = ''
    def bark(self):
        print "{}, guau... guau... ".format(self.name)
        print
    '''
    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name
    '''
    @property
    def name(self):
        return self.name

    @name.setter
    def name(self, name):
        self.name = name

'''Instancia de clase perro...'''
perro1 = Dog()
perro1.name = 'Doqui'

'''Instancia de clase perro...'''
perro2 = Dog()
perro2.name = 'Firulaes'

'''Perros ladran'''
perro2.bark()
perro1.bark()