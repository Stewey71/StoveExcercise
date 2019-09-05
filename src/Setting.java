
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String settingValue;
	
	Setting(String myValue){
		settingValue = myValue;
	}
	
	public String toString() {
		return settingValue;
	}

}
