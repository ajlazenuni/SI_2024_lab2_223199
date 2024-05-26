# SI_2024_lab2_223199

Ajla Zenuni 
223199

Control Flow Graph
![CFG](https://github.com/ajlazenuni/SI_2024_lab2_223199/assets/165494457/1ce70395-799c-4959-b757-9b91dac2269c)

Cyclomatic Complexity

V(G)=E−N+2P
E is the number of edges in the graph.
N is the number of nodes in the graph.
P is the number of connected components
V(G)=32-24+2=10


Тест случаи според критериумот Every statement

Тест случај 1: allItems е null
Влез: checkCart(null, 100) 
Фрла RuntimeException со порака "allItems листата не може да биде null!" 

Тест случај 2: item.getName() е null
Влез: checkCart([new Item(null, "12345", 100, 0)], 100) 
true (името се поставува на "unknown", баркодот е валиден, цената е во рамките на плаќањето) 

Тест случај 3: item.getName() е празно
Влез: checkCart([new Item("", "12345", 100, 0)], 100) 
true (името се поставува на "unknown", баркодот е валиден, цената е во рамките на плаќањето) 

Тест случај 4: item.getBarcode() е null
Влез: checkCart([new Item("item", null, 100, 0)], 100) 
Фрла RuntimeException со порака "Нема баркод!" 

Тест случај 5: item.getBarcode() содржи невалиден карактер
Влез: checkCart([new Item("item", "12a45", 100, 0)], 100) 
Фрла RuntimeException со порака "Невалиден карактер во баркодот на производот!" 

Тест случај 6: item.getDiscount() > 0
Влез: checkCart([new Item("item", "12345", 100, 0.1f)], 100) 
true (попустот е применет, цената е во рамките на плаќањето) 

Тест случај 7: item.getDiscount() <= 0
Влез: checkCart([new Item("item", "12345", 100, 0)], 100) 
true (без попуст, цената е во рамките на плаќањето) 

Тест случај 8: item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'
Влез: checkCart([new Item("item", "012345", 350, 0.1f)], 100) 
false (цената го надминува плаќањето и со применет попуст) 

Тест случај 9: сум <= плаќање
Влез: checkCart([new Item("item", "12345", 100, 0)], 100) 
true (цената е во рамките на плаќањето)

Тест случај 10: сум > плаќање
Влез: checkCart([new Item("item", "12345", 150, 0)], 100) 
false (цената го надминува плаќањето)

Тест случаи според критериумот Multiple Condition

Комбинации на тест случаи
(T, T, T):
Влез: new Item("item", "012345", 350, 0.1f)
Очекуван излез: True (условот е вистинит, попустот е применет)
(T, T, F):
Влез: new Item("item", "112345", 350, 0.1f)
Очекуван излез: True (цената и попустот се вистинити, но условот за баркодот е невистинит)
(T, F, T):
Влез: new Item("item", "012345", 350, 0)
Очекуван излез: True (цената е вистинита, но попустот е невистинит)
(T, F, F):
Влез: new Item("item", "112345", 350, 0)
Очекуван излез: True (цената е вистинита, но попустот и условот за баркодот се невистинити)
(F, T, T):
Влез: new Item("item", "012345", 250, 0.1f)
Очекуван излез: True (цената е невистинита, но попустот и условот за баркодот се вистинити)
(F, T, F):
Влез: new Item("item", "112345", 250, 0.1f)
Очекуван излез: True (цената е невистинита, но попустот е вистинит, условот за баркодот е невистинит)
(F, F, T):
Влез: new Item("item", "012345", 250, 0)
Очекуван излез: True (цената и попустот се невистинити, но условот за баркодот е вистинит)
(F, F, F):
Влез: new Item("item", "112345", 250, 0)
Очекуван излез: True (сите услови се невистинити)






