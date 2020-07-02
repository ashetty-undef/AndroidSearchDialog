package com.example.testsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    ArrayList<String> names;
    EditText sview;
    ListView lview,lvSuggestions;
    ArrayAdapter<String> snames;
    Dialog dialog;
    ArrayList<String> arrayList= new ArrayList<>();
    ArrayAdapter<String> adapter;
    String data  = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        final EditText sview = (EditText) findViewById(R.id.originsearch);
        dialog = new Dialog(this);


        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.searches);
        final Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);

        arrayList.add("January");
        arrayList.add("February");
        arrayList.add("March");
        arrayList.add("April");
        arrayList.add("May");
        arrayList.add("June");
        arrayList.add("July");
        arrayList.add("August");
        arrayList.add("September");
        arrayList.add("October");
        arrayList.add("November");
        arrayList.add("December");


        sview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.show();

                ImageView search_exit = (ImageView) dialog.findViewById(R.id.exit);
                search_exit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                ListView lview = (ListView) dialog.findViewById(R.id.list_words);
                final EditText etext = (EditText) dialog.findViewById(R.id.search_dialog);
                etext.setSelection(data.length());
                adapter = new ArrayAdapter<String>(dialog.getContext(),android.R.layout.simple_list_item_1,arrayList);
                lview.setAdapter(adapter);

                lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                        data = adapter.getItem(position);
                        etext.setText(data);
                        dialog.dismiss();
                    }
                });


                etext.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                            adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                sview.setText(data);
                sview.setSelection(data.length());
            }
        });

        dialog.setOnCancelListener(
                new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface d) {
                        dialog.dismiss();
                    }
                }
        );




//        names = new ArrayList<>();
//
//        names.add("Ramiz");
//        names.add("Belal");
//        names.add("Azad");
//        names.add("Manish");
//        names.add("Sunny");
//        names.add("Shahid");
//        names.add("Deepak");
//        names.add("Deepika");
//        names.add("Sumit");
//        names.add("Mehtab");
//        names.add("Vivek");
//
//        sview = (EditText) findViewById(R.id.calc_txt_Prise);
//        lview = (ListView) findViewById(R.id.listView1);
//
//        snames = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//
//        lview.setAdapter(snames);


    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // TODO Auto-generated method stub
//        menu.add("Search").setIcon(android.R.drawable.ic_menu_search).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getTitle().toString().equalsIgnoreCase("Search")){
//            showSearchDialog();
//        }
//        return true;
//    }
//
    private void showSearchDialog() {
        // TODO Auto-generated method stub
//        findDialogViews(dialog);
        dialog.show();
    }

//
//
//    private void findDialogViews(final Dialog dialog) {
//        // TODO Auto-generated method stub
//        lvSuggestions = (ListView)dialog.findViewById(R.id.listView1);
//        lvSuggestions.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) this);
//        final EditText etSearch = (EditText)dialog.findViewById(R.id.calc_txt_Prise);
//        etSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                snames.getFilter().filter(s);
//            }
//
//
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // TODO Auto-generated method stub
//            }
//        });
//    }

}
