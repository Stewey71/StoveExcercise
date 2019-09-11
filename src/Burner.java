
public class Burner {
	Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		tempChange = false;
		myTimer = 0;
	}
	public enum Temperature{
		BLAZING("VERY HOT! DO NOT TOUCH"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
		private String settingValue;
		
		Temperature(String myValue){
			settingValue = myValue;
		}
		
		public String toString() {
			return settingValue;
		}
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
					myTimer = 2;
					break;
				case LOW:
					myTemperature = myTemperature.WARM;
					myTimer = 2;
					break;
				case MEDIUM:
					myTemperature = myTemperature.WARM;
					myTimer = 2;
					break;
				case HIGH:
					myTemperature = myTemperature.WARM;
					myTimer = 2;
					break;
				}
				break;
			case WARM:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.COLD;
					myTimer = 2;
					break;
				case LOW:
					myTimer = 2;
					break;
				case MEDIUM:
					myTemperature = myTemperature.HOT;
					myTimer = 2;
					break;
				case HIGH:
					myTemperature = myTemperature.HOT;
					myTimer = 2;
					break;
				}
				break;
			case HOT:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.WARM;
					myTimer = 2;
					break;
				case LOW:
					myTemperature = myTemperature.WARM;
					myTimer = 2;
					break;
				case MEDIUM:
					myTimer = 2;
					break;
				case HIGH:
					myTemperature = myTemperature.BLAZING;
					myTimer = 2;
					break;
				}
				break;
			case BLAZING:
				switch(mySetting) {
				case OFF:
					myTemperature = myTemperature.HOT;
					myTimer = 2;
					break;
				case LOW:
					myTemperature = myTemperature.HOT;
					myTimer = 2;
					break;
				case MEDIUM:
					myTemperature = myTemperature.HOT;
					myTimer = 2;
					break;
				case HIGH:
					myTimer = 2;
					break;
				}
				break;
			}
		}
	}

	public Temperature getMyTemperature() {
		return myTemperature;
	}

	@Override
	public String toString() {
		return "[" + mySetting.toString() + "]....." + myTemperature.toString();
	}




}
