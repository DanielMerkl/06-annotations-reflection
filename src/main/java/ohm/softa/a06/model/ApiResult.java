package ohm.softa.a06.model;

public class ApiResult<T> {
	private final String type;
	private final T value;

	public ApiResult(String type, T value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public T getValue() {
		return value;
	}
}
