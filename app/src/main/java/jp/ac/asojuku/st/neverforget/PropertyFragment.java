package jp.ac.asojuku.st.neverforget;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PropertyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropertyFragment extends Fragment {
    public static PropertyFragment newInstance(Context context) {
        PropertyFragment f = new PropertyFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        String car_number = prefs.getString("car_number", null);
        String phone_number = prefs.getString("phone_number", null);
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        if(car_number != null){
            editText1.setText(car_number);
        }
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        if(phone_number != null){
            editText2.setText(phone_number);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);

        String car_number;
        try{
            car_number = editText1.getText().toString();
        }catch (NumberFormatException e){
            car_number = null;
        }

        String phone_number;
        try{
            phone_number = editText2.getText().toString();
        }catch (NumberFormatException e){
            phone_number = null;
        }

        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("car_number",car_number);
        editor.putString("phone_number",phone_number);
        //editor.comit();
        editor.apply();

    }

}
