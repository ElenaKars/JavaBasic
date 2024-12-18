package lesson_26;

import lesson_26.methods.Util;
import lists.MyArrayList;

public class Wrappers {

    // Классы-оббертки используются в джава для представления примитивных типов данных, как объектов
    // Byte => обертка для byte
    // Short => обертка для short
    // Integer => обертка для int
    // Long => обертка для long
    // Float => обертка для  float
    // Double => обертка для double
    // Character => обертка для char
    // Boolean => обертка для boolean

    public static void main(String[] args) {
        // Автоматическая приведение типов
        // Автоупаковка и автораспаковка

        Integer wrapperInt = 5;// автоупакрвка примитива int в ссылочный тип Integer
        System.out.println(wrapperInt);

        int primitiveInt = wrapperInt;// автораспаковка из типа Integer автоматически преобразовывание в примитив int
        //сравнение объектов
        //кэширование объектов -128...127

        Boolean boolWrapper = true;
        System.out.println("boolWrapper: " + boolWrapper);
        boolWrapper = null;//у ссылочного Boolean есть третье значение = null

        Integer a = 127;
        Integer b = 127;
        System.out.println("a==b: " + (a==b));
        System.out.println("a.equals(b): " + a.equals(b));

        Integer c = 128;
        Integer d = 128;
        System.out.println("c==d: " + (c==d));
        System.out.println("c.equals(d): " + c.equals(d));

        System.out.println("\n================\n");

        Integer maxValue = Integer.MAX_VALUE;
        System.out.println("maxValue: " + maxValue);
        System.out.println("minValue: " + Integer.MIN_VALUE);

        //Схожие методы для всех оберточных типов

        //1. valueOf() = преобразовывает примитивы или строку в объект обертки

        Integer e = Integer.valueOf(127);
        Integer f = Integer.valueOf(127);
        System.out.println("e==f: " + (e == f));

        Integer intStr = Integer.valueOf("123");
        System.out.println(intStr + 100);

        Double doubleWrap = Double.valueOf(154.5);
        System.out.println("Double.valueOf(154.5): " + doubleWrap);

        //2. parseXXX() = преобразует строку в соответсвующий примитив
        // "456"
        System.out.println(Integer.parseInt("456") + 100);

        double d1 = Double.parseDouble("345.5") + 200;
        System.out.println(d1);

        //3. toString = возвращает строковое представление числа
        System.out.println(doubleWrap);

        // 4. equals(Object) - сравнение объектов на равенство по значению

        Long l1 = 200L;
        //l1 = Long.valueOf(200)

        System.out.println("l1.equals(200): " + l1.equals(200L));

        Integer int1 = 150;
        System.out.println("int1.equals(150): " + int1.equals(150));

        //5. compareTo() - сравнивает объект с другим объектом того же типа (определяет кто больше)

        Integer iMax = 250;
        Integer iMin = 120;
        Integer iSuper = 500;
        System.out.println("iMax.compareTo(iMin): " + iMax.compareTo(iMin));
        System.out.println("iMax.compareTo(iSuper): " + iMax.compareTo(iSuper));
        System.out.println("iMax.compareTo(250): " + iMax.compareTo(250));
// выдает 1 если объект больше
        //выдает -1 если объект меньше
        //выдает 0 если объекты равны

        //xxxValue() - возвращает значение в виде примитивном виде

        Double d2 = Double.valueOf(125.56);// явная принудительная упаковка. Примитив -> обертка

        double dPrimitive = d2.doubleValue();//явная принудительная распаковка. обертка -> Примитив

        System.out.println("\n==============");

        //все числовые обертки наследуются от абстрактного класса Number
        /*
        Byte => byteValue()
        Short => обертка для shortValue()
        Integer => обертка для intValue()
        Long => обертка для longValue()
        Float => обертка для  floatValue()
        Double -> doubleValue()
         */

        Integer integer = 31866;
        Double doubleVal = 234.54;

        short shortPrimitive = integer.shortValue();
        int intPrimitive = doubleVal.intValue();
        System.out.println("intPrimitive: " + intPrimitive);

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(1, 2, 3, 4, 5, 6, 7);
        double listSum = Util.listSum(myArrayList);
    }
}