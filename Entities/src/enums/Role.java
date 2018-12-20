package enums;

public enum Role {

	USER(1),

	ADMIN(2);

	private int code;

	private Role(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}	

}
