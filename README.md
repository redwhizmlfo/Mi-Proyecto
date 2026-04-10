🔹 1. len() – Longitud

Sirve para saber cuántos elementos tiene algo.

texto = "Hola"
print(len(texto))  # 4

lista = [1, 2, 3]
print(len(lista))  # 3
🔹 2. type() – Tipo de dato

Te dice qué tipo de dato es una variable.

x = 10
print(type(x))  # int
🔹 3. range() – Secuencias de números

Muy usado en bucles.

for i in range(5):
    print(i)  # 0 a 4
🔹 4. sum() – Sumar elementos

Suma todos los valores de una lista.

numeros = [1, 2, 3, 4]
print(sum(numeros))  # 10
🔹 5. max() y min()

Encuentran el mayor y el menor.

numeros = [5, 2, 9, 1]

print(max(numeros))  # 9
print(min(numeros))  # 1
🔹 6. sorted() – Ordenar

Ordena listas sin modificar la original.

numeros = [3, 1, 4, 2]

ordenados = sorted(numeros)
print(ordenados)
🔹 7. input() – Entrada de datos

Permite que el usuario escriba.

nombre = input("¿Cómo te llamas? ")
print("Hola", nombre)
🔹 8. str(), int(), float()

Conversión de tipos.

numero = "10"
numero_int = int(numero)

print(numero_int + 5)  # 15
🔹 9. enumerate() – Índice + valor

Muy útil en listas.

frutas = ["manzana", "pera", "uva"]

for i, fruta in enumerate(frutas):
    print(i, fruta)
🔹 10. zip() – Unir listas

Combina elementos de varias listas.
