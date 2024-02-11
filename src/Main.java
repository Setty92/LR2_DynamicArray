public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        System.out.println(dynamicArray.get(-3)); // Вывод: 1
        System.out.println(dynamicArray.size()); // Вывод: 2
    }
}