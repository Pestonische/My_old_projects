Метод «поворачивающейся решётки» (turning grille) — один из простейших перестановочных методов шифрования. Суть одной из модификаций этого метода состоит в следующем. Отправитель сообщения пишет его на квадратном листе бумаги, разбитом на N строк и столько же столбцов, по одному символу в ячейку (N чётное). Для шифрования используется решётка — лист картона такого же размера, как и бумага. В решётке проделано N2 / 4 отверстий, через каждое из которых видна одна ячейка листа. При написании сообщения решётка накладывается на лист бумаги, и текст сообщения записывается в отверстия решётки. После того, как все свободные клетки заполнены, решётка поворачивается на 90 градусов по часовой стрелке, и запись продолжается. Поворачивать решётку можно три раза, и длина сообщения не превосходит N2 символов.

Получатель сообщения имеет такую же решётку и, выполняя подобные манипуляции, читает символы, появляющиеся в отверстиях.

Правильно изготовленная решётка не должна при её поворотах показывать одну и ту же клетку несколько раз. Однако отверстия вырезаются вручную, и мастер, особенно при изготовлении решётки больших размеров, может легко ошибиться…
Напишите программу, определяющую, является ли решётка правильно изготовленной.

Формат входных данных
В первой строке записана величина N — размер листа бумаги (4 ≤ N ≤ 1000, N чётное). Далее следуют N строк, каждая из которых соответствует одной строке решётки и содержит N символов ’.’ (отверстия нет) или ’*’ (отверстие есть). Количество отверстий равно N2 / 4.
Формат выходных данных
Выведите строку YES или NO в зависимости от того, является ли решётка правильно подготовленной.