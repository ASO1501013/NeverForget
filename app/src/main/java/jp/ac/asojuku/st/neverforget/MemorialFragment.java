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
 * Use the {@link MemorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MemorialFragment extends Fragment {
    public static MemorialFragment newInstance(Context context) {
        MemorialFragment f = new MemorialFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_memorial,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial", Context.MODE_PRIVATE);
        String wedding = prefs.getString("wedding", null);
        String birthday = prefs.getString("birthday", null);
        String birthday1 = prefs.getString("birthday1", null);
        String birthday2 = prefs.getString("birthday2", null);
        String birthday3 = prefs.getString("birthday3", null);
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        if(wedding != null){
            editText1.setText(wedding);
        }
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        if(birthday != null){
            editText2.setText(birthday);
        }
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        if(birthday1 != null){
            editText3.setText(birthday1);
        }
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);
        if(birthday2 != null){
            editText4.setText(birthday2);
        }
        EditText editText5 = (EditText)getView().findViewById(R.id.editText5);
        if(birthday3 != null){
            editText5.setText(birthday3);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);
        EditText editText5 = (EditText)getView().findViewById(R.id.editText5);

        String wedding;
        try{
            wedding = editText1.getText().toString();
        }catch (NumberFormatException e){
            wedding = null;
        }

        String birthday;
        try{
            birthday = editText2.getText().toString();
        }catch (NumberFormatException e){
            birthday = null;
        }

        String birthday1;
        try{
            birthday1 = editText3.getText().toString();
        }catch (NumberFormatException e){
            birthday1 = null;
        }

        String birthday2;
        try{
            birthday2 = editText4.getText().toString();
        }catch (NumberFormatException e){
            birthday2 = null;
        }

        String birthday3;
        try{
            birthday3 = editText5.getText().toString();
        }catch (NumberFormatException e){
            birthday3 = null;
        }

        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("wedding",wedding);
        editor.putString("birthday",birthday);
        editor.putString("birthday1",birthday1);
        editor.putString("birthday2",birthday2);
        editor.putString("birthday3",birthday3);
        //editor.comit();
        editor.apply();

    }

}
