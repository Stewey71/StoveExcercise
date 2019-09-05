
public class Burner {
	Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	public enum Temperature{
		BLAZING, HOT, WARM, COLD
	}

	private Temperature myTemperature;
	private Setting mySetting;
	private int myTimer;
	public static final int TIME_DURATION = 2;

	void plusButton() {
		myTimer = TIME_DURATION;
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			break;
		}
	}

	void minusButton() {
		myTimer = TIME_DURATION;
		switch(mySetting) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		}

	}




}
