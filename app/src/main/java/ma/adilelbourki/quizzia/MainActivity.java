package ma.adilelbourki.quizzia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.ArrayList;

import ma.adilelbourki.quizzia.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button buttonFalse;
        private Button buttonTrue;
        private Button buttonNext;
        private Button buttonPrevious;
        private TextView questionTextView;
        private TextView questionNumber;
        private TextView questionTotal;
        private int currentIndex = 0;
    private Question question = new Question();

    private RequestQueue queue;
      String url ="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
      private ArrayList<Question> questionArrayList = new ArrayList<>();
//     String url ="https://jsonplaceholder.typicode.com/posts/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonFalse = findViewById(R.id.false_button);
        buttonTrue = findViewById(R.id.true_button);
        buttonNext = findViewById(R.id.next_button);
        buttonPrevious = findViewById(R.id.previous_button);
        questionTextView = findViewById(R.id.question_id);
        questionNumber = findViewById(R.id.question_number);
        questionTotal = findViewById(R.id.question_total);

        buttonFalse.setOnClickListener(this);
        buttonTrue.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

        queue = Volley.newRequestQueue(this);
     JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
         @Override
         public void onResponse(JSONArray response) {
             for (int i =0;i<response.length();i++){
                 try {
                     question.setAnswer(response.getJSONArray(i).get(0).toString());
                     question.setTrue(response.getJSONArray(i).getBoolean(1));
//                     JSONArray jsonArray = response.getJSONArray(i);
//                     Log.d("questions","questions : "+" "+response.getJSONArray(i).get(0));
//                     Log.d("questions","answer : "+" "+ i +" "+response.getJSONArray(i).get(1));
                     questionArrayList.add(question);
                     Log.d("arraylist","answer :"+question.getAnswer());
                     Log.d("arraylist","isTrue :" +question.isTrue());

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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.true_button :
                Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
                break;
            case R.id.false_button:
                Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
                break;
            case R.id.previous_button:
                Toast.makeText(this, "previous", Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_button:
                Toast.makeText(this, "next", Toast.LENGTH_SHORT).show();
                currentIndex++;
                if(currentIndex<= questionArrayList.size())currentIndex = 0;

                break;
        }
    }
}
