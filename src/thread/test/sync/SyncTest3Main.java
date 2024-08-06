package thread.test.sync;

public class SyncTest3Main {

    // 멀티 스레드 상황에서 getImmutableValue()를 호출할 때 다른 스레드에서 값을 변경한다면 제대로된 값을 얻을 수 없다.
    // 따라서 동기화 문제가 발생한다. -> getImmutableValue()는 임계 영역에 해당한다.
    // 문제가 없이 바꾸려면, 안전한 임계 영역을 만들어야한다.
    // public synchronized int getImmutableValue(){return immutableValue;} -> 이렇게 해결!!!

    // 답: 이라고 생각했지만, immutableValue는 멤버변수로 공유 자원이 맞지만, 여기에는 공유 자원을 변경하는 방법이 존재하지 않는다.
    // 공유 자원을 사용하는 중에 다른 스레드에서 값을 변경하는 게 데이터의 일관성을 깨고, 경합 조건을 만든다.
    // 즉, 데이터 값이 변경 되지 않는다면, 문제가 되지 않는다.
    // 여기서 공유 자원에 final이 붙어서 공유 자원의 값이 변경될 일이 없다.
    // final이 붙은 멤버 변수, immutableValue는 안전한 공유 자원이다.

    private final int immutableValue;

    public SyncTest3Main(int immutableValue) {
        this.immutableValue = immutableValue;
    }

    public int getImmutableValue() {
        return immutableValue;
    }
}
