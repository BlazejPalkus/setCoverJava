# 

## OPIS PROJEKTU
Pokrycie zbioru to przykład problemu optymalizacyjnego .

Instancją problemu jest zbiór Z i rodzina zbiorów R, 
numerowanych kolejnymi liczbami całkowitymi od 1.

Rozwiązaniem problemu jest pokrycie zbioru Z rodziną R, 
czyli wybór z rodziny R jak najmniejszej liczby zbiorów tak, 
by ich suma teoriomnogościowa była nadzbiorem zbioru Z.

Reprezentacją rozwiązania jest, uporządkowany rosnąco, 
ciąg numerów wybranych zbiorów.

Znalezienie rozwiązania optymalnego, czyli takiego, 
którego reprezentacja jest najkrótsza, 
wymaga zastosowania kosztownego algorytmu siłowego, 
opartego na metodzie prób i błędów.

### Algorytm dokladny
Daje to spośród  rozwiązań optymalnych, którego reprezentacja jest 
pierwsza w porządku leksykograficznym .

### Heurystyka naiwna 
Rozważa zbiory rodziny R w kolejności rosnących numerów. 
Wybiera aktualny zbiór jeśli należy do niego jakiś element zbioru Z, 
który nie należy do żadnego z dotąd wybranych zbiorów.

### Heurystyka zachłanna 
W kolejnych krokach wybiera z rodziny R zbiór, w którym jest 
największa liczba elementów zbioru Z nie należących do żadnego 
z dotąd wybranych zbiorów. 
Jeśli warunek ten spełnia wiele zbiorów, 
to wybierany jest spośród nich zbiór o najmniejszym numerze.