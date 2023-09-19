import java.util.ArrayList;
import java.util.List;

class Toy {
    private String name;
    private String image;
    private int weight;

    // Конструктор
    public Toy(String name, String image, int weight) {
        this.name = name;
        this.image = image;
        this.weight = weight;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class ToyStore {
    private List<Toy> toys;

    // Конструктор
    public ToyStore() {
        toys = new ArrayList<>();
    }

    // Метод для добавления новой игрушки
    public void addToy(String name, String image, int weight) {
        Toy toy = new Toy(name, image, weight);
        toys.add(toy);
    }

    // Метод для задания веса для выпадения игрушек
    public void setToyWeight(Toy toy, int weight) {
        toy.setWeight(weight);
    }

    // Метод для розыгрыша игрушек
    public Toy play() {
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomWeight = (int) (Math.random() * totalWeight);

        int weightSum = 0;
        for (Toy toy : toys) {
            weightSum += toy.getWeight();
            if (weightSum > randomWeight) {
                return toy;
            }
        }

        // Если не удалось выбрать игрушку, вернуть null
        return null;
    }
}

public class ToyStoreGame {
    public static void main(String[] args) {
        // Создание объекта магазина игрушек
        ToyStore toyStore = new ToyStore();

        // Добавление новых игрушек
        toyStore.addToy("Кукла", "image1.jpg", 5);
        toyStore.addToy("Мяч", "image2.jpg", 3);
        toyStore.addToy("Машинка", "image3.jpg", 4);

        // Задание веса для игрушек
        Toy doll = toyStore.play();
        if (doll != null) {
            toyStore.setToyWeight(doll, 7);
        }

        Toy ball = toyStore.play();
        if (ball != null) {
            toyStore.setToyWeight(ball, 6);
        }

        Toy car = toyStore.play();
        if (car != null) {
            toyStore.setToyWeight(car, 8);
        }

        // Розыгрыш игрушки
        Toy winner = toyStore.play();

        if (winner != null) {
            System.out.println("Выиграла игрушка: " + winner.getName());
        } else {
            System.out.println("Игрушек нет в наличии.");
        }
    }
}
  