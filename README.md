<h1>Втора лабораториска вежба по Софтверско инженерство</h1>

# SI_2024_lab2_223199

Ajla Zenuni 
223199

<h2>Control Flow Graph</h2>
![CFG](https://github.com/ajlazenuni/SI_2024_lab2_223199/assets/165494457/1ce70395-799c-4959-b757-9b91dac2269c)

<h2>Cyclomatic Complexity</h2>

V(G)=E−N+2P
E is the number of edges in the graph.
N is the number of nodes in the graph.
P is the number of connected components
V(G)=32-24+2=10


<h2>Тест случаи според критериумот Every statement</h2>

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

<h2>Тест случаи според критериумот Multiple Condition</h2>

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

<h2>Објаснување на напишаните unit tests</h2>

Прво тестирање: Фрла RuntimeException кога allItems е null, проверува дали пораката содржи "allItems list can't be null!".
Второ тестирање: Тестира дали фрла RuntimeException кога barcode е null, проверува дали пораката содржи "No barcode!".
Трето тестирање: Тестира дали фрла RuntimeException кога barcode содржи невалидни карактери, проверува дали пораката содржи "Invalid character in item barcode!".
Четврто тестирање: Тестира дали функцијата враќа true кога item.getName() е null, функцијата го сетира името на "unknown", и вкупната сума на ставките е помала или еднаква на плаќањето.
Петто тестирање: Тестира дали функцијата враќа true кога item.getName() е празно, функцијата го сетира името на "unknown", и вкупната сума на ставките е помала или еднаква на плаќањето.
Шесто тестирање: Тестира дали функцијата враќа true кога ставката има попуст, и вкупната сума на ставките со попуст е помала или еднаква на плаќањето.
Седмо тестирање: Тестира дали функцијата враќа true кога ставката нема попуст, и вкупната сума на ставките е помала или еднаква на плаќањето.
Осмо тестирање: Тестира дали функцијата враќа false кога вкупната сума на ставките е поголема од плаќањето.
Метод multipleConditionsTest:
Прво тестирање: Тестира дали функцијата враќа false кога сите услови item.getPrice() > 300, item.getDiscount() > 0, и item.getBarcode().charAt(0) == '0' се точни.

Влез: new Item("item", "012345", 350, 0.1f)
Очекуван излез: False
Објаснување: Условите се точни, попустот се применува, но вкупната сума ја надминува уплатата.
Второ тестирање: Тестира дали функцијата враќа false кога условите item.getPrice() > 300 и item.getDiscount() > 0 се точни, но item.getBarcode().charAt(0) == '0' е неточно.

Влез: new Item("item", "112345", 350, 0.1f)
Очекуван излез: False
Објаснување: Условите за цена и попуст се точни, но баркодот не започнува со '0'.
Трето тестирање: Тестира дали функцијата враќа false кога условите item.getPrice() > 300 и item.getBarcode().charAt(0) == '0' се точни, но item.getDiscount() > 0 е неточно.

Влез: new Item("item", "012345", 350, 0)
Очекуван излез: False
Објаснување: Цената е над 300 и баркодот започнува со '0', но нема попуст.
Четврто тестирање: Тестира дали функцијата враќа false кога условот item.getPrice() > 300 е точен, но item.getDiscount() > 0 и item.getBarcode().charAt(0) == '0' се неточни.

Влез: new Item("item", "112345", 350, 0)
Очекуван излез: False
Објаснување: Цената е над 300, но нема попуст и баркодот не започнува со '0'.
Петто тестирање: Тестира дали функцијата враќа true кога условите item.getDiscount() > 0 и item.getBarcode().charAt(0) == '0' се точни, но item.getPrice() > 300 е неточен.

Влез: new Item("item", "012345", 250, 0.1f)
Очекуван излез: True
Објаснување: Цената е под 300, но има попуст и баркодот започнува со '0'.
Шесто тестирање: Тестира дали функцијата враќа true кога условите item.getDiscount() > 0 е точен, но item.getPrice() > 300 и item.getBarcode().charAt(0) == '0' се неточни.

Влез: new Item("item", "112345", 250, 0.1f)
Очекуван излез: True
Објаснување: Цената е под 300, има попуст, но баркодот не започнува со '0'.
Седмо тестирање: Тестира дали функцијата враќа true кога условите item.getPrice() > 300 и item.getDiscount() > 0 се неточни, но item.getBarcode().charAt(0) == '0' е точен.

Влез: new Item("item", "012345", 250, 0)
Очекуван излез: True
Објаснување: Цената е под 300, нема попуст, но баркодот започнува со '0'.
Осмо тестирање: Тестира дали функцијата враќа true кога сите услови item.getPrice() > 300, item.getDiscount() > 0, и item.getBarcode().charAt(0) == '0' се неточни.

Влез: new Item("item", "112345", 250, 0)
Очекуван излез: True
Објаснување: Сите услови се неточни.



