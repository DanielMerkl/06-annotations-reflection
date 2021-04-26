package ohm.softa.a06;

import ohm.softa.a06.model.ApiResult;
import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {

	@GET("/jokes/random")
	Call<ApiResult<Joke>> getRandomJoke();

	@GET("/jokes/random")
	Call<ApiResult<Joke>> getRandomJoke(@Query("limitTo") String[] categoriesToInclude);

	@GET("/jokes/random/{count}")
	Call<ApiResult<Joke[]>> getRandomJokes(@Path("count") int count);

	@GET("/jokes/{id}")
	Call<ApiResult<Joke>> getJokeById(@Path("id") int id);
}
