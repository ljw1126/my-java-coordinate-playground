package coordinate;

import java.util.Objects;

public class PointX {
    private static final int MAX_VALUE = 24;
    private int x;

    public PointX(int x) {
        if(x > MAX_VALUE) {
            throw new IllegalArgumentException("x 좌표는 0 ~ 24까지만 입력 가능합니다");
        }
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointX pointX = (PointX) o;
        return x == pointX.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
