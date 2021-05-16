package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    User u;
    ArrayList<User> ulist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        for (int i = 0 ; i < 20; i++){
            u = new User();
            u.description = "Description" + new Random().nextInt();
            u.name = "Name" + new Random().nextInt();
            u.followed = new Random().nextBoolean();
            u.id = i;
            ulist.add(u);
        }

        RecyclerView recyclerViewUser = findViewById(R.id.recycleView);
        SimpleAdapter sAdapter = new SimpleAdapter(ulist);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(sLayoutManager);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.setAdapter(sAdapter);


        /*ImageView img = findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Image clicked");

                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Profile")
                        .setMessage(u.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(ListActivity.this, MainActivity.class);
                                viewProfile.putExtra("id", new Random().nextInt());
                                startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });*/

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "restart");
    }

    private void userQuery(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness");
        builder.setTitle("Profile");
        //if setcancelable is set to true, clicking anywhere else on the screen allows the pop up to disappear
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                int randomNo = randomNumber();
                intent.putExtra("Number",randomNo);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private int randomNumber(){
        Random ran = new Random();
        int randomVal = ran.nextInt(999999999);
        return randomVal;
    }
}