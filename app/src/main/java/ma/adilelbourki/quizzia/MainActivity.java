package ma.adilelbourki.quizzia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

   private RequestQueue queue;
      String url ="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

//     String url ="https://jsonplaceholder.typicode.com/posts/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
     JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
         @Override
         public void onResponse(JSONArray response) {
             for (int i =0;i<response.length();i++){
                 try {
                     JSONArray jsonArray = response.getJSONArray(i);
                     Log.d("questions","question : "+" "+ i +" "+jsonArray.get(0));
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
             }
         }
     }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {

         }
     });

       queue.add(jsonArrayRequest);

   }
}
