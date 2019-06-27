package retrofit.learn;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import retrofit.learn.adapter.FaceAdapter;
import retrofit.learn.model.Box;
import retrofit.learn.model.Login;
import retrofit.learn.model.User;
import retrofit.learn.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

private  static Tag TAG;
    private static String token;
    private static String tokentype;

/*

    OkHttpClient client = new OkHttpClient.Builder().addInterceptor( new Interceptor () {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", "bearer " + token1)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();
*/


    Retrofit.Builder builder = new Retrofit.Builder ().baseUrl ( "http://13.211.17.77:5000/" )
            .addConverterFactory ( GsonConverterFactory.create () );

    Retrofit retrofit = builder.build ();
    ApiInterface apiInterface = retrofit.create ( ApiInterface.class );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        Button b1, b2;
        b1 = findViewById ( R.id.login );
        b2 = findViewById ( R.id.secrete );


        b1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Login1 ();
            }
        } );


        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager ( getApplicationContext () );
        //


        b2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                getSecret1 ();
//                initVies();
            }
        } );

        /*

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext ());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

*/
    }







//        recyclerView.setHasFixedSize ( true );
      //  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager ( getApplicationContext () );
       // recyclerView.setLayoutManager ( layoutManager );

/*
    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "http//:api.learn2crack.com" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        RequestInterface request = retrofit.create ( RequestInterface.class );
        Call<List<Box>> call = request.getJSON ();
        call.enqueue ( new Callback<List<Box>> () {
            @Override
            public void onResponse(Call<List<Box>> call, Response<List<Box>> response) {

                List<Box> List<Box> = response.body ();
                data = new ArrayList<> ( Arrays.asList ( List<Box>.getAndroid () ) );
                adapter = new DataAdapter ( data );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onFailure(Call<List<Box>> call, Throwable t) {
                Log.d ( "Error", t.getMessage () );
            }
        } );
    }

*/


    private void getSecret1() {

        Call<List<Box>> call = apiInterface.secret ("Bearer "+token,"TestCollection","200");
        call.enqueue ( new Callback<List<Box>> () {
            @Override
            public void onResponse(Call<List<Box>> call, Response<List<Box>> response) {
                if (response.isSuccessful ()) {

              Box box=new Box ();
              //String string=     box.getExternalImageId ();

                  List<List<Box>> movies = Arrays.asList ( response.body () );
                  movies.toArray ();


                    //recyclerView.setAdapter(new FaceAdapter (movies, getApplicationContext()));
                    Log.d ( "\nRESPONSE :",response.body ().toString ()+"\n" );
                    Toast.makeText ( getApplicationContext (),"response Successfull "+response.body ().toArray (),Toast.LENGTH_SHORT ).show (); }
                else {
                    Toast.makeText ( getApplicationContext (),"response  not Successfull ",Toast.LENGTH_SHORT ).show (); }
            }
            @Override
            public void onFailure(Call<List<Box>> call, Throwable t) {

                Toast.makeText ( getApplicationContext (),"error :( ",Toast.LENGTH_SHORT ).show ();
            }
        } );
    }



    
    private void Login1() {


        Login login = new Login ();
        login.setPassword ( "my360face" );
        login.setUsernameOrEmail ( "my360face" );

        Call<User> call = apiInterface.login
                ( "Bearer jshdufhakjsdhfuosjtloah.eyJzdWIiOiIzOCIsImlhdCI6MTU2MDIzNjkxNywiZXhwIjoxNTYwODQxNzE3fQ.usdhfgkjhkhKJIIUGIUGiuhdifuguGGihgigiUIGIUHidfishfOIGIUG0734", login );
        call.enqueue ( new Callback<User> () {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful ()) {
                    token = response.body ().getAccessToken ();
                    tokentype = response.body ().getTokenType ();
                    Toast.makeText ( getApplicationContext (), response.body ().getAccessToken (),
                            Toast.LENGTH_SHORT ).show ();

                    // token=response.body ().getAccessToken ();

                    
                    
                } else {
                    Toast.makeText ( getApplicationContext (), "Not Successful", Toast.LENGTH_SHORT ).show ();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText ( getApplicationContext (), "Error :(", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }


}