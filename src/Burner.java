
public class Burner {
	Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		tempChange = false;
		myTimer = 0;
	}
	public enum Temperature{
		BLAZING, HOT, WARM, COLD
	}

	private Temperature myTemperature;
	private Setting mySetting;
	private int myTimer;
	private boolean tempChange;
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
		tempChange = true;
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
		tempChange = true;

	}
	
	void updateTemperature() {
		--myTimer;
		if(myTimer == 0) {
			switch(myTemperature) {
			case COLD:
				switch(mySetting) {
				case OFF:
					break;
				case LOW:
					myTemperature = myTemperature.WARM;
					break;
				case MEDIUM:
					myTemperature = myTemperature.WARM;
					break;
				case HIGH:
					myTemperature = myTemperature.WARM;
					break;
				}
				break;
			case WARM:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.COLD;
					break;
				case LOW:
					break;
				case MEDIUM:
					myTemperature = myTemperature.HOT;
					break;
				case HIGH:
					myTemperature = myTemperature.HOT;
					break;
				}
				break;
			case HOT:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.WARM;
					break;
				case LOW:
					myTemperature = myTemperature.WARM;
					break;
				case MEDIUM:
					break;
				case HIGH:
					myTemperature = myTemperature.BLAZING;
					break;
				}
				break;
			case BLAZING:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.HOT;
					break;
				case LOW:
					myTemperature = myTemperature.HOT;
					break;
				case MEDIUM:
					myTemperature = myTemperature.HOT;
					break;
				case HIGH:
					break;
				}
				break;
			}
		}
	}




}
