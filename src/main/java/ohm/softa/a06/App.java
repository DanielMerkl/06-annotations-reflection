package ohm.softa.a06;

import ohm.softa.a06.model.Joke;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		// TODO fetch a random joke and print it to STDOUT
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://api.icndb.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
		ICNDBApi api = retrofit.create(ICNDBApi.class);

		Joke randomJoke = api
			.getRandomJoke()
			.execute()
			.body()
			.getValue();

		System.out.println("randomJoke = " + randomJoke.toString());

		Joke nerdyJoke = api
			.getRandomJoke(List.of("nerdy")
				.toArray(String[]::new))
			.execute()
			.body()
			.getValue();

		System.out.println("nerdyJoke = " + nerdyJoke);

		Joke[] jokes = api
			.getRandomJokes(3)
			.execute()
			.body()
			.getValue();

		System.out.println("jokes.length = " + jokes.length);

		Joke jokeWithId1 = api
			.getJokeById(1)
			.execute()
			.body()
			.getValue();

		System.out.println("jokeWithId1 = " + jokeWithId1);
	}

}
