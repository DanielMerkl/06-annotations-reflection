package ohm.softa.a06.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.ApiResult;
import ohm.softa.a06.model.Joke;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter<Joke> {
	private final Gson gson = new Gson();

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {
		// not needed for this assignment
	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		ApiResult<Joke> result = gson.fromJson(in, ApiResult.class);

		String type = result.getType();
		if (!type.equals("success")) {
			throw new IOException();
		}

		return result.getValue();
	}

//	@Override
//	public Joke read(JsonReader in) throws IOException {
//		Joke result = null;
//
//		while (in.hasNext()) {
//			switch (in.nextName()) {
//				case "type":
//					String type = in.nextString();
//					if (!type.equals("success")) {
//						throw new IOException();
//					}
//					break;
//				case "value":
//					result = gson.fromJson(in, Joke.class);
//					break;
//			}
//		}
//
//		in.endObject();
//
//		return result;
//	}
}
