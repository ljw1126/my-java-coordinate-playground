package coordinate.model;

import java.util.Objects;

public class PointY {
    private static final int MAX_VALUE = 24;

    private int y;

    public PointY(int y) {
        if(y > MAX_VALUE) {
            throw new IllegalArgumentException("y좌표 값은 0 ~ 24까지 입력 가능합니다");
        }
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointY pointY = (PointY) o;
        return y == pointY.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y);
    }
}
