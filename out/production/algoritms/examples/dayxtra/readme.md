# Описание проекта: звучное применение алгоритма Дейкстры для вычисления арифметических выражений

Этот проект представляет алгоритм Дейкстры для парсинга и вычисления арифметических выражений.

## Общий обзор

Алгоритм использует два стека: стек операторов и стек значений. Он обрабатывает выражения, разбивая их на токены, и применяет следующие правила:

1. Каждое значение (число) помещается в стек значений.
2. Открывающую скобку никуда не записывают.
3. Когда встречается знак операции (+,-,*,/), его помещают в стек операторов.
4. При встрече закрывающей скобки выполняют операцию из стека операторов с двумя числами из стека значений и кладут результат обратно в стек значений.
5. В конце работы, в стеке значений остается результат всего выражения.

## Пример

Примем в качестве примера выражение `( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )`. Алгоритм будет обрабатывать его, следуя правилам выше:

1. Встречаем цифру 1, кладем в стек;
2. Встречаем знак "+", кладем в стек операторов;
3. Встречаем открывающую скобку;
4. Встречаем цифру 2, кладем в стек;
5. Встречаем знак "+", кладем в стек операторов;
6. Встречаем цифру 3, кладем в стек;
7. Встречаем закрывающую скобку, выполняем операцию 2 + 3, результат 5 кладем в стек значений;
8. Встречаем знак "*", кладем в стек операторов;
9. Встречаем цифру 4, кладем в стек;
10. Встречаем знак "*", кладем в стек операторов;
11. Встречаем цифру 5, кладем в стек;
12. Встречаем закрывающую скобку, выполняем операцию 4 * 5, результат 20 кладем в стек значений;
13. Встречаем закрывающую скобку, выполняем операцию 5 * 20, результат 100 кладем в стек значений;
14. Встречаем закрывающую скобку, выполняем операцию 1 + 100, результат 101 остается в стеке значений.

Результат вычисления выражения - 101.

Опираясь на этот пример, алгоритм может быть расширен и модифицирован под различные типы арифметических выражений и операций.