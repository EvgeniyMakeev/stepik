public class Robot {
    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        if (direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
            return;
        }

        if (direction == Direction.UP) {
            this.direction = Direction.LEFT;
            return;
        }

        if (direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
            return;
        }

        if (direction == Direction.RIGHT) {
            this.direction = Direction.UP;
            return;
        }
    }

    public void turnRight() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    public void stepForward() {
        System.out.println("движение");
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }
    public static void test() {

        // тестовые данные (начальная позиция и массив конечных позиций)
        int x = -1, y = 1;
        int[][] arr = new int[][]{{3, 1}, {-3, 1}, {3, -1}, {-3, -1}};

        System.out.println("Начальная позиция робота: x = " + x + " ; y = " + y + "\n");

        for (int i = 0; i < arr.length; i++) {
            int toX = arr[i][0];
            int toY = arr[i][1];
            System.out.println("Конечная позиция робота: toX = " + toX + " ; toY = " + toY);
            for (Direction direction : Direction.values()) {
                System.out.print("Направление: " + direction + "; ");
               // Robot robot = new Robot(x, y, direction);
                // moveRobot(robot, toX, toY);
                // System.out.println("результат - " + (robot.getX() == toX && robot.getY() == toY) + " (x = " + robot.getX() + "; y = " + robot.getY() + ")");
            }
            System.out.println();
        }
    }
}
