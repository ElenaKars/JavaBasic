//Task 4
//Опционально
//Создайте два списка. Один на реализации ArrayList, второй на LinkedList.
//
//Заполните их 5_000 одинаковыми случайными значениями от 0 до 1_000.
//
//Создайте 4 метода, принимающий реализацию интерфейса List.
//
//В первом методе - получение всех значений элементов списка по индексу (перебрать все индексы, взять значение по текущему индексу)
//Второй метод - вставка 2_000 новых значений по случайному индексу (диапазон индексов от 0 до размера списка)
//Третий метод - удалить 1_000 элементов по случайному индексу. (диапазон индексов от 0 до размера коллекции)
//Удалить 1_000 элементов по значению (диапазон случайных значений от 0 до 10_000)
//Все методы должны возвращать время, затраченное на выполнение метода в миллисекундах.
//
//Сравните для каждого из списка время выполнения каждого метода.
//
//И сравните время последовательного выполнения всех методов для каждой реализации List-а.
package homework_40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task_4 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 5000; i++){
            int randomVal = random.nextInt(1001);
            arrayList.add(randomVal);
            linkedList.add(randomVal);
        }
        int index = 10;
        System.out.println("Value at index " + index + " in ArrayList: " + getValueByInd(arrayList, index));
        System.out.println("Value at index " + index + " in LinkedList: " + getValueByInd(linkedList, index));

    }
    public static int getValueByInd(List<Integer> list, int ind){
        if (ind >= 0 && ind < list.size()){
            return list.get(ind);
        }
        return -1;
    }
}
