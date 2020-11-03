//package ma.adilelbourki.quizzia.data;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import ma.adilelbourki.quizzia.model.Question;
//
//public class QuestionBank {
//    ArrayList<Question>questionArrayList = new ArrayList<>();
//    private  String url="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
//
//    public List<Question> getQuestions(){
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "", null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                try {
//                    JSONObject jsonObject = response.getJSONObject(1);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                    }
//                }
//        );
//
//    }
//    }
//
//
//}
