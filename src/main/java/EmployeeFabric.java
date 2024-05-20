import java.util.Random;

public class EmployeeFabric {
    private static Random random = new Random();

    public static Worker generateWorker(){
        String[] names = new String[] { "Григорий", "Валентин", "Кирилл", "Евгений", "Федор", "Данил", "Станислав", "Владимир", "Артем", "Панкрат" };
        String[] surnames = new String[] { "Иванов", "Петров", "Князев", "Крамаров", "Щукин", "Рублев", "Кожевников", "Никитин", "Мальцев", "Сидоров" };
        int salary = random.nextInt(55000, 110000);
        Integer day = random.nextInt(1, 31);
        Integer month = random.nextInt(1, 12);
        Integer year = random.nextInt(1955, 2007);

        return new Worker(surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)], salary, year, month, day);
    }

    public static Manager generateManager(){
        String[] names = new String[] { "Глеб", "Михаил", "Андрей", "Вадим", "Борис", "Роман", "Денис", "Семен", "Тимофей", "Альберт" };
        String[] surnames = new String[] { "Перевозчиков", "Данилов", "Селезнев", "Кузнецов", "Мамонтов", "Пальцев", "Заварзин", "Копейкин", "Смирнов", "Кадесников" };
        int salary = random.nextInt(110000, 165000);
        Integer day = random.nextInt(1, 31);
        Integer month = random.nextInt(1, 12);
        Integer year = random.nextInt(1955, 2007);

        return new Manager(surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)], salary, year, month, day);
    }

    /**
     * Фабрика по созданию рабочих
     * @param count
     * @return
     */
    public static Employee[] generateEmployees(int count){
        Employee[] workers = new Employee[count];
        int length = count - 1;

        if (count % 2 != 0) {
            workers[count - 1] = generateManager();
        }

        for (int i = 0; i < length; i++) {
            workers[i] = generateWorker();
        }
        return workers;
    }
}
