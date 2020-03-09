package designepam.designtask;

public class StatePattern {
	static class FanControl {
	private SpeedLevel current;

	public FanControl() {
		current = new Off();
	}

	public void set_state(SpeedLevel state) {
		current = state;
	}

	public void rotate() {
		current.rotate(this);
	}

	
	public String toString() {
		return String.format("FanControl [current=%s]", current);
	}
}

interface SpeedLevel {
	void rotate(FanControl fanControl);
}

static class Off implements SpeedLevel {
	public void rotate(FanControl fanControl) {
		fanControl.set_state(new SpeedLevel1());
	}
}

static class SpeedLevel1 implements SpeedLevel {
	public void rotate(FanControl fanControl) {
		fanControl.set_state(new SpeedLevel2());
	}
}

static class SpeedLevel2 implements SpeedLevel {
	public void rotate(FanControl fanControl) {
		fanControl.set_state(new SpeedLevel3());
	}
}

static class SpeedLevel3 implements SpeedLevel {
	public void rotate(FanControl fanControl) {
		fanControl.set_state(new Off());
	}
}

public static void main(String[] args) {
	FanControl fanControl = new FanControl();
	System.out.println(fanControl);
	fanControl.rotate();
	System.out.println(fanControl);
	fanControl.rotate();
	System.out.println(fanControl);
	fanControl.rotate();
	System.out.println(fanControl);
	fanControl.rotate();
	
}
}
